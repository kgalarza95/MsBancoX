package com.kgalarza.cuentamovimiento.msbancox.service.impl;

import com.kgalarza.cuentamovimiento.msbancox.model.dto.ReporteEstadoCuentaDto;
import com.kgalarza.cuentamovimiento.msbancox.repository.MovimientoRepository;
import com.kgalarza.cuentamovimiento.msbancox.service.ReporteService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kgalarza
 */
@Service
public class ReporteServiceImpl implements ReporteService{

    @Autowired
    private MovimientoRepository movimientoRepository;

    public List<ReporteEstadoCuentaDto> generarReporteEstadoCuenta(LocalDate fechaInicio, LocalDate fechaFin) {
        LocalDateTime fechaInicioDateTime = fechaInicio.atStartOfDay();
        LocalDateTime fechaFinDateTime = fechaFin.atTime(LocalTime.MAX);
        return movimientoRepository.obtenerReporteEstadoCuenta(fechaInicioDateTime, fechaFinDateTime);
    }

    public List<ReporteEstadoCuentaDto> generarReporteEstadoCuenta() {
        return movimientoRepository.obtenerReporteEstadoCuenta();
    }
}
