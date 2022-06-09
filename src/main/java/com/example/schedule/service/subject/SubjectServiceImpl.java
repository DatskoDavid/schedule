package com.example.schedule.service.subject;

import com.example.schedule.DAO.subject.SubjectDAOImpl;
import com.example.schedule.DTO.subject.req.SubjectCreate;
import com.example.schedule.DTO.subject.req.SubjectUpdate;
import com.example.schedule.DTO.subject.resp.SubjectDTO;
import com.example.schedule.model.Subject;
import com.example.schedule.repository.SubjectRep;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements ISubjectService{

    private final SubjectDAOImpl dao;

    private final SubjectRep rep;


    @Override
    public Subject create(Subject subject) {
        return dao.create(subject);
    }

    @Override
    public Subject update(Subject subject) {
        return dao.update(subject);
    }

    @Override
    public SubjectDTO createDTO(SubjectCreate entity) {

        Long id = (long) (rep.findAll().stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        return convertToDTO(
                rep.save(Subject.builder()
                                .id(id)
                                .name(entity.getName())
                                .numberOfHours(entity.getNumberOfHours())
                                .finalControl(entity.getFinalControl())
                        .build())
        );
    }

    @Override
    public SubjectDTO updateDTO(SubjectUpdate entity) {

        Subject subject = rep.getById(entity.getId());

        return convertToDTO(
                rep.save(
                        Subject.builder()
                                .id(subject.getId())
                                .name(entity.getName())
                                .numberOfHours(entity.getNumberOfHours())
                                .finalControl(entity.getFinalControl())
                                .build()
                )
        );
    }

    @Override
    public String convertToDTOString(Long subjectsId) {
        try {
            Subject subject = rep.getById(subjectsId);
            return convertToDTO(subject).toString();
        }catch (Exception e){
            return "-DELETED Subject-";
        }
    }

    @Override
    public SubjectDTO getById(Long id) {
        return convertToDTO(rep.getById(id));
    }

    @Override
    public Page<SubjectDTO> getAll(Integer page, Integer size) {

        Page<Subject> subjects = rep.findAll(PageRequest.of(page, size));

        var subjectsDTOs = subjects.get().map(this::convertToDTO).collect(Collectors.toList());

        return new PageImpl<SubjectDTO>(subjectsDTOs);
    }

    private SubjectDTO convertToDTO(Subject entity){
        return SubjectDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .numberOfHours(entity.getNumberOfHours())
                .finalControl(entity.getFinalControl())
                .build();
    }

/*
    public Subject createDTO(SubjectDTOCreate request) {

        Long id = (long) (rep.findAll().stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        var subject = Subject.builder()
                .id(id)
                .numberOfHours(request.getNumberOfHours())
                .finalControl(request.getFinalControl())
                .build();

        return rep.save(subject);

    }

    public Subject updateDTO(SubjectDTOUpdate request) {

        var subject = Subject.builder()
                .id(rep.findById(request.getId()).get().getId())
                .numberOfHours(request.getNumberOfHours())
                .finalControl(request.getFinalControl())
                .build();

        return rep.save(subject);

    }*/
}
