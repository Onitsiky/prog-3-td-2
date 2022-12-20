package com.example.Prog3Td2.controller;

import com.example.Prog3Td2.model.SponsorEntity;
import com.example.Prog3Td2.service.SponsorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/sponsors")
public class SponsorController {
  private final SponsorService service;

  @GetMapping
  public List<SponsorEntity> getAll (){
    return service.getAll();
  }

  @GetMapping("/{sponsor_id}")
  public SponsorEntity getById (@PathVariable int sponsor_id){
    return service.getById(sponsor_id);
  }
  /*
  @PostMapping
  public List<SponsorEntity> saveAll (@RequestBody List<SponsorEntity> toSave){
    return service.saveAll(toSave);
  }

  @PutMapping
  public List<SponsorEntity> updateAll (@RequestBody List<SponsorEntity> toUpdate){
    return service.updateAll(toUpdate);
  }
  @DeleteMapping("/{sponsor_id}")
  public SponsorEntity deleteById (@PathVariable int sponsor_id){
    return service.deleteById(sponsor_id);
  }
   */
}
