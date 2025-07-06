package com.foodorderbe.foodorderbe_artifact.configs.security;

import java.util.Calendar;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;

import com.foodorderbe.foodorderbe_artifact.entities.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

public class JwtUtils {
    private static final String jwtSecret = "4261656C64756asdfqwerdfgertgsxbvartqtersdfg23415346E67";
    private static final Integer jwtExpiration = 2;

    public static SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public static String generateJwtToken(Authentication authentication) {
        User userPrincipal = (User) authentication.getPrincipal();

        return Jwts.builder()
                .subject((userPrincipal.getUsername()))
                .issuedAt(new Date())
                .expiration(new Date((Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + jwtExpiration)))
                .signWith(getSigningKey())
                .compact();
    }
}
