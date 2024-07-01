package com.example.betapp.dto;

import com.example.betapp.entity.IndividualEvent;
import com.example.betapp.entity.Sportsman;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IndividualEventCompetitorDTO {
    private Long id;
    private float rate;
    private int result;
    private IndividualEvent event;
    private Sportsman competitor;
}
