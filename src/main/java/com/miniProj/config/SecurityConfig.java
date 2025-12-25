package com.miniProj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
// Import the matcher factory class
import org.springframework.security.web.util.matcher.AntPathRequestMatcher; 

@Configuration
@EnableWebSecurity
@Order(1) // Ensure highest priority
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        System.out.println(">>> CUSTOM SECURITY CONFIG LOADED <<<");
        
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                // 1. Matcher for /healthprobe
                .requestMatchers("/healthprobe").permitAll()
                
                // 2. Explicit AntPathMatcher for /api/master/** using GET method
                .requestMatchers(HttpMethod.GET, "/api/master/**").permitAll() 
                
                // 3. Explicit AntPathMatcher for /api/users/register using POST method //
                .requestMatchers(HttpMethod.POST, "/api/users/register").permitAll()
                // 4
                .requestMatchers("/auth/login", "/api/users/reset-password").permitAll()


                // 4. All other requests must be authenticated
                .anyRequest().authenticated()
            )
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}