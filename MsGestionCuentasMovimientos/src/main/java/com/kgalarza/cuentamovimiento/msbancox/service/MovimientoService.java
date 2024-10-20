package com.kgalarza.cuentamovimiento.msbancox.service;

import com.kgalarza.cuentamovimiento.msbancox.model.dto.MovimientoInDto;
import com.kgalarza.cuentamovimiento.msbancox.model.dto.MovimientoOutDto;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author kgalarza
 */
@Service
public interface MovimientoService {

    public List<MovimientoOutDto> findAllMovimientos();

    public MovimientoOutDto findById(Long id);

    public MovimientoOutDto generarMovimineto(MovimientoInDto movimientoDto);

    public MovimientoOutDto updateMovimiento(MovimientoInDto movimientoDto);

    public MovimientoOutDto updateParcialMovimiento(MovimientoInDto movimientoDto);

    public void deleteMovimiento(Long id);

}
