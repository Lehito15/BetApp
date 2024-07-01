package com.example.betapp.repository;

import com.example.betapp.entity.IndividualEvent;
import com.example.betapp.entity.TeamEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TeamEventRepository extends JpaRepository<TeamEvent, Long> {
    @Query("SELECT e FROM TeamEvent e WHERE e.id = :id")
    TeamEvent getTeamEventById(@Param("id") Long id);

    @Query("SELECT e FROM TeamEvent e WHERE e.eventDate <= :date")
    List<TeamEvent> getInactiveEvents(@Param("date") LocalDate date);

    @Query("SELECT e FROM TeamEvent  e WHERE e.eventDate >= :date")
    List<TeamEvent> getActiveEvents(@Param("date") LocalDate date);

    @Query("SELECT e FROM TeamEvent e WHERE e.eventDate >= :date and e.discipline.name = :discipline")
    List<TeamEvent> getActiveEventsByDiscipline(@Param("date") LocalDate date, @Param("discipline") String discipline);

}
