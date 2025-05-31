package com.pos.service;

import com.pos.model.Cliente;
import com.pos.repository.ClienteRepository;
import com.pos.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class ClienteDetailsService implements UserDetailsService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Cliente cliente = clienteRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("Cliente no encontrado: " + username));

        return new CustomUserDetails(cliente);
    }
}
