package com.example.Prog3Td2.controller.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CreateTeamResponse {
  private String name;
}
