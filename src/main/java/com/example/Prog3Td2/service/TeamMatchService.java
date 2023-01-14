package com.example.Prog3Td2.service;

import com.example.Prog3Td2.controller.mapper.ScoreMapper;
import com.example.Prog3Td2.model.MatchEntity;
import com.example.Prog3Td2.model.ScoreEntity;
import com.example.Prog3Td2.model.TeamEntity;
import com.example.Prog3Td2.model.TeamMatch;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class TeamMatchService {
  private final ScoreMapper scoreMapper;

  public TeamMatch getTeamResponse (TeamEntity domainTeam, List<ScoreEntity> domainScore){
    int goals = 0;
    for (ScoreEntity scoreEntity : domainScore) {
      if(scoreEntity.getPlayer().getIsGoalKeeper() == false && domainTeam.getId() == scoreEntity.getMatch().getId()) {
        if (scoreEntity.getIsOG() == false) {
          goals = goals + 1;
        }
      }
    }

    return TeamMatch.builder()
        .name(domainTeam.getName())
        .goals(goals)
        .scorers(domainScore.stream().map(scoreMapper::toRest).toList())
        .build();
  }
}
