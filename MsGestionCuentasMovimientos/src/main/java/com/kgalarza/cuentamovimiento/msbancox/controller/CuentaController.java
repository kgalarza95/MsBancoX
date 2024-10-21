package com.kgalarza.cuentamovimiento.msbancox.controller;

import com.kgalarza.cuentamovimiento.msbancox.exception.ClienteNotFoundException;
import com.kgalarza.cuentamovimiento.msbancox.exception.RegistroDuplicadoException;
import com.kgalarza.cuentamovimiento.msbancox.model.dto.CuentaInDto;
import com.kgalarza.cuentamovimiento.msbancox.model.dto.CuentaNoValidInDto;
import com.kgalarza.cuentamovimiento.msbancox.model.dto.CuentaOutDto;
import com.kgalarza.cuentamovimiento.msbancox.model.dto.RespuestaOutDto;
import com.kgalarza.cuentamovimiento.msbancox.service.CuentaService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 *
 * @author kgalarza
 */
@RestController
@RequestMapping("/v1/cuentas")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @GetMapping("/{numCuenta}")
    public ResponseEntity<?> getCuenta(@PathVariable Long numCuenta) {
        CuentaOutDto cuentaDto = cuentaService.findById(numCuenta);
        return new ResponseEntity<>(cuentaDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CuentaOutDto>> getCuentasAll() {
        List<CuentaOutDto> cuentas = cuentaService.findAllCuentas();
        return new ResponseEntity<>(cuentas, HttpStatus.OK);
    }


//    @PostMapping
//    public Mono<ResponseEntity<CuentaOutDto>> createCuenta(@RequestBody CuentaInDto cuentaDto) {
//        return cuentaService.createCuenta(cuentaDto)
//                .map(cuenta -> ResponseEntity.ok(cuenta))
//                .onErrorResume(ClienteNotFoundException.class, e
//                        -> Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null)))
//                .onErrorResume(RegistroDuplicadoException.class, e
//                        -> Mono.just(ResponseEntity.status(HttpStatus.CONFLICT).body(null)));
//    }
    @PostMapping
    public Mono<ResponseEntity<Object>> createCuenta(@RequestBody CuentaInDto cuentaDto) {
        return cuentaService.createCuenta(cuentaDto)
                .map(cuenta -> ResponseEntity.ok((Object) cuenta)) // Asegúrate de que el cuerpo pueda ser cualquier tipo de objeto
                .onErrorResume(ClienteNotFoundException.class, e -> {
                    HttpStatus status = HttpStatus.NOT_FOUND;
                    RespuestaOutDto respuesta = new RespuestaOutDto(status, "Cliente no encontrado", e.getMessage());
                    return Mono.just(ResponseEntity.status(status).body((Object) respuesta)); // Devuelve RespuestaOutDto en caso de error
                })
                .onErrorResume(RegistroDuplicadoException.class, e -> {
                    HttpStatus status = HttpStatus.CONFLICT;
                    RespuestaOutDto respuesta = new RespuestaOutDto(status, "Cuenta duplicada", e.getMessage());
                    return Mono.just(ResponseEntity.status(status).body((Object) respuesta)); // Devuelve RespuestaOutDto en caso de error
                });
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CuentaOutDto> updateParcialCuenta(@RequestBody CuentaNoValidInDto cuenta) {
        CuentaOutDto updatedCuenta = cuentaService.updateParcialCuenta(cuenta);
        return new ResponseEntity<>(updatedCuenta, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCuenta(@PathVariable Long id) {
        cuentaService.deleteCuenta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
