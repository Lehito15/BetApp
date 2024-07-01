package com.example.betapp.dto;

import com.example.betapp.entity.Discipline;
import com.example.betapp.entity.League;
import com.example.betapp.entity.Sportsman;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IndividualEventDTO extends EventDTO{
    private Long id;
    private String name;
    private League league;
    private Discipline discipline;
    private Sportsman winner;
    private Boolean isSingleCompetition;
    private LocalDate eventDate;
    private float drawRate;
}
