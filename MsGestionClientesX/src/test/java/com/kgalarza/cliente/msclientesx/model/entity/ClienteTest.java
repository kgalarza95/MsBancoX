package com.kgalarza.cliente.msclientesx.model.entity;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

/**
 *
 * @author usuario
 */
public class ClienteTest {

    @Test
    public void testClienteEntity() {
        Cliente cliente = new Cliente();

        cliente.setClienteid(1L);
        cliente.setNombre("Carlos López");
        cliente.setGenero("M");
        cliente.setEdad(35);
        cliente.setIdentificacion("0987654324");
        cliente.setDireccion("Av. Siempre Viva 123");
        cliente.setTelefono("0998765432");
        cliente.setContrasena("securePass");
        cliente.setEstado(true);

        assertThat(cliente.getClienteid()).isEqualTo(1L);
        assertThat(cliente.getNombre()).isEqualTo("Carlos López");
        assertThat(cliente.getGenero()).isEqualTo("M");
        assertThat(cliente.getEdad()).isEqualTo(35);
        assertThat(cliente.getIdentificacion()).isEqualTo("0987654324");
        assertThat(cliente.getDireccion()).isEqualTo("Av. Siempre Viva 123");
        assertThat(cliente.getTelefono()).isEqualTo("0998765432");
        assertThat(cliente.getContrasena()).isEqualTo("securePass");
        assertThat(cliente.isEstado()).isTrue();
    }
}
