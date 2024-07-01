package com.example.betapp.repository;

import com.example.betapp.entity.Bet;
import com.example.betapp.entity.IndividualEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BetRepository extends JpaRepository<Bet, Long> {
    @Query("SELECT e FROM Bet e WHERE e.clientID = :id")
    List<Bet> getBetByClientId(@Param("id") String id);

}
