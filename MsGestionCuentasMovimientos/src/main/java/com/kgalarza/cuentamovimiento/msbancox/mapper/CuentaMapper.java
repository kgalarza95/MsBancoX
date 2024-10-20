package com.kgalarza.cuentamovimiento.msbancox.mapper;

import com.kgalarza.cuentamovimiento.msbancox.model.dto.CuentaInDto;
import com.kgalarza.cuentamovimiento.msbancox.model.dto.CuentaNoValidInDto;
import com.kgalarza.cuentamovimiento.msbancox.model.dto.CuentaOutDto;
import com.kgalarza.cuentamovimiento.msbancox.model.dto.MovimientoOutDto;
import com.kgalarza.cuentamovimiento.msbancox.model.entity.Cuenta;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author usuario
 */
@Mapper(componentModel = "spring")
public interface CuentaMapper {

    CuentaMapper INSTANCE = Mappers.getMapper(CuentaMapper.class);

    Cuenta toEntity(CuentaInDto cuentaInDto);

    Cuenta noValidToEntity(CuentaNoValidInDto cuentaNoValidInDto);

    CuentaOutDto toDto(Cuenta cuenta);

    List<CuentaOutDto> toDtoList(List<Cuenta> cuentas);
}
