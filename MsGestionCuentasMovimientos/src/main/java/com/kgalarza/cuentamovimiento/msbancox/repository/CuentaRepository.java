package com.kgalarza.cuentamovimiento.msbancox.repository;

import com.kgalarza.cuentamovimiento.msbancox.model.entity.Cuenta;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kgalarza
 */
@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {

    Optional<Cuenta> findByNumeroCuenta(String numeroCuenta);

    boolean existsByNumeroCuenta(String numeroCuenta);

}
