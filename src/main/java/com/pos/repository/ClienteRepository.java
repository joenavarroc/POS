package com.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.pos.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByUsername(String username);
}
