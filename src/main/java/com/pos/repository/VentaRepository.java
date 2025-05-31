package com.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pos.model.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
    
}
