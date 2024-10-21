package com.kgalarza.cuentamovimiento.msbancox.service.impl;

import com.kgalarza.cuentamovimiento.msbancox.exception.ClienteNotFoundException;
import com.kgalarza.cuentamovimiento.msbancox.model.dto.ClienteInOutDto;
import com.kgalarza.cuentamovimiento.msbancox.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 *
 * @author usuario
 */
@Service
public class ClienteServiceImpl implements ClienteService {

    private final WebClient webClient;
    @Value("${clientes.service.uri}")
    private String clienteUri;

    @Autowired
    public ClienteServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    @Override
    public Mono<ClienteInOutDto> getClienteById(Long clienteId) {
        return webClient
                .get()
                .uri(clienteUri + "/" + clienteId)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, response -> {
                    if (response.statusCode().equals(HttpStatus.NOT_FOUND)) {
                        return Mono.error(new ClienteNotFoundException(clienteId));
                    }
                    return response.createException().flatMap(Mono::error);
                })
                .bodyToMono(ClienteInOutDto.class);
    }
}
