package com.kgalarza.cuentamovimiento.msbancox.mapper;

import com.kgalarza.cuentamovimiento.msbancox.model.dto.MovimientoInDto;
import com.kgalarza.cuentamovimiento.msbancox.model.dto.MovimientoOutDto;
import com.kgalarza.cuentamovimiento.msbancox.model.entity.Movimiento;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author usuario
 */
@Mapper(componentModel = "spring", uses = {CuentaMapper.class})
public interface MovimientoMapper {

    MovimientoMapper INSTANCE = Mappers.getMapper(MovimientoMapper.class);

    @Mapping(source = "idCuenta", target = "cuenta.id")
    Movimiento toEntity(MovimientoInDto movimientoInDto);

    @Mapping(source = "cuenta.id", target = "idCuenta")
    MovimientoOutDto toDto(Movimiento cuenta);

    List<MovimientoOutDto> toDtoList(List<Movimiento> cuentas);
}
