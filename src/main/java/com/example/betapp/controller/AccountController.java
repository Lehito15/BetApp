package com.example.betapp.controller;

import com.example.betapp.service.AccountService;
import com.example.betapp.tokenparser.TokenParser;
import com.nimbusds.jose.shaded.json.JSONObject;
import com.nimbusds.jose.shaded.json.parser.ParseException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
public class AccountController {
    private AccountService accountService;

    @GetMapping("/account-balance")
    public ResponseEntity<Float> getAccountBalance(
            @RequestHeader("Authorization") String authorizationHeader) throws ParseException {
        TokenParser tp = new TokenParser();
        JSONObject json = tp.parseTokenToJson(authorizationHeader);

        return ResponseEntity.ok(accountService.getBalanceByClientID((String) json.get("sub")));
    }

    @PostMapping("/update-balance")
    public ResponseEntity<Float> updateAccountBalance(
            @RequestHeader("Authorization") String authorizationHeader,
            @RequestBody float amount
    ) throws ParseException {
        TokenParser tp = new TokenParser();
        JSONObject json = tp.parseTokenToJson(authorizationHeader);

        return ResponseEntity.ok(accountService.updateBalanceByClientID((String) json.get("sub"), amount));
    }
}
