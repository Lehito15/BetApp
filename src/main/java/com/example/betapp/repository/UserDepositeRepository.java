package com.example.betapp.repository;

import com.example.betapp.entity.UserDeposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDepositeRepository extends JpaRepository<UserDeposit, Long> {
    @Query("SELECT e.balance FROM UserDeposit e WHERE e.clientID = :id")
    float getBalanceByClientId(@Param("id") String id);

    @Query("SELECT e FROM UserDeposit e WHERE e.clientID = :id")
    UserDeposit getDepositByClientId(@Param("id") String id);

    @Modifying
    @Query("UPDATE UserDeposit e SET e.balance = e.balance + :amount WHERE e.clientID = :id")
    void updateBalanceByClientId(@Param("id") String id, @Param("amount") float amount);
}
