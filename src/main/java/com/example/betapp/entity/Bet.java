package com.example.betapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Bets")
public class Bet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Bet(float deposit, String clientID, LocalDate betDate) {
        this.deposit = deposit;
        this.clientID = clientID;
        this.betDate = betDate;
    }

    private float deposit;

    private String clientID;

    private LocalDate betDate;
}
