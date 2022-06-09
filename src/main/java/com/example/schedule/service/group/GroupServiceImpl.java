package com.example.schedule.service.group;

import com.example.schedule.DAO.group.GroupDAOImpl;
import com.example.schedule.DTO.group.req.GroupCreate;
import com.example.schedule.DTO.group.req.GroupUpdate;
import com.example.schedule.DTO.group.resp.GroupDTO;
import com.example.schedule.model.Group;
import com.example.schedule.model.Subgroup;
import com.example.schedule.repository.GroupRep;
import com.example.schedule.repository.SubgroupRep;
import com.example.schedule.service.subgroup.ISubgroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements IGroupService{

    private final GroupDAOImpl dao;

    private final GroupRep rep;

    private final SubgroupRep subgroupRep;

    private final ISubgroupService subgroupService;



    @Override
    public Group create(Group group) {
        return dao.create(group);
    }

    @Override
    public Group update(Group group) {
        return dao.update(group);
    }

    @Override
    public GroupDTO createDTO(GroupCreate entity) {

        Long id = (long) (rep.findAll().stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        return convertToDTO(rep.save(Group.builder()
                        .id(id)
                        .numberOfGroup(entity.getNumberOfGroup())
                        .subgroups(Subgroup.builder()
                                .id(entity.getSubgroupsId())
                                .build())
                .build()));
    }

    @Override
    public GroupDTO updateDTO(GroupUpdate entity) {

        Group group = rep.getById(entity.getId());

        return convertToDTO(
                rep.save(
                        Group.builder()
                                .id(entity.getId())
                                .numberOfGroup(entity.getNumberOfGroup())
                                .subgroups(group.getSubgroups())
                                .build()
                )
        );
    }

    @Override
    public GroupDTO getById(Long id) {
        return convertToDTO(rep.getById(id));
    }

    @Override
    public Page<GroupDTO> getAll(Integer page, Integer size) {

        Page<Group> groups = rep.findAll(PageRequest.of(page, size));

        var groupsDTOs = groups.get().map(this::convertToDTO).collect(Collectors.toList());

        return new PageImpl<GroupDTO>(groupsDTOs);
    }


    @Override
    public String convertToDTOString(Long groupsId) {

        try {
            Group group = rep.getById(groupsId);
            return convertToDTO(group).toString();
        }catch (Exception e){
            return "-DELETED GROUP-";
        }
    }

    public GroupDTO convertToDTO(Group entity){
        return GroupDTO.builder()
                .id(entity.getId())
                .numberOfGroup(entity.getNumberOfGroup())
                .subgroupsId(subgroupService.convertToDTOString(entity.getSubgroups().getId()))
                .build();
    }


/*
    public Group createDTO(GroupDTOCreate request) {

        Long id = (long) (rep.findAll().stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        var group = Group.builder()
                .id(id)
                .numberOfGroup(request.getNumberOfGroup())
                .subgroups(subgroupRep.findById(request.getSubgroups()).get())
                .build();

        return rep.save(group);

    }

    public Group updateDTO(GroupDTOUpdate request) {

        var group = Group.builder()
                .id(rep.findById(request.getId()).get().getId())
                .numberOfGroup(request.getNumberOfGroup())
                .subgroups(subgroupRep.findById(request.getSubgroups()).get())
                .build();

        return rep.save(group);
    }*/
}
