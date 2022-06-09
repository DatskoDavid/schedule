package com.example.schedule.repository;

import com.example.schedule.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRep  extends JpaRepository<Schedule, Long> {
}
