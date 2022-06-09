package com.example.schedule.DAO.subject;

import com.example.schedule.model.Subject;
import com.example.schedule.repository.SubjectRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectDAOImpl implements ISubjectDAO{

    @Autowired
    SubjectRep repository;

    @Override
    public Subject create(Subject subject) {

        Long id = (long) (repository.findAll()
                .stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        subject.setId(id);

        repository.save(subject);
        return subject;
    }

    @Override
    public Subject update(Subject subject) {

        subject.setId(subject.getId());

        repository.save(subject);

        return subject;
    }
}
