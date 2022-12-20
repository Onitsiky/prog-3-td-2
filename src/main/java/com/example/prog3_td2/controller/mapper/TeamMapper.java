package com.example.prog3_td2.controller.mapper;

import com.example.prog3_td2.controller.response.TeamResponse;
import com.example.prog3_td2.model.TeamEntity;
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
        .players(domain.getPlayers().stream().map(playerMapper::toRest).toList())
        .build();
  }
}
