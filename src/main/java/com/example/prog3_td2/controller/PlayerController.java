package com.example.prog3_td2.controller;

import com.example.prog3_td2.controller.mapper.PlayerMapper;
import com.example.prog3_td2.controller.response.PlayerResponse;
import com.example.prog3_td2.model.PlayerEntity;
import com.example.prog3_td2.service.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/players")
public class PlayerController {
  private final PlayerService service;
  private final PlayerMapper mapper;

  @GetMapping
  public List<PlayerResponse> getAll (){
    return service.getAll().stream()
        .map(mapper::toRest)
        .toList();
  }
  /*
  @PostMapping
  public List<PlayerEntity> saveAll (@RequestBody List<PlayerEntity> toSave){
    return service.saveAll(toSave);
  }
  @PutMapping
  public List<PlayerEntity> updateAll (@RequestBody List<PlayerEntity> toUpdate){
    return service.updateAll(toUpdate);
  }
  @DeleteMapping("/{player_id}")
  public PlayerEntity deleteById (@PathVariable int player_id){
    return service.deleteById(player_id);
  }
   */
}
