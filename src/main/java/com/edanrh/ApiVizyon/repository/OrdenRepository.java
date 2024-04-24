package com.edanrh.ApiVizyon.repository;

import com.edanrh.ApiVizyon.repository.entities.Orden;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrdenRepository extends CrudRepository<Orden, Long> {

    @Query("SELECT o FROM Orden o WHERE o.estado.descripcion = 'En proceso'")
    List<Orden> findAllInProceso();

    @Query("SELECT COUNT(o.estado.id) FROM Orden o GROUP BY o.estado.id HAVING o.estado.id = ?1")
    Integer countByEstadoId(Long estadoId);
}
