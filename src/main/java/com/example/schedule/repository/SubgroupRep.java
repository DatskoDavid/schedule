package com.example.schedule.repository;

import com.example.schedule.model.Subgroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubgroupRep extends JpaRepository<Subgroup, Long> {
}
