package com.pos.auth;

import com.pos.model.Negocio;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String username;
    private String password;
    private String nombre;
    private String email;
    private Negocio negocio;  // Relación con Negocio
}
