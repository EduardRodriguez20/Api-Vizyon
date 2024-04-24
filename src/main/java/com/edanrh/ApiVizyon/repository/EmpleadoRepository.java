package com.edanrh.ApiVizyon.repository;

import com.edanrh.ApiVizyon.repository.entities.Empleado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {

    List<Empleado> findByOrderByFechaIngresoDesc();

    @Query("SELECT COUNT(e.cargo.id) FROM Empleado e GROUP BY e.cargo.id HAVING e.cargo.id = ?1")
    Integer countByCargoId(Long cargoId);

}
