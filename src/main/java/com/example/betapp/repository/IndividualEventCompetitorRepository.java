package com.example.betapp.repository;

import com.example.betapp.entity.IndividualEventCompetitor;
import com.example.betapp.entity.Sportsman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IndividualEventCompetitorRepository extends JpaRepository<IndividualEventCompetitor, Long> {
    @Query("SELECT e FROM IndividualEventCompetitor e WHERE e.event.id = :id")
    List<IndividualEventCompetitor> getSportsmanByEvent(@Param("id") Long id);
}
