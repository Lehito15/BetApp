package com.example.betapp.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "IndividualEventCompetitors")
public class IndividualEventCompetitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float rate;
    private int result;

    @ManyToOne
    @JoinColumn
    private IndividualEvent event;

    @ManyToOne
    @JoinColumn
    private Sportsman competitor;

}
