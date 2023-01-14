package com.example.Prog3Td2.controller.mapper;

import com.example.Prog3Td2.controller.rest.CreatePlayerResponse;
import com.example.Prog3Td2.controller.rest.PlayerResponse;
import com.example.Prog3Td2.controller.rest.UpdatePlayerResponse;
import com.example.Prog3Td2.model.PlayerEntity;
import com.example.Prog3Td2.model.TeamEntity;
import com.example.Prog3Td2.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PlayerMapper {
  private final TeamService teamService;
  public PlayerResponse toRest (PlayerEntity domain){
    return PlayerResponse.builder()
        .id(domain.getId())
        .name(domain.getName())
        .isGoalKeeper(domain.getIsGoalKeeper())
        .build();
  }
  public PlayerEntity toDomain (CreatePlayerResponse rest){
    TeamEntity team = teamService.getByName(rest.getTeam());
    return PlayerEntity.builder()
        .name(rest.getName())
        .number(rest.getNumber())
        .team(team)
        .isGoalKeeper(rest.getIsGoalKeeper())
        .build();
  }
  public PlayerEntity toDomain (UpdatePlayerResponse rest){
    TeamEntity team = teamService.getByName(rest.getTeam());
    return PlayerEntity.builder()
        .id(rest.getId())
        .name(rest.getName())
        .number(rest.getNumber())
        .team(team)
        .isGoalKeeper(rest.getIsGoalKeeper())
        .build();
  }
}
