package com.kgalarza.cliente.msclientesx.mapper;

import com.kgalarza.cliente.msclientesx.model.dto.ClienteInDto;
import com.kgalarza.cliente.msclientesx.model.dto.ClienteInOutDto;
import com.kgalarza.cliente.msclientesx.model.entity.Cliente;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

/**
 *
 * @author usuario
 */
@Component
@Mapper(componentModel = "spring")
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    @Mapping(source = "nombreCliente", target = "nombre")
    @Mapping(source = "generoCliente", target = "genero")
    @Mapping(source = "edadCliente", target = "edad")
    @Mapping(source = "identificacionCliente", target = "identificacion")
    @Mapping(source = "direccionCliente", target = "direccion")
    @Mapping(source = "telefonoCliente", target = "telefono")
    @Mapping(source = "clienteidCliente", target = "clienteid")
    @Mapping(source = "contrasenaCliente", target = "contrasena")
    @Mapping(source = "estadoCliente", target = "estado")
    Cliente toEntity(ClienteInDto clienteInDto);

    @Mapping(source = "nombre", target = "nombreCliente")
    @Mapping(source = "genero", target = "generoCliente")
    @Mapping(source = "edad", target = "edadCliente")
    @Mapping(source = "identificacion", target = "identificacionCliente")
    @Mapping(source = "direccion", target = "direccionCliente")
    @Mapping(source = "telefono", target = "telefonoCliente")
    @Mapping(source = "clienteid", target = "clienteidCliente")
    @Mapping(source = "contrasena", target = "contrasenaCliente")
    @Mapping(source = "estado", target = "estadoCliente")
    ClienteInOutDto toDto(Cliente cliente);

    // Mapea una lista de entidades Cliente a una lista de DTOs de salida
    List<ClienteInOutDto> toDtoList(List<Cliente> clientes);

//    // De ClienteInDto a Cliente (para crear o actualizar)
//    Cliente toEntity(ClienteInDto clienteInDto);
//
//    // De Cliente a ClienteOutDto (para salida)
//    ClienteInOutDto toDto(Cliente cliente);
//
//    // Mapear lista de Cliente a lista de ClienteOutDto
//    List<ClienteInOutDto> toDtoList(List<Cliente> clientes);

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
