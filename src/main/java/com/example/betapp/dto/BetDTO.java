package com.example.betapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BetDTO {
    private Long id;
    private float deposit;
    private String clientID;
    private LocalDate betDate;
}
