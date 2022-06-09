package com.example.schedule.DAO.teacher;

import com.example.schedule.model.Teacher;
import com.example.schedule.repository.TeacherRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherDAOImpl implements ITeacherDAO{

    @Autowired
    TeacherRep repository;

    @Override
    public Teacher create(Teacher teacher) {

        Long id = (long) (repository.findAll()
                .stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        teacher.setId(id);

        repository.save(teacher);

        return teacher;
    }

    @Override
    public Teacher update(Teacher teacher) {

        teacher.setId(teacher.getId());

        repository.save(teacher);

        return teacher;
    }
}
