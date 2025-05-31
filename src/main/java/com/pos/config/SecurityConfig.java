package com.pos.config;

import com.pos.jwt.JwtAuthenticationFilter;
import com.pos.service.ClienteDetailsService;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final ClienteDetailsService clienteDetailsService; // Inyecta ClienteDetailsService

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/auth/login",  // Asegúrate de que login esté permitido
                    "/auth/register", 
                    "/auth/logout", 
                    "/registrar",
                    "/css/**", 
                    "/js/**", 
                    "/images/**", 
                    "/favicon.ico", 
                    "/test-connection", 
                    "/login.html" // Agrega la ruta login.html
                ).permitAll()
                .anyRequest().authenticated()  // Las demás rutas requieren autenticación
            )
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))  // Sin sesiones
            .authenticationProvider(daoAuthenticationProvider()) // Usar el AuthenticationProvider
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)  // Filtrar JWT
            .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean("passwordEncoderSecurity")
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(clienteDetailsService);  // Usar ClienteDetailsService
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
}
