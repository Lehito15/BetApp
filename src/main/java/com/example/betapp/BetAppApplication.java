package com.example.betapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@SpringBootApplication
public class BetAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(BetAppApplication.class, args);
    }


}
