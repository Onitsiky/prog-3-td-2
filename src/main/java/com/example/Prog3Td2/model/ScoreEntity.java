package com.example.Prog3Td2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "score")
public class ScoreEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @OrderBy
  @Column(nullable = false)
  private int scoringTime;

  @Column(nullable = false)
  private Boolean isOG;

  @ManyToOne
  @JoinColumn(name = "player_id")
  private PlayerEntity player;

  @ManyToOne
  @JsonIgnore
  @JoinColumn(name = "match_id")
  private MatchEntity match;
}
