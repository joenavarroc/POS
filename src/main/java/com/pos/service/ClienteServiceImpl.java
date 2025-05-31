package com.pos.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.pos.interfaces.I_ClienteService;
import com.pos.model.Cliente;
import com.pos.repository.ClienteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements I_ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente guardar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void eliminar(Long id) {
        clienteRepository.deleteById(id);
    }

    // Método que carga el cliente por su username
    public Cliente loadClienteByUsername(String username) {
        return clienteRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con username: " + username));
    }
}
