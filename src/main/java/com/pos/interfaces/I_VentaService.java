package com.pos.interfaces;

import java.util.List;
import java.util.Optional;

import com.pos.model.Venta;

public interface I_VentaService {
    List<Venta> listarTodas();
    Optional<Venta> buscarPorId(Long id);
    Venta guardar(Venta venta);
    void eliminar(Long id);
}
