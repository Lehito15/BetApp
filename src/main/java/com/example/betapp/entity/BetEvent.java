package com.example.betapp.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BetEvents")
public class BetEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private Bet bet;

    @ManyToOne
    @JoinColumn
    private IndividualEvent individualEvent;

    @ManyToOne
    @JoinColumn
    private TeamEvent teamEvent;

    @ManyToOne
    @JoinColumn
    private Sportsman sportsmanWinner;

    @ManyToOne
    @JoinColumn
    private Team teamWinner;

    public BetEvent(Bet bet, IndividualEvent individualEvent, TeamEvent teamEvent,
                    Sportsman sportsmanWinner, Team teamWinner) {
        this.bet = bet;
        this.individualEvent = individualEvent;
        this.teamEvent = teamEvent;
        this.sportsmanWinner = sportsmanWinner;
        this.teamWinner = teamWinner;
    }

}
