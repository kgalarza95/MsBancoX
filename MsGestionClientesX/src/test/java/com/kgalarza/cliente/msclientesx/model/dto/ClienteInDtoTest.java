package com.kgalarza.cliente.msclientesx.model.dto;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author usuario
 */
public class ClienteInDtoTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

//    @Test
//    public void testNombreNoPuedeEstarVacio() {
//        ClienteInDto clienteDto = new ClienteInDto();
//        clienteDto.setNombreCliente(""); // Nombre vacío
//
//        Set<ConstraintViolation<ClienteInDto>> violations = validator.validate(clienteDto);
//        assertThat(violations).isNotEmpty();
//
//        // Verificar si hay una violación en la propiedad "nombreCliente"
//        ConstraintViolation<ClienteInDto> violation = violations.iterator().next();
//        assertThat(violation.getPropertyPath().toString()).isEqualTo("nombreCliente");
//        assertThat(violation.getMessage()).isEqualTo("El nombre no puede estar vacío");
//    }

//    @Test
//    public void testEdadNoPuedeSerNegativa() {
//        ClienteInDto clienteDto = new ClienteInDto();
//        clienteDto.setEdadCliente(-1); // Edad negativa
//
//        Set<ConstraintViolation<ClienteInDto>> violations = validator.validate(clienteDto);
//        assertThat(violations).isNotEmpty();
//
//        // Verificar si hay una violación en la propiedad "edadCliente"
//        ConstraintViolation<ClienteInDto> violation = violations.iterator().next();
//        assertThat(violation.getPropertyPath().toString()).isEqualTo("edadCliente");
//        assertThat(violation.getMessage()).isEqualTo("La edad no puede ser negativa");
//    }

//    @Test
//    public void testIdentificacionDebeSerValida() {
//        ClienteInDto clienteDto = new ClienteInDto();
//        clienteDto.setIdentificacionCliente("1234"); // Identificación inválida (menos de 10 dígitos)
//
//        Set<ConstraintViolation<ClienteInDto>> violations = validator.validate(clienteDto);
//        assertThat(violations).isNotEmpty();
//
//        // Verificar si hay una violación en la propiedad "identificacionCliente"
//        ConstraintViolation<ClienteInDto> violation = violations.iterator().next();
//        assertThat(violation.getPropertyPath().toString()).isEqualTo("identificacionCliente");
//        assertThat(violation.getMessage()).isEqualTo("La identificación debe ser numérica y tener entre 10 y 13 dígitos");
//    }

//    @Test
//    public void testTelefonoInvalido() {
//        ClienteInDto clienteDto = new ClienteInDto();
//        clienteDto.setTelefonoCliente("123"); // Número de teléfono inválido
//
//        Set<ConstraintViolation<ClienteInDto>> violations = validator.validate(clienteDto);
//        assertThat(violations).isNotEmpty();
//
//        // Verificar si hay una violación en la propiedad "telefonoCliente"
//        ConstraintViolation<ClienteInDto> violation = violations.iterator().next();
//        assertThat(violation.getPropertyPath().toString()).isEqualTo("telefonoCliente");
//        assertThat(violation.getMessage()).isEqualTo("El teléfono debe ser un número válido y tener entre 10 y 15 dígitos");
//    }

//    @Test
//    public void testContrasenaNoPuedeSerVacia() {
//        ClienteInDto clienteDto = new ClienteInDto();
//        clienteDto.setContrasenaCliente(""); // Contraseña vacía
//
//        Set<ConstraintViolation<ClienteInDto>> violations = validator.validate(clienteDto);
//        assertThat(violations).isNotEmpty();
//
//        // Verificar si hay una violación en la propiedad "contrasenaCliente"
//        ConstraintViolation<ClienteInDto> violation = violations.iterator().next();
//        assertThat(violation.getPropertyPath().toString()).isEqualTo("contrasenaCliente");
//        assertThat(violation.getMessage()).isEqualTo("La contraseña no puede estar vacía");
//    }
}
