package com.example.betapp.mapper;

import com.example.betapp.dto.TeamEventDTO;
import com.example.betapp.entity.TeamEvent;

public class TeamEventMapper {
    public static TeamEventDTO mapToTeamEventDTO(TeamEvent teamEvent) {
        return new TeamEventDTO(
                teamEvent.getId(),
                teamEvent.getName(),
                teamEvent.getLeague(),
                teamEvent.getDiscipline(),
                teamEvent.getWinner(),
                false,
                teamEvent.getEventDate(),
                teamEvent.getDrawRate()
        );
    }

    public static TeamEvent mapToTeamEvent(TeamEventDTO teamEventDTO){
        return new TeamEvent(
                teamEventDTO.getId(),
                teamEventDTO.getName(),
                teamEventDTO.getLeague(),
                teamEventDTO.getDiscipline(),
                teamEventDTO.getWinner(),
                teamEventDTO.getEventDate(),
                teamEventDTO.getDrawRate()
        );
    }
}
