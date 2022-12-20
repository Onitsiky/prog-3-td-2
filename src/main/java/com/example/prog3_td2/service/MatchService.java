package com.example.prog3_td2.service;

import com.example.prog3_td2.model.MatchEntity;
import com.example.prog3_td2.repository.MatchRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MatchService {
  private final MatchRepository repository;

  public List<MatchEntity> getAll (){
    return repository.findAll();
  }

  public MatchEntity getById (int id){
    return repository.findById(String.valueOf(id)).get();
  }
}
