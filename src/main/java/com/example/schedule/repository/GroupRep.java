package com.example.schedule.repository;

import com.example.schedule.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRep extends JpaRepository<Group, Long> {
}
