package com.kgalarza.cliente.msclientesx.repository;


import com.kgalarza.cliente.msclientesx.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kgalarza
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByClienteid(Long clienteid);

}
