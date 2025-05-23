package com.data.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ConfigSecurity {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeHttpRequests().requestMatchers("/createAccount").permitAll();
        http.authorizeHttpRequests().requestMatchers("/accounts/**").hasAnyRole("ADMIN")
                .requestMatchers("/updateAccount/**").hasAnyRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .httpBasic();

        return http.build();
    }

}
