package com.foodorderbe.foodorderbe_artifact.configs.security;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;

import com.nimbusds.jwt.JWTParser;

public class CustomJwtDecoder implements JwtDecoder {

    @Override
    public Jwt decode(String token) throws JwtException {
        try {
            var parsedJwt = JWTParser.parse(token);

            Map<String, Object> headers = new LinkedHashMap<>(parsedJwt.getHeader().toJSONObject());
            Map<String, Object> claims = new HashMap<>();
            for (String key : parsedJwt.getJWTClaimsSet().getClaims().keySet()) {
                Object value = parsedJwt.getJWTClaimsSet().getClaims().get(key);
                if (key.equals("exp") || key.equals("iat")) {
                    value = ((Date) value).toInstant();
                }
                claims.put(key, value);
            }
            return Jwt.withTokenValue(token)
                    .headers(h -> h.putAll(headers))
                    .claims(c -> c.putAll(claims))
                    .build();
        } catch (ParseException e) {
            throw new JwtException("Failed to parse JWT token", e);
        }
    }
}
