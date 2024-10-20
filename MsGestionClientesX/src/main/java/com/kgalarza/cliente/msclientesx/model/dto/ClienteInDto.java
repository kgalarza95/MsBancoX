package com.kgalarza.cliente.msclientesx.model.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author kgalarza
 */
public class ClienteInDto {

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 100, message = "El nombre no puede tener más de 100 caracteres")
    private String nombreCliente;
    private String generoCliente;
    @Min(value = 0, message = "La edad no puede ser negativa")
    @Max(value = 80, message = "La edad no puede ser mayor de 80 años")
    private int edadCliente;
    @NotNull(message = "La identificación no puede ser nula")
    @Pattern(regexp = "^[0-9]{10,13}$", message = "La identificación debe ser numérica y tener entre 10 y 13 dígitos")
    private String identificacionCliente;
    @Size(max = 255, message = "La dirección no puede tener más de 255 caracteres")
    private String direccionCliente;
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "El teléfono debe ser un número válido y tener entre 10 y 15 dígitos")
    private String telefonoCliente;
    private Long clienteidCliente;
    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(min = 4, max = 20, message = "La contraseña debe tener entre 4 y 20 caracteres")
    private String contrasenaCliente;
    private boolean estadoCliente;

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getGeneroCliente() {
        return generoCliente;
    }

    public void setGeneroCliente(String generoCliente) {
        this.generoCliente = generoCliente;
    }

    public int getEdadCliente() {
        return edadCliente;
    }

    public void setEdadCliente(int edadCliente) {
        this.edadCliente = edadCliente;
    }

    public String getIdentificacionCliente() {
        return identificacionCliente;
    }

    public void setIdentificacionCliente(String identificacionCliente) {
        this.identificacionCliente = identificacionCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public Long getClienteidCliente() {
        return clienteidCliente;
    }

    public void setClienteidCliente(Long clienteidCliente) {
        this.clienteidCliente = clienteidCliente;
    }

    public String getContrasenaCliente() {
        return contrasenaCliente;
    }

    public void setContrasenaCliente(String contrasenaCliente) {
        this.contrasenaCliente = contrasenaCliente;
    }

    public boolean isEstadoCliente() {
        return estadoCliente;
    }

    public void setEstadoCliente(boolean estadoCliente) {
        this.estadoCliente = estadoCliente;
    }
    
    
}
