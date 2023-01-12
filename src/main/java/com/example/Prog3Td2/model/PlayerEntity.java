package com.example.Prog3Td2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "player")
public class PlayerEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(unique = true, nullable = false)
  private String name;

  @Column(nullable = false)
  private int number;

  @Column(nullable = false, columnDefinition = "default false")
  private Boolean isGoalKeeper;

  @ManyToOne
  @JoinColumn(name = "team_id")
  @JsonIgnore
  private TeamEntity team;
}
