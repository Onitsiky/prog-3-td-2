package com.example.Prog3Td2.controller.mapper;

import com.example.Prog3Td2.controller.rest.MatchResponse;
import com.example.Prog3Td2.model.MatchEntity;
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
