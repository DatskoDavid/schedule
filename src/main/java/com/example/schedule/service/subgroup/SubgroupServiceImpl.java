package com.example.schedule.service.subgroup;


import com.example.schedule.DAO.subgroup.SubgroupDAOImpl;
import com.example.schedule.DTO.subGroup.req.SubGroupCreate;
import com.example.schedule.DTO.subGroup.req.SubGroupUpdate;
import com.example.schedule.DTO.subGroup.resp.SubGroupDTO;
import com.example.schedule.model.Students;
import com.example.schedule.model.Subgroup;
import com.example.schedule.repository.StudentRep;
import com.example.schedule.repository.SubgroupRep;
import com.example.schedule.service.student.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubgroupServiceImpl implements ISubgroupService{

    private final SubgroupDAOImpl dao;

    private final IStudentService studentService;

    private final SubgroupRep rep;

    private final StudentRep studentRep;

    @Override
    public Subgroup create(Subgroup subgroup) {
        return dao.create(subgroup);
    }

    @Override
    public Subgroup update(Subgroup subgroup) {
        return dao.update(subgroup);
    }

    @Override
    public SubGroupDTO createDTO(SubGroupCreate entity) {

        Long id = (long) (rep.findAll().stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        return convertToDTO(
                rep.save(Subgroup.builder()
                                .id(id)
                                .name(entity.getName())
                                .faculty(entity.getFaculty())
                                .course(entity.getCourse())
                                .numberOfStudents(entity.getNumberOfStudents())
                                .studentsSubgroup(Students.builder()
                                        .id(entity.getStudentId())
                                        .build())
                        .build())
        );

    }

    @Override
    public SubGroupDTO updateDTO(SubGroupUpdate entity) {

        Subgroup subgroup = rep.getById(entity.getId());

        return convertToDTO(
                rep.save(
                        Subgroup.builder()
                                .id(entity.getId())
                                .name(entity.getName())
                                .faculty(entity.getFaculty())
                                .course(entity.getCourse())
                                .numberOfStudents(entity.getNumberOfStudents())
                                .studentsSubgroup(subgroup.getStudents())
                                .build()
                )
        );
    }

    @Override
    public SubGroupDTO get(Long id) {
        return convertToDTO(rep.getById(id));
    }

    @Override
    public String convertToDTOString(Long subgroupsId) {
        try {
            Subgroup subgroup = rep.getById(subgroupsId);
            return convertToDTO(subgroup).toString();
        }catch (Exception e){
            return "-DELETED SUBGROUP-";
        }
    }

    @Override
    public Page<SubGroupDTO> getAll(Integer page, Integer size) {

        Page<Subgroup> subgroups = rep.findAll(PageRequest.of(page,size));

        var subgroupsDTOs = subgroups.get().map(this::convertToDTO).collect(Collectors.toList());

        return new PageImpl<SubGroupDTO>(subgroupsDTOs);
    }

    private SubGroupDTO convertToDTO(Subgroup entity){
        return SubGroupDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .faculty(entity.getFaculty())
                .course(entity.getCourse())
                .numberOfStudents(entity.getNumberOfStudents())
                .studentId(studentService.convertToDTOString(entity.getStudents().getId()))
                .build();
    }



 /*   public Subgroup createDTO(SubgroupDTOCreate request) {

        Long id = (long) (rep.findAll().stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        var subgroup = Subgroup.builder()
                .id(id)
                .name(request.getName())
                .faculty(request.getFaculty())
                .course(request.getCourse())
                .numberOfStudents(request.getNumberOfStudents())
                .studentsSubgroup(studentRep.findById(request.getStudents()).get())
                .build();

        return rep.save(subgroup);

    }

    public Subgroup updateDTO(SubgroupDTOUpdate request) {

        var subgroup = Subgroup.builder()
                .id(rep.findById(request.getId()).get().getId())
                .name(request.getName())
                .faculty(request.getFaculty())
                .course(request.getCourse())
                .numberOfStudents(request.getNumberOfStudents())
                .studentsSubgroup(studentRep.findById(request.getStudents()).get())
                .build();

        return rep.save(subgroup);

    }*/



}
