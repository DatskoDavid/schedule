package com.example.schedule.service.group;

import com.example.schedule.DTO.group.req.GroupCreate;
import com.example.schedule.DTO.group.req.GroupUpdate;
import com.example.schedule.DTO.group.resp.GroupDTO;
import com.example.schedule.model.Group;
import org.springframework.data.domain.Page;

public interface IGroupService {

    Group create (Group group);

    Group update (Group group);

    GroupDTO createDTO(GroupCreate entity);
    GroupDTO updateDTO(GroupUpdate entity);

    GroupDTO getById(Long id);

    Page<GroupDTO> getAll(Integer page, Integer size);

    String convertToDTOString(Long groupsId);



}
