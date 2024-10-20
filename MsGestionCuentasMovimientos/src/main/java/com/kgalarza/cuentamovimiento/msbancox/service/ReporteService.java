package com.kgalarza.cuentamovimiento.msbancox.service;

import com.kgalarza.cuentamovimiento.msbancox.model.dto.ReporteEstadoCuentaDto;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author kgalarza
 */
@Service
public interface ReporteService {

    public List<ReporteEstadoCuentaDto> generarReporteEstadoCuenta(LocalDate fechaInicio, LocalDate fechaFin, Long idCliente);
    
    public List<ReporteEstadoCuentaDto> generarReporteEstadoCuenta(LocalDate fechaInicio, LocalDate fechaFin);
    
    public List<ReporteEstadoCuentaDto> generarReporteEstadoCuenta();
}
