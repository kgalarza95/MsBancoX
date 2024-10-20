package com.kgalarza.cuentamovimiento.msbancox.service.impl;

import com.kgalarza.cuentamovimiento.msbancox.exception.ResourceNotFoundException;
import com.kgalarza.cuentamovimiento.msbancox.exception.ValidacionGeneralCtasException;
import com.kgalarza.cuentamovimiento.msbancox.mapper.MovimientoMapper;
import com.kgalarza.cuentamovimiento.msbancox.model.dto.MovimientoInDto;
import com.kgalarza.cuentamovimiento.msbancox.model.dto.MovimientoOutDto;
import com.kgalarza.cuentamovimiento.msbancox.model.entity.Cuenta;
import com.kgalarza.cuentamovimiento.msbancox.model.entity.Movimiento;
import com.kgalarza.cuentamovimiento.msbancox.repository.CuentaRepository;
import com.kgalarza.cuentamovimiento.msbancox.repository.MovimientoRepository;
import com.kgalarza.cuentamovimiento.msbancox.service.MovimientoService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kgalarza
 */
@Service
public class MovimientoServiceImpl implements MovimientoService {

    private final CuentaRepository cuentaRepository;
    private final MovimientoRepository movimientoRepository;
    private final MovimientoMapper movimientoMapper;

    @Autowired
    public MovimientoServiceImpl(CuentaRepository cuentaRepository, MovimientoRepository movimientoRepository, MovimientoMapper movimientoMapper) {
        this.cuentaRepository = cuentaRepository;
        this.movimientoRepository = movimientoRepository;
        this.movimientoMapper = movimientoMapper;
    }

    public List<MovimientoOutDto> findAllMovimientos() {
        List<Movimiento> listMovimientos = movimientoRepository.findAll();
        if (listMovimientos.isEmpty()) {
            throw new ResourceNotFoundException("No hay registros para mostrar");
        }
        return movimientoMapper.toDtoList(listMovimientos);
    }

    public MovimientoOutDto findById(Long id) {
        Movimiento movimiento = movimientoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movimiento no encontrado con id: " + id));
        return movimientoMapper.toDto(movimiento);
    }

    public MovimientoOutDto generarMovimineto(MovimientoInDto movimientoDto) {
        Cuenta cuenta = cuentaRepository.findById(movimientoDto.getIdCuenta()).orElseThrow(() -> new ResourceNotFoundException("No se encontró la cuenta con id: " + movimientoDto.getIdCuenta()));
        Movimiento movimiento = movimientoMapper.toEntity(movimientoDto);
        System.out.println("id de cuenta: " + movimiento.getCuenta());
        double valorFinalMovimiento = cuenta.getSaldoEnLinea() + movimiento.getValorMovimiento();

        if (valorFinalMovimiento < 0) {
            throw new ValidacionGeneralCtasException("Saldo no disponible");
        }

        movimiento.setFechaMovimiento(LocalDateTime.now());
        movimiento.setSaldoInicial(cuenta.getSaldoEnLinea());
        movimiento.setSaldoDisponible(valorFinalMovimiento);
        String descripcionMov = movimiento.getValorMovimiento() < 0 ? "Retiro de " + (movimiento.getValorMovimiento() * -1) : "Depósito de " + movimiento.getValorMovimiento();
        movimiento.setDescripcionMovimiento(descripcionMov);
        movimiento = movimientoRepository.save(movimiento);

        cuenta.setSaldoEnLinea(valorFinalMovimiento);
        cuentaRepository.save(cuenta);

        return movimientoMapper.toDto(movimiento);
    }

    public MovimientoOutDto updateMovimiento(MovimientoInDto movimientoDto) {
        movimientoRepository.findById(movimientoDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Movimiento no encontrada con id: " + movimientoDto.getId()));

        Movimiento movimientoActualizar = movimientoMapper.toEntity(movimientoDto);
        Movimiento movimientoResp = movimientoRepository.save(movimientoActualizar);
        return movimientoMapper.toDto(movimientoResp);
    }

    public MovimientoOutDto updateParcialMovimiento(MovimientoInDto movimientoDto) {
        movimientoRepository.findById(movimientoDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Movimiento no encontrada con id: " + movimientoDto.getId()));

        Movimiento movimientoActualizar = movimientoMapper.toEntity(movimientoDto);
        Movimiento movimientoResp = movimientoRepository.save(movimientoActualizar);
        return movimientoMapper.toDto(movimientoResp);
    }

    public void deleteMovimiento(Long id) {
        movimientoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movimiento no encontrada con id: " + id));
        movimientoRepository.deleteById(id);
    }

}
