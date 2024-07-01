package com.example.betapp.controller;

import com.example.betapp.dto.*;
import com.example.betapp.entity.IndividualEventCompetitor;
import com.example.betapp.entity.TeamEventCompetitor;
import com.example.betapp.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
public class EventController {
    private EventService eventService;

    @GetMapping("/events/team")
    public ResponseEntity<List<TeamEventDTO>> getTeamEvents() {
        List<TeamEventDTO> teamEvents = eventService.getTeamEvents();
        return ResponseEntity.ok(teamEvents);
    }

    @GetMapping("/events/individual")
    public ResponseEntity<List<IndividualEventDTO>> getIndividualEvents() {
        List<IndividualEventDTO> individualEvents = eventService.getIndividualEvents();
        return ResponseEntity.ok(individualEvents);
    }

    @GetMapping("/events")
    public ResponseEntity<List<EventDTO>> getAllEvents() {
        List<EventDTO> eventsDTOList = new ArrayList<EventDTO>();
        List<TeamEventDTO> teamEvents = eventService.getTeamEvents();
        List<IndividualEventDTO> individualEvents = eventService.getIndividualEvents();
        eventsDTOList.addAll(teamEvents);
        eventsDTOList.addAll(individualEvents);
        return ResponseEntity.ok(eventsDTOList);
    }

    @GetMapping("/active-events")
    public ResponseEntity<List<EventDTO>> getActiveEvents() {
        List<EventDTO> eventDTOList = new ArrayList<EventDTO>();
        List<TeamEventDTO> teamEvents = eventService.getActiveTeamEvents();
        List<IndividualEventDTO> individualEvents = eventService.getActiveIndividualEvents();
        eventDTOList.addAll(individualEvents);
        eventDTOList.addAll(teamEvents);
        return ResponseEntity.ok(eventDTOList);
    }

    @GetMapping("/inactive-events")
    public ResponseEntity<List<EventDTO>> getInactiveEvents() {
        List<EventDTO> eventDTOList = new ArrayList<EventDTO>();
        List<TeamEventDTO> teamEvents = eventService.getInactiveTeamEvents();
        List<IndividualEventDTO> individualEvents = eventService.getInactiveIndividualEvents();
        eventDTOList.addAll(individualEvents);
        eventDTOList.addAll(teamEvents);
        return ResponseEntity.ok(eventDTOList);
    }

    @GetMapping("/events/{discipline}")
    public ResponseEntity<List<EventDTO>> getEventsByDiscipline(@PathVariable("discipline") String discipline) {
        List<EventDTO> eventDTOList = new ArrayList<EventDTO>();
        List<TeamEventDTO> teamEventDTOS = eventService.getTeamEventByDiscipline(discipline);
        List<IndividualEventDTO> individualEventDTOS = eventService.getIndividualEventByDiscipline(discipline);
        eventDTOList.addAll(teamEventDTOS);
        eventDTOList.addAll(individualEventDTOS);
        return ResponseEntity.ok(eventDTOList);
    }

    @GetMapping("/events/{eventID}/team")
    public ResponseEntity<List<TeamEventCompetitor>> getTeamsByEvent(@PathVariable("eventID") Long eventID) {
        return ResponseEntity.ok(eventService.getTeamsByEvent(eventID));
    }

    @GetMapping("/events/{eventID}/sportsman")
    public ResponseEntity<List<IndividualEventCompetitor>> getSportsmanByEvent(@PathVariable("eventID") Long eventID) {
        return ResponseEntity.ok(eventService.getSportsmenByEvent(eventID));
    }


}
