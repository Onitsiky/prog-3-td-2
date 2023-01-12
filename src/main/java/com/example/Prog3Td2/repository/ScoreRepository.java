package com.example.Prog3Td2.repository;

import com.example.Prog3Td2.model.ScoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<ScoreEntity, String> {
}
