package com.example.prog3_td2.controller;

import com.example.prog3_td2.controller.mapper.TeamMapper;
import com.example.prog3_td2.controller.response.TeamResponse;
import com.example.prog3_td2.model.TeamEntity;
import com.example.prog3_td2.service.TeamService;
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
@RequestMapping("/teams")
@AllArgsConstructor
public class TeamController {
  private final TeamService service;
  private final TeamMapper mapper;

  @GetMapping
  public List<TeamResponse> getAll (){
    return service.getAll().stream()
        .map(mapper::toRest)
        .toList();
  }

  @PostMapping
  public List<TeamEntity> saveAll (@RequestBody List<TeamEntity> toSave){
    return service.saveAll(toSave);
  }

  @PutMapping
  public List<TeamEntity> updateAll (@RequestBody List<TeamEntity> toUpdate) {
    return service.updateAll(toUpdate);
  }

  @DeleteMapping("/{team_id}")
  public TeamEntity deleteById (@PathVariable int team_id) {
    return service.deleteById(team_id);
  }
}
