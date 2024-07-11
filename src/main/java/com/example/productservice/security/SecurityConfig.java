package com.example.productservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                // Only allow access to /products/{id} if the user has the SCOPE_ADMIN authority
                        .requestMatchers("/products/{id}")
                        .hasAuthority("SCOPE_ADMIN")
                 // Allow all other requests
//                        .anyRequest().permitAll()
                )
                // Configure OAuth2 Resource Server to use JWT for authentication
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));

        return http.build();
    }

}