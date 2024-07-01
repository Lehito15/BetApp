package com.example.betapp.service.impl;

import com.example.betapp.dto.IndividualEventDTO;
import com.example.betapp.dto.SportsmanDTO;
import com.example.betapp.dto.TeamDTO;
import com.example.betapp.dto.TeamEventDTO;
import com.example.betapp.entity.IndividualEvent;
import com.example.betapp.entity.IndividualEventCompetitor;
import com.example.betapp.entity.TeamEvent;
import com.example.betapp.entity.TeamEventCompetitor;
import com.example.betapp.mapper.IndividualEventMapper;
import com.example.betapp.mapper.SportsmanMapper;
import com.example.betapp.mapper.TeamEventMapper;
import com.example.betapp.mapper.TeamMapper;
import com.example.betapp.repository.IndividualEventCompetitorRepository;
import com.example.betapp.repository.IndividualEventRepository;
import com.example.betapp.repository.TeamEventCompetitorRepository;
import com.example.betapp.repository.TeamEventRepository;
import com.example.betapp.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {
    private TeamEventRepository teamEventRepository;
    private IndividualEventRepository individualEventRepository;
    private TeamEventCompetitorRepository teamEventCompetitorRepository;
    private IndividualEventCompetitorRepository individualEventCompetitorRepository;

    @Override
    public List<TeamEventDTO> getTeamEvents() {
        List<TeamEvent> teamEventList = teamEventRepository.findAll();
        return teamEventList.stream().map((teamEvent) ->
                TeamEventMapper.mapToTeamEventDTO(teamEvent)).collect(Collectors.toList());
    }

    @Override
    public List<IndividualEventDTO> getIndividualEvents() {
        List<IndividualEvent> individualEventList = individualEventRepository.findAll();
        return individualEventList.stream().map((individualEvent) ->
                IndividualEventMapper.mapToIndividualEventDTO(individualEvent)).collect(Collectors.toList());
    }

    @Override
    public List<IndividualEventDTO> getActiveIndividualEvents() {
        List<IndividualEvent> individualEventList = individualEventRepository.getActiveEvents(LocalDate.now());
        return individualEventList.stream().map((individualEvent ->
                IndividualEventMapper.mapToIndividualEventDTO(individualEvent))).collect(Collectors.toList());
    }

    @Override
    public List<IndividualEventDTO> getInactiveIndividualEvents() {
        List<IndividualEvent> individualEventList = individualEventRepository.getInactiveEvents(LocalDate.now());
        return individualEventList.stream().map((individualEvent ->
                IndividualEventMapper.mapToIndividualEventDTO(individualEvent))).collect(Collectors.toList());
    }

    @Override
    public List<TeamEventDTO> getActiveTeamEvents() {
        List<TeamEvent> teamEventList = teamEventRepository.getActiveEvents(LocalDate.now());
        return teamEventList.stream().map((teamEvent ->
                TeamEventMapper.mapToTeamEventDTO(teamEvent))).collect(Collectors.toList());
    }

    @Override
    public List<TeamEventDTO> getInactiveTeamEvents() {
        List<TeamEvent> teamEventList = teamEventRepository.getInactiveEvents(LocalDate.now());
        return teamEventList.stream().map((teamEvent ->
                TeamEventMapper.mapToTeamEventDTO(teamEvent))).collect(Collectors.toList());
    }

    @Override
    public List<IndividualEventDTO> getIndividualEventByDiscipline(String discipline) {
        return individualEventRepository.getActiveEventsByDiscipline(LocalDate.now(), discipline).stream().map((event) ->
                IndividualEventMapper.mapToIndividualEventDTO(event)).collect(Collectors.toList());
    }

    @Override
    public List<TeamEventDTO> getTeamEventByDiscipline(String discipline) {
        return teamEventRepository.getActiveEventsByDiscipline(LocalDate.now(), discipline).stream().map((event) ->
                TeamEventMapper.mapToTeamEventDTO(event)).collect(Collectors.toList());
    }

    @Override
    public List<TeamEventCompetitor> getTeamsByEvent(Long eventID) {
        return teamEventCompetitorRepository.getTeamsByEvent(eventID);
    }

    @Override
    public List<IndividualEventCompetitor> getSportsmenByEvent(Long eventID) {
        return individualEventCompetitorRepository.getSportsmanByEvent(eventID);
    }
}
