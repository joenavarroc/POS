package com.pos.security;

import com.pos.model.Cliente;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    private final Cliente cliente;

    public CustomUserDetails(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Si luego agregás roles, podés mapearlos acá
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return cliente.getPassword();
    }

    @Override
    public String getUsername() {
        return cliente.getUsername(); // Usamos el campo username como identificador principal
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Podés personalizar según lógica del negocio
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    // Método adicional para obtener el objeto Cliente si lo necesitás en tu lógica
    public Cliente getCliente() {
        return cliente;
    }
}
