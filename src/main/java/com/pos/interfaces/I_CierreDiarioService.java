package com.pos.interfaces;

import java.util.List;
import java.util.Optional;

import com.pos.model.CierreDiario;

public interface I_CierreDiarioService {
    List<CierreDiario> listarTodos();
    Optional<CierreDiario> buscarPorId(Long id);
    CierreDiario guardar(CierreDiario cierre);
    void eliminar(Long id);
}
