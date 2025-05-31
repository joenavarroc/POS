package com.pos.interfaces;

import java.util.List;
import java.util.Optional;

import com.pos.model.Cliente;

public interface I_ClienteService {
    List<Cliente> listarTodos();
    Optional<Cliente> buscarPorId(Long id);
    Cliente guardar(Cliente cliente);
    void eliminar(Long id);
}
