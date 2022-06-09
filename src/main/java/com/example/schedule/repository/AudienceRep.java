package com.example.schedule.repository;

import com.example.schedule.model.Audience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AudienceRep extends JpaRepository<Audience, Long> {
}
