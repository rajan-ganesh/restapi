package com.ganesh.restapi.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

public class JwtTokenValidator {

    @Value("${jwt.secret}")
    private String SECRET_KEY;

    public boolean validateToken(String token) {
        try {
            Jws<Claims> claimsJws = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token);

            // Check expiration
            Date expirationDate = claimsJws.getBody().getExpiration();
            if (expirationDate.before(new Date())) {
                return false;
            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}