package com.example.prog3_td2.controller.mapper;

import com.example.prog3_td2.controller.rest.TeamResponse;
import com.example.prog3_td2.model.PlayerEntity;
import com.example.prog3_td2.model.TeamEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
@AllArgsConstructor
public class TeamMapper {
  private final PlayerMapper playerMapper;

  public TeamResponse toRest (TeamEntity domain){
    return TeamResponse.builder()
        .name(domain.getName())
        .sponsors(domain.getSponsors())
        .players(domain.getPlayers().stream()
            .sorted(Comparator.comparingInt(PlayerEntity::getNumber))
            .map(playerMapper::toRest).toList())
        .build();
  }
}
