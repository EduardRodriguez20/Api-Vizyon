package com.edanrh.ApiVizyon.repository;

import com.edanrh.ApiVizyon.repository.entities.InventarioTalla;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface InventarioTallaRepository extends CrudRepository<InventarioTalla, Long> {

    @Query("SELECT it FROM InventarioTalla it WHERE it.inventario.id = ?1")
    Optional<InventarioTalla> findFirstByInventarioId(Long inventarioId);
}
