package com.example.schedule.repository;

import com.example.schedule.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRep extends JpaRepository<Students, Long> {
}
