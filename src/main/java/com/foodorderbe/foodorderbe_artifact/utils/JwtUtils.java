package com.foodorderbe.foodorderbe_artifact.utils;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {
    private String jwtSecret = "58940wpyuit8950p4ueu895y45w4tyu39gyr4jdfghjdfjdfhbtsdtgdfthfgyjuhkldgvfcxbyfj6776568683534678u85";
    private SecretKey key;

    public JwtUtils() {
        key = getSigningKey();
    }

    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(Authentication authentication) {
        return "";
    }

    public boolean validateToken(Authentication authentication) {
        return true;
    }
}