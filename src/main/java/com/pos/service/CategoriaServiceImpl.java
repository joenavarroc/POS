package com.pos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pos.interfaces.I_CategoriaService;
import com.pos.model.Categoria;
import com.pos.repository.CategoriaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements I_CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> listarTodas() {
        return categoriaRepository.findAll();
    }

    @Override
    public Optional<Categoria> buscarPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public Categoria guardar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public void eliminar(Long id) {
        categoriaRepository.deleteById(id);
    }
}
