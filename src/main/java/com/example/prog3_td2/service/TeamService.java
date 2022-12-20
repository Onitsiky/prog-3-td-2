package com.example.prog3_td2.service;

import com.example.prog3_td2.model.TeamEntity;
import com.example.prog3_td2.repository.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class TeamService {
  private final TeamRepository repository;

  public List<TeamEntity> getAll () {
    return repository.findAll();
  }

  @Transactional
  public List<TeamEntity> saveAll (List<TeamEntity> toSave) {
    return repository.saveAll(toSave);
  }

  @Transactional
  public List<TeamEntity> updateAll (List<TeamEntity> toUpdate) {
    return repository.saveAll(toUpdate);
  }

  public TeamEntity deleteById (int id){
    TeamEntity actual = repository.findById(String.valueOf(id)).get();
    repository.deleteById(String.valueOf(id));
    return actual;
  }
}
