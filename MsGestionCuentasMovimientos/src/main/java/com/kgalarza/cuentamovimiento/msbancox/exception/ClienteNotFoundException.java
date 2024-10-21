package com.kgalarza.cuentamovimiento.msbancox.exception;

/**
 *
 * @author kgalarza
 */
public class ClienteNotFoundException extends RuntimeException {

    private String mensajeErrorDefecto = "Recurso no econtrado";

    public ClienteNotFoundException() {
        super("Recurso no econtrado");
    }

    public ClienteNotFoundException(Long id) {
        super("Cliente no encontrado: "+id);
    }

    public ClienteNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClienteNotFoundException(Throwable causa) {
        super(causa);
    }

    public String getMensajeErrorDefecto() {
        return mensajeErrorDefecto;
    }

    public void setMensajeErrorDefecto(String mensajeErrorDefecto) {
        this.mensajeErrorDefecto = mensajeErrorDefecto;
    }

}
