package com.kgalarza.cliente.msclientesx.model.entity;

import jakarta.persistence.Column;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 *
 * @author kgalarza
 */
@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Persona extends Auditoria {

    @Column(nullable = false)
    private String nombre;
    private String genero;
    private int edad;

    @Column(nullable = false, unique = true)
    private String identificacion;
    private String direccion;
    private String telefono;

}
