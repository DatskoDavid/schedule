package com.example.schedule.repository;

import com.example.schedule.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRep extends JpaRepository<Subject, Long> {
}
