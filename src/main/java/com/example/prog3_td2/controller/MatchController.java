package com.example.prog3_td2.controller;

import com.example.prog3_td2.controller.mapper.MatchMapper;
import com.example.prog3_td2.controller.response.MatchResponse;
import com.example.prog3_td2.model.MatchEntity;
import com.example.prog3_td2.service.MatchService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/matches")
public class MatchController {
  private final MatchService service;
  private final MatchMapper mapper;

  @GetMapping
  public List<MatchResponse> getAll (){
    return service.getAll().stream().map(mapper::toRest).toList();
  }
}
