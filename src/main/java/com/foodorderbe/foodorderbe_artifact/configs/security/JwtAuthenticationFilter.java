package com.foodorderbe.foodorderbe_artifact.configs.security;

import java.io.IOException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.oauth2.server.resource.authentication.BearerTokenAuthenticationToken;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        super();
        this.authenticationManager = authenticationManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        String authorization = request.getHeader("Authorization");

        if (authorization != null) {
            Authentication tokenAuthentication = new BearerTokenAuthenticationToken(authorization.substring(7));
            Authentication processedAuthentication = authenticationManager.authenticate(tokenAuthentication);
            if (processedAuthentication.isAuthenticated()) {
                SecurityContextHolder.getContext().setAuthentication(processedAuthentication);
            }
            filterChain.doFilter(request, response);
        } else {
            filterChain.doFilter(request, response);
            return;
        }

    }

}
