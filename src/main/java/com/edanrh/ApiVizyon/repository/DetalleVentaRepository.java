package com.edanrh.ApiVizyon.repository;

import com.edanrh.ApiVizyon.repository.entities.DetalleVenta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DetalleVentaRepository extends CrudRepository<DetalleVenta, Long> {

    @Query("SELECT dv FROM DetalleVenta dv WHERE dv.venta.id = ?1")
    List<DetalleVenta> findAllByVentaId(Long id);

    @Query("SELECT SUM(dv.cantidad) FROM DetalleVenta dv WHERE dv.producto.id = ?1")
    int countByProductoId(Long id);

}
