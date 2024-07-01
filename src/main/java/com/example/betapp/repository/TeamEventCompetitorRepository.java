package com.example.betapp.repository;

import com.example.betapp.entity.Team;
import com.example.betapp.entity.TeamEventCompetitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeamEventCompetitorRepository extends JpaRepository<TeamEventCompetitor, Long> {

    @Query("SELECT e FROM TeamEventCompetitor e WHERE e.event.id = :id")
    List<TeamEventCompetitor> getTeamsByEvent(@Param("id") Long id);
}
