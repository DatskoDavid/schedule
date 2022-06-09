package com.example.schedule.service.schedule;

import com.example.schedule.DTO.schedule.req.ScheduleCreate;
import com.example.schedule.DTO.schedule.req.ScheduleUpdate;
import com.example.schedule.DTO.schedule.resp.ScheduleDTO;
import com.example.schedule.model.Schedule;
import org.springframework.data.domain.Page;

public interface IScheduleService {

    Schedule create (Schedule schedule);

    Schedule update (Schedule schedule);

    ScheduleDTO createDTO(ScheduleCreate entity);
    ScheduleDTO updateDTO(ScheduleUpdate entity);

    ScheduleDTO getById(Long id);

    Page<ScheduleDTO> getAll(Integer page, Integer size);

}
