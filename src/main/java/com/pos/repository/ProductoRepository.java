package com.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pos.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    
}