package com.product.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    private final String secret;

    public JwtService(
            @Value("${jwt.secret}") String secret
    ) {
        this.secret = secret;
    }


    public String extractEmail(String token) {

        return extractClaims(token)
                .getSubject();
    }


    public boolean isValid(String token) {

        try {

            extractClaims(token);

            return true;

        } catch (Exception e) {

            return false;
        }
    }


    private Claims extractClaims(String token) {

        return Jwts.parser()
                .verifyWith(
                        Keys.hmacShaKeyFor(
                                secret.getBytes()
                        )
                )
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}