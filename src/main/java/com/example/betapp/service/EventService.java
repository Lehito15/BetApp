package com.example.betapp.service;

import com.example.betapp.dto.*;
import com.example.betapp.entity.IndividualEventCompetitor;
import com.example.betapp.entity.Sportsman;
import com.example.betapp.entity.TeamEventCompetitor;

import java.util.List;

public interface EventService {
    List<TeamEventDTO> getTeamEvents();
    List<IndividualEventDTO> getIndividualEvents();
    List<IndividualEventDTO> getActiveIndividualEvents();
    List<IndividualEventDTO> getInactiveIndividualEvents();
    List<TeamEventDTO> getActiveTeamEvents();
    List<TeamEventDTO> getInactiveTeamEvents();
    List<IndividualEventDTO> getIndividualEventByDiscipline(String discipline);
    List<TeamEventDTO> getTeamEventByDiscipline(String discipline);
    List<TeamEventCompetitor> getTeamsByEvent(Long eventID);
    List<IndividualEventCompetitor> getSportsmenByEvent(Long eventID);
}
