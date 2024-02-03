/**
 * Author: Roshan Adhikari
 * Package: com.dummyex.gatewayservice.config
 *
 * SecurityConfig class is responsible for configuring security settings for the application.
 * It extends WebSecurityConfigurerAdapter to customize the security configuration.
 */
package com.dummyex.gatewayservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * This method configures HTTP security settings for the application.
     * It disables CSRF protection, authorizes requests based on URL patterns, and
     * configures OAuth2 login.
     *
     * @param http HttpSecurity object used for configuring security.
     * @return
     * @throws Exception If any security configuration error occurs.
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .csrf(Customizer.withDefaults()) // Disable CSRF protection
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/dummy/**").authenticated() // Require authentication for /dummy/** URLs
                                .anyRequest().permitAll() // Permit all other requests
                )
                .oauth2Login(Customizer.withDefaults()); // Enable OAuth2 login (simplified for demonstration)
        return http.build();
    }

}
