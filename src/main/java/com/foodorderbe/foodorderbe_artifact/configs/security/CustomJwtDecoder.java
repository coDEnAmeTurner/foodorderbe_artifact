package com.foodorderbe.foodorderbe_artifact.configs.security;

import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;

import io.jsonwebtoken.Jwts;

public class CustomJwtDecoder implements JwtDecoder {

    @Override
    public Jwt decode(String token) throws JwtException {
        return (Jwt)Jwts.parser()
                .verifyWith(JwtUtils.getSigningKey())
                .build()
                .parseUnsecuredClaims(token);
    }
    
}
