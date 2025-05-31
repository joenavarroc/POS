package com.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pos.model.Negocio;

public interface NegocioRepository extends JpaRepository<Negocio, Long> {
}
