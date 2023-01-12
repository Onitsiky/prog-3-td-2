package com.example.Prog3Td2.service;

import com.example.Prog3Td2.model.PlayerEntity;
import com.example.Prog3Td2.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Service
@AllArgsConstructor
public class PlayerService {
  private final PlayerRepository repository;

  public List<PlayerEntity> getAll (){
    return repository.findAll();
    // .stream().sorted(Comparator.comparingInt(PlayerEntity::getNumber)).toList()
  }

  public PlayerEntity getById (int id){
    return repository.findById(String.valueOf(id)).get();
  }
  @Transactional
  public List<PlayerEntity> saveAll (List<PlayerEntity> toSave){
    return repository.saveAll(toSave);
  }
  @Transactional
  public List<PlayerEntity> updateAll (List<PlayerEntity> toUpdate){
    return repository.saveAll(toUpdate);
  }

  public PlayerEntity deleteById (int id){
    PlayerEntity actual = repository.findById(String.valueOf(id)).get();
    repository.deleteById(String.valueOf(id));
    return actual;
  }
}
