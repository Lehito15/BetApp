package com.example.betapp.security.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(csrf -> {
                    csrf.disable();
                })
                .authorizeRequests(authorizeRequests -> {
                    authorizeRequests
                            .requestMatchers("/**").permitAll()
                            .anyRequest().authenticated();
                })
                .oauth2Login(withDefaults())
                .logout(l -> l
                        .logoutSuccessUrl("/events").permitAll()
                );
        return httpSecurity.build();
    }
}

