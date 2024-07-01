package com.example.betapp.mapper;

import com.example.betapp.dto.IndividualEventDTO;
import com.example.betapp.entity.IndividualEvent;

public class IndividualEventMapper {
    public static IndividualEventDTO mapToIndividualEventDTO(IndividualEvent individualEvent) {
        return new IndividualEventDTO(
                individualEvent.getId(),
                individualEvent.getName(),
                individualEvent.getLeague(),
                individualEvent.getDiscipline(),
                individualEvent.getWinner(),
                true,
                individualEvent.getEventDate(),
                individualEvent.getDrawRate()
        );
    }

    public static IndividualEvent mapToIndividualEvent(IndividualEventDTO individualEventDTO) {
        return new IndividualEvent(
                individualEventDTO.getId(),
                individualEventDTO.getName(),
                individualEventDTO.getLeague(),
                individualEventDTO.getDiscipline(),
                individualEventDTO.getWinner(),
                individualEventDTO.getEventDate(),
                individualEventDTO.getDrawRate()
        );
    }
}
