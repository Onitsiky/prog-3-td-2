package com.example.prog3_td2.controller.response;

import com.example.prog3_td2.model.TeamEntity;
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
