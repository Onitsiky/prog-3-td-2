package com.example.Prog3Td2.controller.mapper;

import com.example.Prog3Td2.controller.rest.PlayerResponse;
import com.example.Prog3Td2.model.PlayerEntity;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapper {
  public PlayerResponse toRest (PlayerEntity domain){
    return PlayerResponse.builder()
        .id(domain.getId())
        .name(domain.getName())
        .build();
  }
}
