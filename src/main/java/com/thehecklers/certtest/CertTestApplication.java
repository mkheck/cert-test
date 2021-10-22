package com.thehecklers.certtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class CertTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(CertTestApplication.class, args);
    }

}

@EnableWebSecurity
class WebSecurityConfig {
    @Bean
    SecurityFilterChain authorize(HttpSecurity http) throws Exception {
        return http.authorizeRequests().mvcMatchers("/**")
                .permitAll()
                .and().build();
    }
}

@RestController
class CertTestController {
    @GetMapping
    String clearedForTakeoff() {
        return "You're now instrument rated!";
    }
}