package com.example.betapp.service.impl;

import com.example.betapp.dto.BetDTO;
import com.example.betapp.dto.BetEventDTO;
import com.example.betapp.entity.Bet;
import com.example.betapp.entity.BetEvent;
import com.example.betapp.mapper.BetEventMapper;
import com.example.betapp.mapper.BetMapper;
import com.example.betapp.model.BetModel;
import com.example.betapp.model.EventWinnerModel;
import com.example.betapp.repository.*;
import com.example.betapp.service.BetService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class BetServiceImpl implements BetService {
    private BetRepository betRepository;
    private BetEventRepository betEventRepository;
    private TeamEventRepository teamEventRepository;
    private IndividualEventRepository individualEventRepository;
    private SportsmanRepository sportsmanRepository;
    private TeamRepository teamRepository;
    private UserDepositeRepository userDepositeRepository;

    @Transactional
    @Override
    public Bet makeBet(String userID, BetModel betModel) {
        Bet bet = betRepository.save(new Bet(betModel.getDeposit(), userID, LocalDate.now()));

        userDepositeRepository.updateBalanceByClientId(userID, -1 * betModel.getDeposit());

        for(EventWinnerModel eventWinner: betModel.getEventsWinners()) {
             if(eventWinner.getIsSingleCompetition()) {
                 betEventRepository.save(new BetEvent(
                         bet,
                         individualEventRepository.getIndividualEventById(eventWinner.getEventID()),
                         null,
                         sportsmanRepository.getSportsmanById(eventWinner.getWinnerID()),
                         null
                 ));
             }else {
                 betEventRepository.save(new BetEvent(
                         bet,
                         null,
                         teamEventRepository.getTeamEventById(eventWinner.getEventID()),
                         null,
                         teamRepository.getTeamById(eventWinner.getWinnerID())
                 ));
             }
        }

        return bet;
    }

    @Override
    public Map<BetDTO, List<BetEventDTO>> getUserBets(String userID) {
        Map<BetDTO, List<BetEventDTO>> clientBets = new HashMap<>();
        List<Bet> betList = betRepository.getBetByClientId(userID);

        for(Bet bet: betList) {
            List<BetEvent> betEventList = betEventRepository.getBetByBet(bet);
            List<BetEventDTO> betEventDTOList = betEventList.stream()
                    .map(BetEventMapper::mapToBetEventDTO)
                    .collect(Collectors.toList());
            clientBets.put(BetMapper.mapToBetDTO(bet), betEventDTOList);
        }
        return clientBets;
    }

    @Override
    public List<BetEventDTO> getActiveBetEvents(String userID) {
        List<BetEventDTO> individualActive = betEventRepository.getActiveBetIndividualEvents(LocalDate.now(), userID).stream().map((betEvent ->
                BetEventMapper.mapToBetEventDTO(betEvent))).collect(Collectors.toList());
        List<BetEventDTO> teamActive = betEventRepository.getActiveBetTeamEvents(LocalDate.now(), userID).stream().map((betEvent ->
                BetEventMapper.mapToBetEventDTO(betEvent))).collect(Collectors.toList());

        List<BetEventDTO> active = new ArrayList<BetEventDTO>();
        active.addAll(individualActive);
        active.addAll(teamActive);

        return active;
    }

    @Override
    public List<BetEventDTO> getInactiveBetEvents(String userID) {
        List<BetEventDTO> individualInactive = betEventRepository.getInactiveBetIndividualEvents(LocalDate.now(), userID).stream().map((betEvent ->
                BetEventMapper.mapToBetEventDTO(betEvent))).collect(Collectors.toList());
        List<BetEventDTO> teamInactive = betEventRepository.getInactiveBetTeamEvents(LocalDate.now(), userID).stream().map((betEvent ->
                BetEventMapper.mapToBetEventDTO(betEvent))).collect(Collectors.toList());

        List<BetEventDTO> active = new ArrayList<BetEventDTO>();
        active.addAll(individualInactive);
        active.addAll(teamInactive);

        return active;
    }
}
