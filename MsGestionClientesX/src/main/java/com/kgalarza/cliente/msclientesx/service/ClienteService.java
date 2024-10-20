package com.kgalarza.cliente.msclientesx.service;

import com.kgalarza.cliente.msclientesx.model.dto.ClienteInDto;
import com.kgalarza.cliente.msclientesx.model.dto.ClienteInOutDto;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author kgalarza
 */
@Service
public interface ClienteService {

    public List<ClienteInOutDto> getAllClientes();

    public ClienteInOutDto getClienteById(Long clienteId);

    public ClienteInOutDto createCliente(ClienteInDto clienteDto);

    public ClienteInOutDto updateCliente(Long clienteid, ClienteInDto clienteDto);

    public ClienteInOutDto updateCliente(ClienteInDto clienteDto);

    public void deleteCliente(Long clienteid);

}
