package com.pos.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pos.auth.AuthResponse;
import com.pos.auth.LoginRequest;
import com.pos.auth.RegisterRequest;
import com.pos.model.Cliente;
import com.pos.repository.ClienteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final ClienteRepository clienteRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    // Método para login
    public AuthResponse login(LoginRequest request) {
        // Autenticar usuario
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        // Buscar cliente por username
        Cliente cliente = clienteRepository.findByUsername(request.getUsername())
            .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        // Generar el token JWT
        String token = jwtService.getToken(cliente);

        return AuthResponse.builder()
            .token(token)
            .build();
    }

    // Método para registro
    public String register(RegisterRequest request) {
        // Verificar si ya existe un cliente con ese username
        if (clienteRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("El nombre de usuario ya está en uso");
        }

        // Crear nuevo cliente
        Cliente cliente = Cliente.builder()
            .username(request.getUsername())
            .password(passwordEncoder.encode(request.getPassword()))  // Cifrado de la contraseña
            .nombre(request.getNombre())
            .email(request.getEmail())  // Usamos el email proporcionado
            .negocio(request.getNegocio())  // Asociamos el negocio (esto es necesario si lo has incluido en el request)
            .build();

        clienteRepository.save(cliente);

        return "Cliente registrado exitosamente";
    }
}
