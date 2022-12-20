package com.example.prog3_td2.controller.mapper;

import com.example.prog3_td2.controller.response.MatchResponse;
import com.example.prog3_td2.model.MatchEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MatchMapper {
  private final TeamMapper teamMapper;

  public MatchResponse toRest (MatchEntity domain){
    return MatchResponse.builder()
        .datetime(domain.getDatetime())
        .hosts(teamMapper.toRest(domain.getHosts()))
        .foreigners(teamMapper.toRest(domain.getForeigners()))
        .build();
  }
}
