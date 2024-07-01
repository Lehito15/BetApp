package com.example.betapp.mapper;

import com.example.betapp.dto.SportsmanDTO;
import com.example.betapp.entity.Sportsman;

public class SportsmanMapper {
    public static SportsmanDTO mapToSportsmanDTO(Sportsman sportsman) {
        return new SportsmanDTO(
                sportsman.getId(),
                sportsman.getFirstName(),
                sportsman.getLastName(),
                sportsman.getBirthDate(),
                sportsman.getNationality(),
                sportsman.getDiscipline()
        );
    }

    public static Sportsman mapToSportsman(SportsmanDTO sportsmanDTO) {
        return new Sportsman(
                sportsmanDTO.getId(),
                sportsmanDTO.getFirstName(),
                sportsmanDTO.getLastName(),
                sportsmanDTO.getBirthDate(),
                sportsmanDTO.getNationality(),
                sportsmanDTO.getDiscipline()
        );
    }
}
