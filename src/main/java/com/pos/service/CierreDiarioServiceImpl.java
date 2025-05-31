package com.pos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pos.interfaces.I_CierreDiarioService;
import com.pos.model.CierreDiario;
import com.pos.repository.CierreDiarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CierreDiarioServiceImpl implements I_CierreDiarioService {

    private final CierreDiarioRepository cierreDiarioRepository;

    @Override
    public List<CierreDiario> listarTodos() {
        return cierreDiarioRepository.findAll();
    }

    @Override
    public Optional<CierreDiario> buscarPorId(Long id) {
        return cierreDiarioRepository.findById(id);
    }

    @Override
    public CierreDiario guardar(CierreDiario cierre) {
        return cierreDiarioRepository.save(cierre);
    }

    @Override
    public void eliminar(Long id) {
        cierreDiarioRepository.deleteById(id);
    }
}
