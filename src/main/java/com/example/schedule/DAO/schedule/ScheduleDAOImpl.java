package com.example.schedule.DAO.schedule;

import com.example.schedule.model.Schedule;
import com.example.schedule.repository.ScheduleRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleDAOImpl implements IScheduleDAO{

    @Autowired
    ScheduleRep repository;


    @Override
    public Schedule create(Schedule schedule) {

        Long id = (long) (repository.findAll()
                .stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        schedule.setId(id);

        repository.save(schedule);
        return schedule;
    }

    @Override
    public Schedule update(Schedule schedule) {

        schedule.setId(schedule.getId());

        repository.save(schedule);

        return schedule;
    }
}
