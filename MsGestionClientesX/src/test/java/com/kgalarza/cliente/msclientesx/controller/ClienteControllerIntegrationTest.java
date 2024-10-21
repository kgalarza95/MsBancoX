package com.kgalarza.cliente.msclientesx.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kgalarza.cliente.msclientesx.model.dto.ClienteInDto;
import com.kgalarza.cliente.msclientesx.model.dto.ClienteInOutDto;
import com.kgalarza.cliente.msclientesx.service.ClienteService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author usuario
 */
@SpringBootTest
@AutoConfigureMockMvc
public class ClienteControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ClienteService clienteService;
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
    }

    @Test
    @Rollback(false)
    void testCrearCliente() throws Exception {
        ClienteInDto nuevoCliente = new ClienteInDto();
        nuevoCliente.setNombreCliente("Carlos López");
        nuevoCliente.setGeneroCliente("M");
        nuevoCliente.setEdadCliente(35);
        nuevoCliente.setIdentificacionCliente("0987654321");
        nuevoCliente.setDireccionCliente("Av. Siempre Viva 123");
        nuevoCliente.setTelefonoCliente("0998765432");
        nuevoCliente.setContrasenaCliente("securePass");
        nuevoCliente.setEstadoCliente(true);

        String nuevoClienteJson = objectMapper.writeValueAsString(nuevoCliente);

        mockMvc.perform(post("/v1/clientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(nuevoClienteJson))
                .andExpect(status().isCreated());
    }
}
