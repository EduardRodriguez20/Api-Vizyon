package com.edanrh.ApiVizyon.repository;

import com.edanrh.ApiVizyon.repository.entities.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

    @Query("SELECT COUNT(c.tipoPersona.id) FROM Cliente c GROUP BY c.tipoPersona.id HAVING c.tipoPersona.id = ?1")
    Integer countByTipoPersonaId(Long id);
    
}
