package com.example.schedule.service.subject;

import com.example.schedule.DTO.subject.req.SubjectCreate;
import com.example.schedule.DTO.subject.req.SubjectUpdate;
import com.example.schedule.DTO.subject.resp.SubjectDTO;
import com.example.schedule.model.Subject;
import org.springframework.data.domain.Page;

public interface ISubjectService {

    Subject create (Subject subject);

    Subject update (Subject subject);

    SubjectDTO createDTO(SubjectCreate entity);
    SubjectDTO updateDTO(SubjectUpdate entity);

    String convertToDTOString(Long subjectsId);

    SubjectDTO getById(Long id);

    Page<SubjectDTO> getAll(Integer page, Integer size);

}
