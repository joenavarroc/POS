package com.pos.interfaces;

import java.util.List;
import java.util.Optional;

import com.pos.model.DetalleVenta;

public interface I_DetalleVentaService {
    List<DetalleVenta> listarTodos();
    Optional<DetalleVenta> buscarPorId(Long id);
    DetalleVenta guardar(DetalleVenta detalle);
    void eliminar(Long id);
}

