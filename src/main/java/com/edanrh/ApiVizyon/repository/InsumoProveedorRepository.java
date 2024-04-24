package com.edanrh.ApiVizyon.repository;

import com.edanrh.ApiVizyon.repository.entities.InsumoProveedor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InsumoProveedorRepository extends CrudRepository<InsumoProveedor, Long> {

    @Query("SELECT ip FROM InsumoProveedor ip WHERE ip.proveedor.id = ?1")
    List<InsumoProveedor> findAllByProveedorId(Long id);
}
