package com.example.Prog3Td2.service;

import com.example.Prog3Td2.model.ScoreEntity;
import com.example.Prog3Td2.repository.ScoreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ScoreService {
  private final ScoreRepository repository;

  public List<ScoreEntity> getAll (){
    return repository.findAll();
  }
}
