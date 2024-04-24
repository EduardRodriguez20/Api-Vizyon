package com.edanrh.ApiVizyon.repository;

import com.edanrh.ApiVizyon.repository.entities.Venta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface VentaRepository extends CrudRepository<Venta, Long> {

    @Query("SELECT v FROM Venta v WHERE MONTH(v.fecha) = ?1 AND YEAR(v.fecha) = ?2")
    List<Venta> findByDates(String mes, String year);

    @Query("SELECT COUNT(v.empleado.id) FROM Venta v GROUP BY v.empleado.id HAVING v.empleado.id = ?1")
    int countByEmpleadoId(Long id);

    List<Venta> findAllByFecha(Date fecha);
}
