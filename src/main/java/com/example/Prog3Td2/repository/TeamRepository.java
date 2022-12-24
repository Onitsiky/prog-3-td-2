package com.example.Prog3Td2.repository;

import com.example.Prog3Td2.model.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<TeamEntity, String> {
  TeamEntity findByName(String name);
}
