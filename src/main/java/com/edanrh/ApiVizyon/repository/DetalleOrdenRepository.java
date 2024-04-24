package com.edanrh.ApiVizyon.repository;

import com.edanrh.ApiVizyon.repository.entities.DetalleOrden;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DetalleOrdenRepository extends CrudRepository<DetalleOrden, Long> {

    @Query("SELECT do FROM DetalleOrden do WHERE do.prenda.id = ?1")
    List<DetalleOrden> findAllByOrdenId(Long id);

    @Query("SELECT do FROM DetalleOrden do WHERE do.orden.id = ?1")
    Optional<DetalleOrden> findFirstByPrendaId(Long id);

}
