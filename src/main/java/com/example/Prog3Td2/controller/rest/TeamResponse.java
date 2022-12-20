package com.example.Prog3Td2.controller.rest;

import com.example.Prog3Td2.model.SponsorEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class TeamResponse {
  private String name;
  private List<PlayerResponse> players;
  private List<SponsorEntity> sponsors;
}
