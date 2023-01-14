package com.example.Prog3Td2.controller.rest;

import com.example.Prog3Td2.model.MatchEntity;
import com.example.Prog3Td2.model.TeamMatch;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
public class MatchResponse {
  private Instant datetime;
  private TeamMatch hosts;
  private TeamMatch foreigners;
}
