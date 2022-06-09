package com.example.schedule.DAO.student;

import com.example.schedule.model.Students;
import com.example.schedule.repository.StudentRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentDAOImpl implements IStudentDAO{

    @Autowired
    StudentRep repository;

    @Override
    public Students create(Students student) {

        Long id = (long) (repository.findAll()
                .stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        student.setId(id);
        repository.save(student);

        return student;
    }

    @Override
    public Students update(Students student) {

        student.setId(student.getId());
        repository.save(student);

        return student;
    }
}
