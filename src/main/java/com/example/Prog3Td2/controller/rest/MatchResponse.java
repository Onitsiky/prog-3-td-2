package com.example.Prog3Td2.controller.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
public class MatchResponse {
  private Instant datetime;
  private TeamResponse hosts;
  private TeamResponse foreigners;
}
