package com.kgalarza.cuentamovimiento.msbancox.model.dto;

import lombok.Data;

/**
 *
 * @author kgalarza
 */
@Data
public abstract class CampoEntradaInDto {

    private String usuarioSesion;
    private String uuid;
}
