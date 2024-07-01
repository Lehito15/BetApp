package com.example.betapp.mapper;

import com.example.betapp.dto.TeamDTO;
import com.example.betapp.entity.Team;

public class TeamMapper {
    public static TeamDTO mapToTeamDTO(Team team) {
        return new TeamDTO(
                team.getId(),
                team.getName(),
                team.getNationality(),
                team.getDiscipline()
        );
    }

    public static Team mapToTeam(TeamDTO teamDTO) {
        return new Team(
                teamDTO.getId(),
                teamDTO.getName(),
                teamDTO.getNationality(),
                teamDTO.getDiscipline()
        );
    }
}
