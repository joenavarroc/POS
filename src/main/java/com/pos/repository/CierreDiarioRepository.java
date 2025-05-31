package com.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pos.model.CierreDiario;

@Repository
public interface CierreDiarioRepository extends JpaRepository<CierreDiario, Long> {
    
}
