package com.example.betapp.dto;

import com.example.betapp.entity.Discipline;
import com.example.betapp.entity.Nationality;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeamDTO {
    private Long id;
    private String name;
    private Nationality nationality;
    private Discipline discipline;
}
