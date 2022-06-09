package com.example.schedule.service.student;

import com.example.schedule.DAO.student.StudentDAOImpl;
import com.example.schedule.DTO.student.req.StudentsCreateDTO;
import com.example.schedule.DTO.student.req.StudentsUpdateDTO;
import com.example.schedule.DTO.student.resp.StudentDTO;
import com.example.schedule.model.Students;
import com.example.schedule.repository.StudentRep;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentsServiceImpl implements IStudentService{


    private final StudentDAOImpl dao;

    private final StudentRep rep;


    @Override
    public Students create(Students student) {
        return dao.create(student);
    }

    @Override
    public Students update(Students student) {
        return dao.update(student);
    }

    @Override
    public String convertToDTOString(Long studentId) {

        try{
            Students students = rep.getById(studentId);
            return convertToDTO(students).toString();
        }catch (Exception e){
            return "-DELETED STUDENT-";
        }
    }

    @Override
    public StudentDTO createDTO(StudentsCreateDTO entity) {

        Long id = (long) (rep.findAll().stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        return convertToDTO(
                rep.save(Students.builder()
                                .id(id)
                                .name(entity.getName())
                                .address(entity.getAddress())
                                .tel(entity.getTel())
                                .specialization(entity.getSpecialization())
                        .build())
        );
    }

    @Override
    public StudentDTO updateDTO(StudentsUpdateDTO entity) {

        Students students = rep.getById(entity.getId());

        return convertToDTO(
                rep.save(
                        Students.builder()
                                .id(students.getId())
                                .name(entity.getName())
                                .address(entity.getAddress())
                                .tel(entity.getTel())
                                .specialization(entity.getSpecialization())
                                .build()
                )
        );


    }

    @Override
    public StudentDTO getById(Long id) {
        return convertToDTO(rep.getById(id));
    }

    @Override
    public Page<StudentDTO> getAll(Integer page, Integer size) {

        Page<Students> students = rep.findAll(PageRequest.of(page,size));

        var studentsDTOs = students.get().map(this::convertToDTO).collect(Collectors.toList());

        return new PageImpl<StudentDTO>(studentsDTOs);
    }

    public StudentDTO convertToDTO(Students entity){
        return StudentDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .address(entity.getAddress())
                .tel(entity.getTel())
                .specialization(entity.getSpecialization())
                .build();
    }







}


