package com.example.betapp.controller;

import com.example.betapp.dto.BetDTO;
import com.example.betapp.dto.BetEventDTO;
import com.example.betapp.entity.Bet;
import com.example.betapp.model.BetModel;
import com.example.betapp.service.BetService;
import com.example.betapp.tokenparser.TokenParser;
import com.nimbusds.jose.shaded.json.JSONObject;
import com.nimbusds.jose.shaded.json.parser.ParseException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;


@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
public class BetController {
    private BetService betService;

    @PostMapping("/make-bet")
    public ResponseEntity<Bet> makeBet(
            @RequestHeader ("Authorization") String authorizationHeader,
            @RequestBody BetModel betModel) throws ParseException {

            TokenParser tp = new TokenParser();
            JSONObject json = tp.parseTokenToJson(authorizationHeader);

        return ResponseEntity.ok(betService.makeBet((String) json.get("sub"), betModel));
    }

    @GetMapping("/bets")
    public ResponseEntity<Map<BetDTO, List<BetEventDTO>>> getClientBets(
            @RequestHeader ("Authorization") String authorizationHeader) throws ParseException {

        TokenParser tp = new TokenParser();
        JSONObject json = tp.parseTokenToJson(authorizationHeader);

        return ResponseEntity.ok(betService.getUserBets((String) json.get("sub")));
    }

    @GetMapping("/active-bet-events")
    public ResponseEntity<List<BetEventDTO>> getActiveBetEvents(
            @RequestHeader ("Authorization") String authorizationHeader
    ) throws ParseException {
        TokenParser tp = new TokenParser();
        JSONObject json = tp.parseTokenToJson(authorizationHeader);

        return ResponseEntity.ok(betService.getActiveBetEvents((String) json.get("sub")));
    }


    @GetMapping("/inactive-bet-events")
    public ResponseEntity<List<BetEventDTO>> getInactiveBetEvents(
            @RequestHeader ("Authorization") String authorizationHeader
    ) throws ParseException {
        TokenParser tp = new TokenParser();
        JSONObject json = tp.parseTokenToJson(authorizationHeader);

        return ResponseEntity.ok(betService.getInactiveBetEvents((String) json.get("sub")));
    }




}
