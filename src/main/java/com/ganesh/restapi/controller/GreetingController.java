package com.ganesh.restapi.controller;

import com.ganesh.restapi.security.JwtTokenProvider;
import com.ganesh.restapi.security.JwtTokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Autowired
    private JwtTokenValidator jwtTokenValidator;
    @PostMapping("/api/greeting")
    public String hello(@RequestHeader("Authorization") String authorizationHeader) {

        String token = extractToken(authorizationHeader);

        // Validate the token
        if (jwtTokenValidator.validateToken(token)) {

            // From here, any other activities that require authorization can be triggered, such as accessing your account data

            return "Congratulations! Your JWT is Valid and you have been Authorised to play this Game: https://brick-18e13.web.app/";
        } else {
            return "Invalid or Expired token :(";
        }
    }

    private String extractToken(String authorizationHeader) {
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            return authorizationHeader.substring(7);
        }
        return null;
    }
}
