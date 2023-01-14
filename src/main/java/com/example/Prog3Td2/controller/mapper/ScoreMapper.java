package com.example.Prog3Td2.controller.mapper;

import com.example.Prog3Td2.controller.rest.ScoreResponse;
import com.example.Prog3Td2.model.ScoreEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ScoreMapper {
  private PlayerMapper playerMapper;

  public ScoreResponse toRest (ScoreEntity domain){
    return ScoreResponse.builder()
        .player(playerMapper.toRest(domain.getPlayer()))
        .scoringTime(domain.getScoringTime())
        .isOG(domain.getIsOG())
        .build();
  }
}
