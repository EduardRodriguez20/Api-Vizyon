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
    Integer countByEmpleadoId(Long id);

    @Query("SELECT COUNT(v.cliente.id) FROM Venta v GROUP BY v.cliente.id HAVING v.cliente.id = ?1")
    Integer countByClienteId(Long id);

    @Query("SELECT COUNT(v.formaPago.id) FROM Venta v GROUP BY v.formaPago.id HAVING v.formaPago.id = ?1")
    Integer countByFormaPagoId(Long id);

    @Query("SELECT v FROM Venta v WHERE v.cliente.id = ?1")
    List<Venta> findAllByClienteId(Long id);

    @Query("SELECT v FROM Venta v WHERE v.fecha BETWEEN ?1 AND ?2")
    List<Venta> findAllBetweenDates(Date fecha1, Date fecha2);

    List<Venta> findAllByFecha(Date fecha);
}
