package com.pos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Negocio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    // Getter para id (automático por Lombok o manual si lo prefieres)
    public Integer getId() {
        return id;
    }

    // Getter para nombre
    public String getNombre() {
        return nombre;
    }

    // Setter para nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método toString para mostrar la entidad de manera sencilla (opcional)
    @Override
    public String toString() {
        return "Negocio{id=" + id + ", nombre='" + nombre + "'}";
    }
}
