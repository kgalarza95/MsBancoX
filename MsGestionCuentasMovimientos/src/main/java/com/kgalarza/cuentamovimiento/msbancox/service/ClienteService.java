
package com.kgalarza.cuentamovimiento.msbancox.service;

import com.kgalarza.cuentamovimiento.msbancox.model.dto.ClienteInOutDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 *
 * @author usuario
 */
@Service
public interface ClienteService {
    Mono<ClienteInOutDto> getClienteById(Long clienteId);
}
