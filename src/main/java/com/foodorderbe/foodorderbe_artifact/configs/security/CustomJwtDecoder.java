package com.foodorderbe.foodorderbe_artifact.configs.security;

import java.text.ParseException;

import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;

import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTParser;

import io.jsonwebtoken.Jwts;

public class CustomJwtDecoder implements JwtDecoder {

    @Override
    public Jwt decode(String token) throws JwtException {
        JWT jwt = null;
        try {
            jwt = JWTParser.parse(token);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String getJwkSetUri() {
        // Return the JWK Set URI if applicable
        return null; // Replace with actual JWK Set URI if needed
    }
    
}
