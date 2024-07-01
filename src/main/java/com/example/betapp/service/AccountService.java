package com.example.betapp.service;

public interface AccountService {
    float getBalanceByClientID(String clientID);
    float updateBalanceByClientID(String clientID, float amount);
}
