package com.example.betapp.mapper;

import com.example.betapp.dto.BetDTO;
import com.example.betapp.entity.Bet;

public class BetMapper {
    public static BetDTO mapToBetDTO(Bet bet) {
        return new BetDTO(
                bet.getId(),
                bet.getDeposit(),
                bet.getClientID(),
                bet.getBetDate()
        );
    }


    public static Bet mapToBet(BetDTO betDTO) {
        return new Bet(
                betDTO.getId(),
                betDTO.getDeposit(),
                betDTO.getClientID(),
                betDTO.getBetDate()
        );
    }
}
