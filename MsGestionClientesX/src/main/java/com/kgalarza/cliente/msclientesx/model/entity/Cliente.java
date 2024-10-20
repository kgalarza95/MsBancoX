package com.kgalarza.cliente.msclientesx.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author kgalarza
 */
@Entity
@Table(name = "clientes", uniqueConstraints = @UniqueConstraint(columnNames = "clienteid"))
@Data
@EqualsAndHashCode(callSuper = false)
public class Cliente extends Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteid;
    private String contrasena;
    private boolean estado;


}
