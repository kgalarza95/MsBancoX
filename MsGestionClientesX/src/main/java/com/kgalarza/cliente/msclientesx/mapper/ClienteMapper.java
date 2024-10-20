package com.kgalarza.cliente.msclientesx.mapper;

import com.kgalarza.cliente.msclientesx.model.dto.ClienteInDto;
import com.kgalarza.cliente.msclientesx.model.dto.ClienteInOutDto;
import com.kgalarza.cliente.msclientesx.model.entity.Cliente;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author usuario
 */
@Mapper(componentModel = "spring")
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    // De ClienteInDto a Cliente (para crear o actualizar)
    Cliente toEntity(ClienteInDto clienteInDto);

    // De Cliente a ClienteOutDto (para salida)
    ClienteInOutDto toDto(Cliente cliente);

    // Mapear lista de Cliente a lista de ClienteOutDto
    List<ClienteInOutDto> toDtoList(List<Cliente> clientes);

    // Mapear lista de ClienteInDto a lista de Cliente (opcional)
    List<Cliente> toEntityList(List<ClienteInDto> clientesInDto);

//    // Mapea un Cliente a ClienteDto
//    ClienteInOutDto toDto(Cliente cliente);
//
//    // Mapea un ClienteDto a Cliente
//    Cliente toEntity(ClienteInOutDto clienteDto);
//
//    // Método para actualizar una entidad desde un DTO
//    @Mapping(target = "id", ignore = true)
//    void updateEntityFromDto(ClienteInOutDto clienteDto, @MappingTarget Cliente cliente);
}
