package com.example.betapp.service;

import com.example.betapp.dto.BetDTO;
import com.example.betapp.dto.BetEventDTO;
import com.example.betapp.entity.Bet;
import com.example.betapp.entity.BetEvent;
import com.example.betapp.model.BetModel;

import java.util.List;
import java.util.Map;

public interface BetService {
    Bet makeBet(String userID, BetModel betModel);
    Map<BetDTO, List<BetEventDTO>> getUserBets(String userID);
    List<BetEventDTO> getActiveBetEvents(String userID);
    List<BetEventDTO> getInactiveBetEvents(String userID);
}
