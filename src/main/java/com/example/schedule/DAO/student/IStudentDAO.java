package com.example.schedule.DAO.student;

import com.example.schedule.model.Students;
import org.springframework.stereotype.Service;

@Service
public interface IStudentDAO {

    Students create (Students student);

    Students update (Students student);

}
