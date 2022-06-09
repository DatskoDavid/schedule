package com.example.schedule.DAO.teacher;

import com.example.schedule.model.Teacher;
import org.springframework.stereotype.Service;

@Service
public interface ITeacherDAO {

    Teacher create (Teacher teacher);

    Teacher update (Teacher teacher);

}
