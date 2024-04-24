package com.edanrh.ApiVizyon.repository;

import com.edanrh.ApiVizyon.repository.entities.Prenda;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PrendaRepository extends CrudRepository<Prenda, Long> {

    @Query("SELECT COUNT(p.tipoProteccion.id) FROM Prenda p GROUP BY p.tipoProteccion.id HAVING p.tipoProteccion.id = ?1")
    Integer countByTipoProteccionId(Long id);

    @Query("SELECT COUNT(p.estado.id) FROM Prenda p GROUP BY p.estado.id HAVING p.estado.id = ?1")
    Integer countByEstadoId(Long id);
}
