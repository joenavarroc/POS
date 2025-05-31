package com.pos.interfaces;

import java.util.List;
import java.util.Optional;

import com.pos.model.Categoria;

public interface I_CategoriaService {
    List<Categoria> listarTodas();
    Optional<Categoria> buscarPorId(Long id);
    Categoria guardar(Categoria categoria);
    void eliminar(Long id);
}

