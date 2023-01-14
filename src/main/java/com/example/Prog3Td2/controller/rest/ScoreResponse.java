package com.example.Prog3Td2.controller.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ScoreResponse {
  private PlayerResponse player;
  private Boolean isOG;
  private int scoringTime;
}
