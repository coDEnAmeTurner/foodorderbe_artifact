package com.foodorderbe.foodorderbe_artifact.configs.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.DelegatingJwtGrantedAuthoritiesConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationProvider;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

        @Autowired
        private UserDetailsService userDetailsService;

        @Autowired
        private PasswordEncoder passwordEncoder;

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                                .csrf(csrf -> csrf.disable())
                                .cors(cors -> cors.disable())
                                .authorizeHttpRequests((authorize) -> authorize
                                                .requestMatchers("/Users/login").permitAll()
                                                .requestMatchers("/**").hasRole("ADMIN")
                                                .anyRequest().authenticated())
                                .addFilterAfter(new JwtAuthenticationFilter(jwtAuthenticationManager()),
                                                LogoutFilter.class);

                return http.build();
        }

        @Bean
        public UserTypeAuthorityMapper grantedAuthoritiesMapper() {
                return new UserTypeAuthorityMapper();
        }

        @Bean
        public AuthenticationManager daoAuthenticationManager() {
                DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider(userDetailsService);
                authenticationProvider.setPasswordEncoder(passwordEncoder);

                return new ProviderManager(authenticationProvider);
        }

        public AuthenticationManager jwtAuthenticationManager() {
                JwtAuthenticationProvider jwtAuthenticationProvider = new JwtAuthenticationProvider(jwtDecoder());
                jwtAuthenticationProvider.setJwtAuthenticationConverter(jwtAuthenticationConverter());

                return new ProviderManager(jwtAuthenticationProvider);
        }

        private JwtAuthenticationConverter jwtAuthenticationConverter() {
                JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
                jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(null);
                return jwtAuthenticationConverter;
        }

        @Bean
        public JwtDecoder jwtDecoder() {
                return new CustomJwtDecoder();
        }
}