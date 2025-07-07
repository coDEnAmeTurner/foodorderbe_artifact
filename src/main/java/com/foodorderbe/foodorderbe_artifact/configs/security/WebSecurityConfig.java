package com.foodorderbe.foodorderbe_artifact.configs.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationProvider;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;

import com.foodorderbe.foodorderbe_artifact.services.service_implements.UserServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                                .csrf(csrf -> csrf.ignoringRequestMatchers("/Users/login"))
                                .authorizeHttpRequests((authorize) -> authorize
                                                .requestMatchers("/Users/login").permitAll() // allow flow to login api
                                                                                             // without authentication
                                                                                             // and authorization
                                                .anyRequest().authenticated())
                                .addFilterBefore(new JwtAuthenticationFilter(jwtAuthenticationManager()),
                                                UsernamePasswordAuthenticationFilter.class);

                return http.build();
        }

        @Bean
        public AuthenticationManager daoAuthenticationManager() {
                DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider(new UserServiceImpl());
                authenticationProvider.setPasswordEncoder(passwordEncoder());

                return new ProviderManager(authenticationProvider);
        }

        public AuthenticationManager jwtAuthenticationManager() {
                JwtAuthenticationProvider jwtAuthenticationProvider = new JwtAuthenticationProvider(jwtDecoder());
                jwtAuthenticationProvider.setJwtAuthenticationConverter(new JwtAuthenticationConverter());

                return new ProviderManager(jwtAuthenticationProvider);
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
                return PasswordEncoderFactories.createDelegatingPasswordEncoder();
        }

        @Bean
        public JwtDecoder jwtDecoder() {
                return new CustomJwtDecoder();
        }
}