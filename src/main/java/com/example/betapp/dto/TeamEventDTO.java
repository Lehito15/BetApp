package com.example.betapp.dto;

import com.example.betapp.entity.Bet;
import com.example.betapp.entity.Discipline;
import com.example.betapp.entity.League;
import com.example.betapp.entity.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeamEventDTO extends EventDTO {
    private Long id;
    private String name;
    private League league;
    private Discipline discipline;
    private Team winner;
    private Boolean isSingleCompetition;
    private LocalDate eventDate;
    private float drawRate;
}
