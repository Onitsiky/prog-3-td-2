package com.example.Prog3Td2.controller.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CreatePlayerResponse {
  private String name;
  private int number;
  private String team;
  private Boolean isGoalKeeper;
}
