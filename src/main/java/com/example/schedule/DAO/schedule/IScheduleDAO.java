package com.example.schedule.DAO.schedule;

import com.example.schedule.model.Schedule;
import org.springframework.stereotype.Service;

@Service
public interface IScheduleDAO {

    Schedule create (Schedule schedule);

    Schedule update (Schedule schedule);

}
