package com.edanrh.ApiVizyon.repository;

import com.edanrh.ApiVizyon.repository.entities.Inventario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface InventarioRepository extends CrudRepository<Inventario, Long> {

    @Query("SELECT i FROM Inventario i WHERE i.prenda.id = ?1")
    Optional<Inventario> findFirstByPrendaId(Long id);
}
