package com.example.Prog3Td2.repository;

import com.example.Prog3Td2.model.SponsorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SponsorRepository extends JpaRepository<SponsorEntity, String> {
}
