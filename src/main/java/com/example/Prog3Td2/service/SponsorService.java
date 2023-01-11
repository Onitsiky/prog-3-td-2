package com.example.Prog3Td2.service;

import com.example.Prog3Td2.model.SponsorEntity;
import com.example.Prog3Td2.repository.SponsorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class SponsorService {
  private final SponsorRepository repository;

  public List<SponsorEntity> getAll (){
    return repository.findAll();
  }

  public SponsorEntity getById (int id){
    return repository.findById(String.valueOf(id)).get();
  }
  @Transactional
  public List<SponsorEntity> saveAll (List<SponsorEntity> toSave){
    return repository.saveAll(toSave);
  }

  @Transactional
  public List<SponsorEntity> updateAll (List<SponsorEntity> toUpdate){
    return repository.saveAll(toUpdate);
  }

  public SponsorEntity deleteById (int id){
    SponsorEntity actual = repository.findById(String.valueOf(id)).get();
    repository.deleteById(String.valueOf(id));
    return actual;
  }
}
