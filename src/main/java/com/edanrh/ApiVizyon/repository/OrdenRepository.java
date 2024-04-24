package com.edanrh.ApiVizyon.repository;

import com.edanrh.ApiVizyon.repository.entities.Orden;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrdenRepository extends CrudRepository<Orden, Long> {

    @Query("SELECT o FROM Orden o WHERE o.estado.descripcion = 'En proceso'")
    List<Orden> findAllInProceso();
}
