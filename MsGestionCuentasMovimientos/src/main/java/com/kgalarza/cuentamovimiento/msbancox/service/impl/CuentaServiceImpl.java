package com.kgalarza.cuentamovimiento.msbancox.service.impl;

import com.kgalarza.cuentamovimiento.msbancox.exception.RegistroDuplicadoException;
import com.kgalarza.cuentamovimiento.msbancox.exception.ResourceNotFoundException;
import com.kgalarza.cuentamovimiento.msbancox.mapper.CuentaMapper;
import com.kgalarza.cuentamovimiento.msbancox.model.dto.CuentaInDto;
import com.kgalarza.cuentamovimiento.msbancox.model.dto.CuentaNoValidInDto;
import com.kgalarza.cuentamovimiento.msbancox.model.dto.CuentaOutDto;
import com.kgalarza.cuentamovimiento.msbancox.model.entity.Cuenta;
import com.kgalarza.cuentamovimiento.msbancox.repository.CuentaRepository;
import com.kgalarza.cuentamovimiento.msbancox.service.CuentaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kgalarza
 */
@Service
public class CuentaServiceImpl implements CuentaService {

    private final CuentaRepository cuentaRepository;
    private final CuentaMapper cuentaMapper;

    @Autowired
    public CuentaServiceImpl(CuentaRepository cuentaRepository, CuentaMapper cuentaMapper) {
        this.cuentaRepository = cuentaRepository;
        this.cuentaMapper = cuentaMapper;
    }

    public List<CuentaOutDto> findAllCuentas() {

        List<Cuenta> cuentas = cuentaRepository.findAll();
        if (cuentas.isEmpty()) {
            throw new ResourceNotFoundException("No hay registros para mostrar");
        }
        return cuentaMapper.toDtoList(cuentas);
//        return listCuentaDto.stream()
//                .map(cuenta -> modelMapper.map(cuenta, CuentaOutDto.class))
//                .collect(Collectors.toList());
    }

    public CuentaOutDto findById(Long id) {
        Cuenta cuenta = cuentaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cuenta no encontrada con id: " + id));
        return cuentaMapper.toDto(cuenta);
    }

    public CuentaOutDto createCuenta(CuentaInDto cuentaDto) {
        //llamada asincrona a clientes
//        clienteService.getClienteById(cuentaDto.getClienteid());

//        this.webClient = webClientBuilder.baseUrl("https://api.example.com").build();
        if (cuentaRepository.existsByNumeroCuenta(cuentaDto.getNumeroCuenta())) {
            throw new RegistroDuplicadoException("La cuenta ya se encuentra registrada.");
        }
        Cuenta cuenta = cuentaMapper.toEntity(cuentaDto);
        cuenta = cuentaRepository.save(cuenta);
        return cuentaMapper.toDto(cuenta);
    }

    public CuentaOutDto updateCuenta(CuentaInDto cuentaDto) {
        cuentaRepository.findById(cuentaDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Cuenta no encontrada con id: " + cuentaDto.getId()));

        Cuenta cuentaActualizar = cuentaMapper.toEntity(cuentaDto);
        Cuenta cuentaResp = cuentaRepository.save(cuentaActualizar);
        return cuentaMapper.toDto(cuentaResp);
    }

    public CuentaOutDto updateParcialCuenta(CuentaNoValidInDto cuentaDto) {
        cuentaRepository.findById(cuentaDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Cuenta no encontrada con id: " + cuentaDto.getId()));

        Cuenta cuentaActualizar = cuentaMapper.noValidToEntity(cuentaDto);
        Cuenta cuentaResp = cuentaRepository.save(cuentaActualizar);
        return cuentaMapper.toDto(cuentaResp);
    }

    public void deleteCuenta(Long id) {
        cuentaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cuenta no encontrada con id: " + id));
        cuentaRepository.deleteById(id);
    }

}
