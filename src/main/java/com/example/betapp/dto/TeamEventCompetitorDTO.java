package com.example.betapp.dto;

import com.example.betapp.entity.Team;
import com.example.betapp.entity.TeamEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeamEventCompetitorDTO {
    private Long id;
    private float rate;
    private int result;
    private TeamEvent event;
    private Team competitor;
}
