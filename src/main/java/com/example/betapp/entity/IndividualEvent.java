package com.example.betapp.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "IndividualEvents")
public class IndividualEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn
    private League league;

    @ManyToOne
    @JoinColumn
    private Discipline discipline;

    @ManyToOne
    @JoinColumn
    private Sportsman winner;

    private LocalDate eventDate;

    private float drawRate;

}
