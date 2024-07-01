package com.example.betapp.repository;

import com.example.betapp.entity.Sportsman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SportsmanRepository extends JpaRepository<Sportsman, Long> {
    @Query("SELECT e FROM Sportsman e WHERE e.id = :id")
    Sportsman getSportsmanById(@Param("id") Long id);
}
