package com.example.prog3_td2.repository;

import com.example.prog3_td2.model.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<TeamEntity, String> {
}
