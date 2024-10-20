package com.kgalarza.cuentamovimiento.msbancox.controller;

import com.kgalarza.cuentamovimiento.msbancox.model.dto.ReporteEstadoCuentaDto;
import com.kgalarza.cuentamovimiento.msbancox.service.ReporteService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kgalarza
 */
@RestController
@RequestMapping("v1/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping
    public List<ReporteEstadoCuentaDto> obtenerReporteEstadoCuenta(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,
            @RequestParam Long idCliente) {
        return reporteService.generarReporteEstadoCuenta(fechaInicio, fechaFin, idCliente);
    }

//    @GetMapping
//    public List<ReporteEstadoCuentaDto> obtenerReporteEstadoCuenta(
//            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
//            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin) {
//        return reporteService.generarReporteEstadoCuenta(fechaInicio, fechaFin);
//    }

    @GetMapping("/todos")
    public List<ReporteEstadoCuentaDto> obtenerTodosLosReportes() {
        return reporteService.generarReporteEstadoCuenta();
    }

}
