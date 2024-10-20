package com.kgalarza.cuentamovimiento.msbancox.model.dto;

import lombok.Data;

/**
 *
 * @author kgalarza
 */
@Data
public class MovimientoInDto extends CampoEntradaInDto {

    private Long id;
    private double valorMovimiento;
    private String descripcionMovimiento;
    private Long idCuenta;
}
