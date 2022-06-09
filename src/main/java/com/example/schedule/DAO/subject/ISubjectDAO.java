package com.example.schedule.DAO.subject;

import com.example.schedule.model.Subject;
import org.springframework.stereotype.Service;

@Service
public interface ISubjectDAO {

    Subject create (Subject subject);

    Subject update (Subject subject);

}
