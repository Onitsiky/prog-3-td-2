package com.example.Prog3Td2.model;

import com.example.Prog3Td2.controller.rest.ScoreResponse;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "match")
public class MatchEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(nullable = false)
  private Instant datetime;

  @Column(nullable = false)
  private String stadium;

  @ManyToOne
  @JoinColumn(name = "hosts")
  private TeamEntity hosts;

  @ManyToOne
  @JoinColumn(name = "foreigners")
  private TeamEntity foreigners;

  @OneToMany
  @JoinColumn(name = "match_id")
  @OrderBy("scoringTime asc")
  private List<ScoreEntity> score;
}
