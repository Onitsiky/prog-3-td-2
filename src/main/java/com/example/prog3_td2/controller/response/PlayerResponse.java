package com.example.prog3_td2.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PlayerResponse {
  private int id;
  private String name;
}
