package com.example.Prog3Td2.controller.mapper;

import com.example.Prog3Td2.controller.rest.CreateTeamResponse;
import com.example.Prog3Td2.controller.rest.TeamResponse;
import com.example.Prog3Td2.controller.rest.UpdateTeamResponse;
import com.example.Prog3Td2.model.TeamEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TeamMapper {
  private final PlayerMapper playerMapper;

  public TeamResponse toRest (TeamEntity domain){
    return TeamResponse.builder()
        .name(domain.getName())
        .sponsors(domain.getSponsors())
        .players(domain.getPlayers().stream()
            .map(playerMapper::toRest).toList())
        .build();
  }

  public TeamEntity toDomain (CreateTeamResponse rest){
    return TeamEntity.builder()
        .name(rest.getName())
        .build();
  }

  public TeamEntity toDomain (UpdateTeamResponse rest){
    return TeamEntity.builder()
        .id(rest.getId())
        .name(rest.getName())
        .build();
  }
}
