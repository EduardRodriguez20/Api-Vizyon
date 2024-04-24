package com.edanrh.ApiVizyon.repository;

import com.edanrh.ApiVizyon.repository.entities.Proveedor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProveedorRepository extends CrudRepository<Proveedor, Long> {

    @Query("SELECT COUNT(p.tipoPersona.id) FROM Proveedor p GROUP BY p.tipoPersona.id HAVING p.tipoPersona.id = ?1")
    Integer countByTipoPersonaId(Long id);
}
