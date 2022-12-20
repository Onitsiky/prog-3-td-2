package com.example.prog3_td2.controller.response;

import com.example.prog3_td2.model.SponsorEntity;
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
