package com.example.prog3_td2.controller;

import com.example.prog3_td2.controller.mapper.MatchMapper;
import com.example.prog3_td2.controller.rest.MatchResponse;
import com.example.prog3_td2.service.MatchService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

  @GetMapping("/{match_id}")
  public MatchResponse getById (@PathVariable int match_id){
    return mapper.toRest(service.getById(match_id));
  }
}
