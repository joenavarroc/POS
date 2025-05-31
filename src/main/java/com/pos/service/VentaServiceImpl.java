package com.pos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pos.interfaces.I_VentaService;
import com.pos.model.Venta;
import com.pos.repository.VentaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VentaServiceImpl implements I_VentaService {

    private final VentaRepository ventaRepository;

    @Override
    public List<Venta> listarTodas() {
        return ventaRepository.findAll();
    }

    @Override
    public Optional<Venta> buscarPorId(Long id) {
        return ventaRepository.findById(id);
    }

    @Override
    public Venta guardar(Venta venta) {
        return ventaRepository.save(venta);
    }

    @Override
    public void eliminar(Long id) {
        ventaRepository.deleteById(id);
    }
}
