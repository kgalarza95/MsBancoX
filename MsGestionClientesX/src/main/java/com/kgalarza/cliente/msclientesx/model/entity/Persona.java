package com.kgalarza.cliente.msclientesx.model.entity;

import jakarta.persistence.Column;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
