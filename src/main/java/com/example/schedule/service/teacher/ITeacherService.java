package com.example.schedule.service.teacher;

import com.example.schedule.DTO.teacher.req.TeacherCreate;
import com.example.schedule.DTO.teacher.req.TeacherUpdate;
import com.example.schedule.DTO.teacher.resp.TeacherDTO;
import com.example.schedule.model.Teacher;
import org.springframework.data.domain.Page;

public interface ITeacherService {

    Teacher create (Teacher teacher);

    Teacher update (Teacher teacher);

    TeacherDTO createDTO(TeacherCreate entity);
    TeacherDTO updateDTO(TeacherUpdate entity);

    String convertToDTOString(Long teachersId);

    TeacherDTO getById(Long id);

    Page<TeacherDTO> getAll(Integer page, Integer size);

}
