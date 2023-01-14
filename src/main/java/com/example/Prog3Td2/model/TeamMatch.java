package com.example.Prog3Td2.model;

import com.example.Prog3Td2.controller.rest.ScoreResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeamMatch {
  private String name;
  private int goals;
  private List<ScoreResponse> scorers;
}