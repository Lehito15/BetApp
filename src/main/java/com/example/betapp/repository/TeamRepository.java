package com.example.betapp.repository;

import com.example.betapp.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TeamRepository extends JpaRepository<Team, Long> {
    @Query("SELECT e FROM Team e WHERE e.id = :id")
    Team getTeamById(@Param("id") Long id);
}
