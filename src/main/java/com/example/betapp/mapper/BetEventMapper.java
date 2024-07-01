package com.example.betapp.mapper;

import com.example.betapp.dto.BetEventDTO;
import com.example.betapp.entity.BetEvent;

public class BetEventMapper {
    public static BetEventDTO mapToBetEventDTO(BetEvent betEvent) {
        return new BetEventDTO(
                betEvent.getId(),
                betEvent.getBet(),
                betEvent.getIndividualEvent(),
                betEvent.getTeamEvent(),
                betEvent.getSportsmanWinner(),
                betEvent.getTeamWinner()
        );
    }

    public static BetEvent mapToBetEvent(BetEventDTO betEventDTO) {
        return new BetEvent(
                betEventDTO.getId(),
                betEventDTO.getBet(),
                betEventDTO.getIndividualEvent(),
                betEventDTO.getTeamEvent(),
                betEventDTO.getSportsmanWinner(),
                betEventDTO.getTeamWinner()
        );
    }
}
