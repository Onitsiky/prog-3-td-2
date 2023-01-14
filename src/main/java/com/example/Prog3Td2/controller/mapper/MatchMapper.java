package com.example.Prog3Td2.controller.mapper;

import com.example.Prog3Td2.controller.rest.MatchResponse;
import com.example.Prog3Td2.controller.rest.ScoreResponse;
import com.example.Prog3Td2.model.MatchEntity;
import com.example.Prog3Td2.model.ScoreEntity;
import com.example.Prog3Td2.model.TeamMatch;
import com.example.Prog3Td2.service.TeamMatchService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class MatchMapper {
  private final TeamMatchService teamMatchService;

  public MatchResponse toRest (MatchEntity domain){
    List<ScoreEntity> hostsScore = new ArrayList<>();
    List<ScoreEntity> foreignersScore = new ArrayList<>();
    for (ScoreEntity scoreEntity : domain.getScore()) {
      String currentTeam = scoreEntity.getPlayer().getTeam().getName();
      String hostTeam = domain.getHosts().getName();
      String foreignerTeam = domain.getForeigners().getName();
      if(scoreEntity.getMatch().getId() == domain.getId()) {
        if (scoreEntity.getMatch().getId() == domain.getId()) {
          if (currentTeam.equals(hostTeam)) {
            hostsScore.add(scoreEntity);
          }
          else if (currentTeam.equals(foreignerTeam)){
            foreignersScore.add(scoreEntity);
          }
        }
      }
    }
    TeamMatch hosts = teamMatchService.getTeamResponse(domain.getHosts(),hostsScore);
    TeamMatch foreigners = teamMatchService.getTeamResponse(domain.getForeigners(),foreignersScore);
    for (ScoreResponse scorer : hosts.getScorers()) {
      if(scorer.getPlayer().isGoalKeeper() == false) {
        if (scorer.getIsOG() == true) {
          foreigners.setGoals(foreigners.getGoals() + 1);
        } else {
          hosts.setGoals(hosts.getGoals() + 1);
        }
      }
    }
    return MatchResponse.builder()
        .datetime(domain.getDatetime())
        .hosts(hosts)
        .foreigners(foreigners)
        .build();
  }
}
