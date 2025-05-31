package com.pos.interfaces;

import java.util.List;
import java.util.Optional;

import com.pos.model.Producto;

public interface I_ProductoService {
    List<Producto> listarTodos();
    Optional<Producto> buscarPorId(Long id);
    Producto guardar(Producto producto);
    void eliminar(Long id);
}
