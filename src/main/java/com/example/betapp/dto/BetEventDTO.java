package com.example.betapp.dto;

import com.example.betapp.entity.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BetEventDTO {
    private Long id;
    private Bet bet;
    private IndividualEvent individualEvent;
    private TeamEvent teamEvent;
    private Sportsman sportsmanWinner;
    private Team teamWinner;
}
