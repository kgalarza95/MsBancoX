package com.kgalarza.cuentamovimiento.msbancox.service;

import com.kgalarza.cuentamovimiento.msbancox.model.dto.CuentaInDto;
import com.kgalarza.cuentamovimiento.msbancox.model.dto.CuentaNoValidInDto;
import com.kgalarza.cuentamovimiento.msbancox.model.dto.CuentaOutDto;
import java.util.List;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 *
 * @author kgalarza
 */
@Service
public interface CuentaService {

    public List<CuentaOutDto> findAllCuentas();

    public CuentaOutDto findById(Long id);

    public Mono<CuentaOutDto> createCuenta(CuentaInDto cuentaDto);

    public CuentaOutDto updateCuenta(CuentaInDto cuentaDto);

    public CuentaOutDto updateParcialCuenta(CuentaNoValidInDto cuentaDto);

    public void deleteCuenta(Long id);

}
