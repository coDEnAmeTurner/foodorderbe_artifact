package com.foodorderbe.foodorderbe_artifact.configs.security;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.oauth2.server.resource.authentication.BearerTokenAuthenticationToken;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    // This class will be used to intercept requests and check for JWT tokens
    // in the Authorization header.
    // If a valid token is found, it will set the authentication in the security context.

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        Authentication tokenAuthentication = new BearerTokenAuthenticationToken(request.getHeader("Authorization").substring(7));
        

        // Implement JWT validation logic here
        filterChain.doFilter(request, response);
    }
    
}
