package com.example.prog3_td2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "team")
public class TeamEntity implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(nullable = false, unique = true)
  private String name;

  @OneToMany
  @JoinColumn(name = "team_id")
  private List<PlayerEntity> players;

  @ManyToMany
  @JoinTable(
      name = "have",
      joinColumns = @JoinColumn(name = "team_id"),
      inverseJoinColumns = @JoinColumn(name = "sponsor_id")
  )
  private List<SponsorEntity> sponsors;
}
