package com.example.prog3_td2.service;

import com.example.prog3_td2.model.PlayerEntity;
import com.example.prog3_td2.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@AllArgsConstructor
public class PlayerService {
  private final PlayerRepository repository;

  public List<PlayerEntity> getAll (){
    return repository.findAll().stream().sorted(Comparator.comparingInt(PlayerEntity::getNumber)).toList();
  }

  public PlayerEntity getById (int id){
    return repository.findById(String.valueOf(id)).get();
  }
  /*
  public List<PlayerEntity> saveAll (List<PlayerEntity> toSave){
    return repository.saveAll(toSave);
  }

  public List<PlayerEntity> updateAll (List<PlayerEntity> toUpdate){
    return repository.saveAll(toUpdate);
  }

  public PlayerEntity deleteById (int id){
    PlayerEntity actual = repository.findById(String.valueOf(id)).get();
    repository.deleteById(String.valueOf(id));
    return actual;
  }

   */
}
