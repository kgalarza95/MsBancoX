/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kgalarza.cuentamovimiento.msbancox.exception;

import com.kgalarza.cuentamovimiento.msbancox.model.dto.RespuestaOutDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 * @author usuario
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ClienteNotFoundException.class)
    public ResponseEntity<RespuestaOutDto> ClienteNotFoundException(RegistroDuplicadoException ex) {
        logger.warn("Cliente no encontrado", ex.getMessage());
        HttpStatus estado = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(new RespuestaOutDto(estado, ex.getMessage(), ex.getMessage()), estado);
    }

    @ExceptionHandler(RegistroDuplicadoException.class)
    public ResponseEntity<RespuestaOutDto> RegistroDuplicadoExceptionHandler(RegistroDuplicadoException ex) {
        logger.warn("Intento de registrar un duplicado", ex.getMessage());
        HttpStatus estado = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(new RespuestaOutDto(estado, ex.getMessage(), ex.getMessage()), estado);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RespuestaOutDto> globalExceptionHandler(Exception ex) {
        String mensajeUsuario = "Lo sentimos, ha ocurrido un error inesperado. Por favor, intenta nuevamente más tarde.";
        logger.error("Error inesperado: {}", ex.getMessage(), ex);
        return new ResponseEntity<>(new RespuestaOutDto(HttpStatus.INTERNAL_SERVER_ERROR, mensajeUsuario, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
