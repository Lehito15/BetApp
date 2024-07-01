package com.example.betapp.repository;

import com.example.betapp.entity.IndividualEvent;
import com.example.betapp.entity.IndividualEventCompetitor;
import com.example.betapp.entity.TeamEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IndividualEventRepository extends JpaRepository<IndividualEvent, Long> {
    @Query("SELECT e FROM IndividualEvent e WHERE e.id = :id")
    IndividualEvent getIndividualEventById(@Param("id") Long id);

    @Query("SELECT e FROM IndividualEvent e WHERE e.eventDate <= :date")
    List<IndividualEvent> getInactiveEvents(@Param("date") LocalDate date);

    @Query("SELECT e FROM IndividualEvent  e WHERE e.eventDate >= :date")
    List<IndividualEvent> getActiveEvents(@Param("date") LocalDate date);

    @Query("SELECT e FROM IndividualEvent e WHERE e.eventDate >= :date and e.discipline.name = :discipline")
    List<IndividualEvent> getActiveEventsByDiscipline(@Param("date") LocalDate date, @Param("discipline") String discipline);

    @Query("SELECT e FROM IndividualEventCompetitor e WHERE e.event.id = :eventID")
    List<IndividualEventCompetitor> getCompetitorsByEvent(@Param("eventID") Long eventID);
}
