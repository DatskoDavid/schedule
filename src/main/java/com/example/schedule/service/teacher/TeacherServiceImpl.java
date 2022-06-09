package com.example.schedule.service.teacher;

import com.example.schedule.DAO.teacher.TeacherDAOImpl;
import com.example.schedule.DTO.teacher.req.TeacherCreate;
import com.example.schedule.DTO.teacher.req.TeacherUpdate;
import com.example.schedule.DTO.teacher.resp.TeacherDTO;
import com.example.schedule.model.Teacher;
import com.example.schedule.repository.TeacherRep;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements ITeacherService{

    private final TeacherDAOImpl dao;

    private final TeacherRep rep;

    @Override
    public Teacher create(Teacher teacher) {
        return dao.create(teacher);
    }

    @Override
    public Teacher update(Teacher teacher) {
        return dao.update(teacher);
    }

    @Override
    public TeacherDTO createDTO(TeacherCreate entity) {

        Long id = (long) (rep.findAll().stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        return convertToDTO(
                rep.save(Teacher.builder()
                                .id(id)
                                .name(entity.getName())
                                .address(entity.getAddress())
                                .position(entity.getPosition())
                        .build())
        );
    }

    @Override
    public TeacherDTO updateDTO(TeacherUpdate entity) {

        Teacher teacher = rep.getById(entity.getId());

        return convertToDTO(
                rep.save(
                        Teacher.builder()
                                .id(teacher.getId())
                                .name(entity.getName())
                                .address(entity.getAddress())
                                .position(entity.getPosition())
                                .build()
                )
        );
    }

    @Override
    public String convertToDTOString(Long teachersId) {
        try {
            Teacher teacher = rep.getById(teachersId);
            return convertToDTO(teacher).toString();
        }catch (Exception e){
            return "-DELETED Teacher-";
        }
    }

    @Override
    public TeacherDTO getById(Long id) {
        return convertToDTO(rep.getById(id));
    }

    @Override
    public Page<TeacherDTO> getAll(Integer page, Integer size) {

        Page<Teacher> teachers = rep.findAll(PageRequest.of(page, size));

        var teachersDTOs = teachers.get().map(this::convertToDTO).collect(Collectors.toList());

        return new PageImpl<TeacherDTO>(teachersDTOs);
    }

    private TeacherDTO convertToDTO(Teacher entity){
        return TeacherDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .address(entity.getAddress())
                .position(entity.getPosition())
                .build();
    }


  /*  public Teacher createDTO(TeacherDTOCreate request) {

        Long id = (long) (rep.findAll().stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        var teacher = Teacher.builder()
                .id(id)
                .name(request.getName())
                .address(request.getAddress())
                .position(request.getPosition())
                .build();

        return rep.save(teacher);

    }

    public Teacher updateDTO(TeacherDTOUpdate request) {

        var teacher = Teacher.builder()
                .id(rep.findById(request.getId()).get().getId())
                .name(request.getName())
                .address(request.getAddress())
                .position(request.getPosition())
                .build();

        return rep.save(teacher);

    }*/




}
