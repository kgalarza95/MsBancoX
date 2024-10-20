package com.kgalarza.cliente.msclientesx.service.impl;

import com.kgalarza.cliente.msclientesx.service.*;
import com.kgalarza.cliente.msclientesx.exception.ResourceNotFoundException;
import com.kgalarza.cliente.msclientesx.mapper.ClienteMapper;
import com.kgalarza.cliente.msclientesx.model.dto.ClienteInDto;
import com.kgalarza.cliente.msclientesx.model.dto.ClienteInOutDto;
import com.kgalarza.cliente.msclientesx.model.entity.Cliente;
import com.kgalarza.cliente.msclientesx.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kgalarza
 */
@Service
public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    public List<ClienteInOutDto> getAllClientes() {
//        List<Cliente> clientes = clienteRepository.findAll();
//        if (clientes.isEmpty()) {
//            throw new ResourceNotFoundException("No hay registros para mostrar");
//        }
//        return clientes.stream()
//                .map(cliente -> modelMapper.map(cliente, ClienteInOutDto.class))
//                .collect(Collectors.toList());

        List<Cliente> clientes = clienteRepository.findAll();
        return clienteMapper.toDtoList(clientes);
    }

    public ClienteInOutDto getClienteById(Long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con id: " + clienteId));
        return clienteMapper.toDto(cliente);
    }

    public ClienteInOutDto createCliente(ClienteInDto clienteDto) {
        System.out.println("cliente services  " + clienteDto.toString());
        Cliente cliente = clienteMapper.toEntity(clienteDto);
        System.out.println("cliente in: " + cliente);
        cliente = clienteRepository.save(cliente);
        System.out.println("cliente out: " + cliente);

        return clienteMapper.toDto(cliente);
    }

    public ClienteInOutDto updateCliente(Long clienteid, ClienteInDto clienteDto) {
        Cliente existingCliente = clienteRepository.findByClienteid(clienteid);
        if (existingCliente != null) {
            Cliente clienteActualizar = clienteMapper.toEntity(clienteDto);
            Cliente clienteResp = clienteRepository.save(clienteActualizar);
            return clienteMapper.toDto(clienteResp);
        } else {
            throw new ResourceNotFoundException();
        }
    }

    @Transactional
    public ClienteInOutDto updateCliente(ClienteInDto clienteDto) {
        clienteRepository.findById(clienteDto.getClienteidCliente())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con id: " + clienteDto.getClienteidCliente()));
        Cliente clienteActualizar = clienteMapper.toEntity(clienteDto);
        Cliente clienteResp = clienteRepository.save(clienteActualizar);
        return clienteMapper.toDto(clienteResp);
    }

    public void deleteCliente(Long clienteid) {
        clienteRepository.findById(clienteid)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con id: " + clienteid));

        clienteRepository.deleteById(clienteid);
    }

}
