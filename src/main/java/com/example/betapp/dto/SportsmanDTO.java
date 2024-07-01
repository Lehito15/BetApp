package com.example.betapp.dto;

import com.example.betapp.entity.Discipline;
import com.example.betapp.entity.Nationality;
import com.example.betapp.entity.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SportsmanDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Nationality nationality;
    private Discipline discipline;
}
