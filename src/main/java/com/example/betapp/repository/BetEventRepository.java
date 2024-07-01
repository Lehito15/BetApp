package com.example.betapp.repository;

import com.example.betapp.entity.Bet;
import com.example.betapp.entity.BetEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BetEventRepository extends JpaRepository<BetEvent, Long> {
    @Query("SELECT e FROM BetEvent e WHERE e.bet = :bet")
    List<BetEvent> getBetByBet(@Param("bet") Bet bet);

    @Query("SELECT e FROM BetEvent e WHERE e.bet.clientID = :userID")
    List<BetEvent> getUserBetEvents(@Param("userID") String userID);


    @Query("SELECT e FROM BetEvent e WHERE e.bet.clientID = :userID and e.individualEvent.eventDate < :date")
    List<BetEvent> getInactiveBetIndividualEvents(@Param("date") LocalDate date, @Param("userID") String userID);

    @Query("SELECT e FROM BetEvent e WHERE (e.bet.clientID = :userID and e.individualEvent.eventDate >= :date)")
    List<BetEvent> getActiveBetIndividualEvents(@Param("date") LocalDate date, @Param("userID") String userID);


    @Query("SELECT e FROM BetEvent e WHERE e.bet.clientID = :userID and e.teamEvent.eventDate < :date")
    List<BetEvent> getInactiveBetTeamEvents(@Param("date") LocalDate date, @Param("userID") String userID);

    @Query("SELECT e FROM BetEvent e WHERE (e.bet.clientID = :userID and e.teamEvent.eventDate >= :date)")
    List<BetEvent> getActiveBetTeamEvents(@Param("date") LocalDate date, @Param("userID") String userID);

}
