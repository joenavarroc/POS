package com.pos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pos.interfaces.I_DetalleVentaService;
import com.pos.model.DetalleVenta;
import com.pos.repository.DetalleVentaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DetalleVentaServiceImpl implements I_DetalleVentaService {

    private final DetalleVentaRepository detalleVentaRepository;

    @Override
    public List<DetalleVenta> listarTodos() {
        return detalleVentaRepository.findAll();
    }

    @Override
    public Optional<DetalleVenta> buscarPorId(Long id) {
        return detalleVentaRepository.findById(id);
    }

    @Override
    public DetalleVenta guardar(DetalleVenta detalle) {
        return detalleVentaRepository.save(detalle);
    }

    @Override
    public void eliminar(Long id) {
        detalleVentaRepository.deleteById(id);
    }
}
