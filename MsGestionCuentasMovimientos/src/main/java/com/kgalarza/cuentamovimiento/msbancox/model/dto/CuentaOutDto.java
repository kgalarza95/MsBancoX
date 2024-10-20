package com.kgalarza.cuentamovimiento.msbancox.model.dto;

import lombok.Data;

/**
 *
 * @author kgalarza
 */
@Data
public class CuentaOutDto {

    private Long id;
    private String numeroCuenta;
    private String tipoCuenta;
    private double saldoEnLinea;
    private boolean estado;
    private Long clienteid;

}
