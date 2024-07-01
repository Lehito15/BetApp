package com.example.betapp.service.impl;

import com.example.betapp.entity.UserDeposit;
import com.example.betapp.repository.UserDepositeRepository;
import com.example.betapp.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private UserDepositeRepository userDepositeRepository;
    @Override
    public float getBalanceByClientID(String clientID) {
        if(userDepositeRepository.getDepositByClientId(clientID) == null) {
            userDepositeRepository.save(new UserDeposit(clientID, 0.0f));
            return 0.0f;
        }
        return userDepositeRepository.getBalanceByClientId(clientID);
    }

    @Override
    @Transactional
    public float updateBalanceByClientID(String clientID, float amount) {
        if(userDepositeRepository.getDepositByClientId(clientID) != null) {
            userDepositeRepository.updateBalanceByClientId(clientID, amount);
            return userDepositeRepository.getBalanceByClientId(clientID);
        }
        else return 0.0f;
    }
}
