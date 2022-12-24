package com.example.Prog3Td2.controller;

import com.example.Prog3Td2.controller.mapper.TeamMapper;
import com.example.Prog3Td2.controller.rest.CreateTeamResponse;
import com.example.Prog3Td2.controller.rest.TeamResponse;
import com.example.Prog3Td2.controller.rest.UpdateTeamResponse;
import com.example.Prog3Td2.model.TeamEntity;
import com.example.Prog3Td2.service.TeamService;
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

  @GetMapping("/{team_id}")
  public TeamResponse getById (@PathVariable int team_id){
    return mapper.toRest(service.getById(team_id));
  }

  @PostMapping
  public List<TeamResponse> saveAll (@RequestBody List<CreateTeamResponse> toSave){
    List<TeamEntity> domain = toSave.stream().map(mapper::toDomain).toList();
    return service.saveAll(domain).stream()
        .map(mapper::toRest)
        .toList();
  }

  @PutMapping
  public List<TeamResponse> updateAll (@RequestBody List<UpdateTeamResponse> toUpdate) {
    List<TeamEntity> domain = toUpdate.stream().map(mapper::toDomain).toList();
    return service.updateAll(domain).stream()
        .map(mapper::toRest)
        .toList();
  }

  @DeleteMapping("/{team_id}")
  public TeamResponse deleteById (@PathVariable int team_id) {
    return mapper.toRest(service.deleteById(team_id));
  }
}
