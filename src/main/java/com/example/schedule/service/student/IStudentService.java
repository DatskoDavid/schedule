package com.example.schedule.service.student;

import com.example.schedule.DTO.student.req.StudentsCreateDTO;
import com.example.schedule.DTO.student.req.StudentsUpdateDTO;
import com.example.schedule.DTO.student.resp.StudentDTO;
import com.example.schedule.model.Students;
import org.springframework.data.domain.Page;

public interface IStudentService {

    Students create (Students student);

    Students update (Students student);

    String convertToDTOString(Long studentId);

    StudentDTO createDTO(StudentsCreateDTO entity);
    StudentDTO updateDTO(StudentsUpdateDTO entity);

    StudentDTO getById(Long id);

    Page<StudentDTO> getAll(Integer page, Integer size);

}
