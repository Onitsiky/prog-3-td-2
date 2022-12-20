package com.example.Prog3Td2.controller;

import com.example.Prog3Td2.controller.mapper.PlayerMapper;
import com.example.Prog3Td2.controller.rest.PlayerResponse;
import com.example.Prog3Td2.service.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
  @GetMapping("/{player_id}")
  public PlayerResponse getById (@PathVariable int player_id){
    return mapper.toRest(service.getById(player_id));
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
