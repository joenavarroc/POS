package com.pos.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections; // Para roles vacíos o por defecto

public class ClienteDetails implements UserDetails {

    private final Cliente cliente;

    public ClienteDetails(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Si tienes roles para el cliente, deberías retornarlos aquí.
        // Por ejemplo, si Cliente tiene un campo `roles` o algo similar, lo procesas aquí.
        // Si no tienes roles, puedes dejarlo como null o retornar una lista vacía.
        // Retorno una lista vacía en caso de no tener roles específicos.
        return Collections.emptyList(); // Para clientes sin roles específicos
    }

    @Override
    public String getPassword() {
        return cliente.getPassword(); // Obtén la contraseña del cliente
    }

    @Override
    public String getUsername() {
        return cliente.getUsername(); // Obtén el nombre de usuario del cliente
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Si no tienes lógica de expiración de cuenta, retorna true
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Si no tienes lógica de bloqueo de cuenta, retorna true
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Si no tienes lógica de expiración de credenciales, retorna true
    }

    @Override
    public boolean isEnabled() {
        return true; // Si no tienes lógica para habilitar/deshabilitar cuentas, retorna true
    }
}
