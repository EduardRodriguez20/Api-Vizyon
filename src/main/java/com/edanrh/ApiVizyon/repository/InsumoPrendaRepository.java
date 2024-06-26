package com.edanrh.ApiVizyon.repository;

import com.edanrh.ApiVizyon.repository.entities.InsumoPrenda;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface InsumoPrendaRepository extends CrudRepository<InsumoPrenda, Long> {

    @Query("SELECT ip FROM InsumoPrenda ip WHERE ip.prenda.id = ?1")
    List<InsumoPrenda> findAllByPrendaId(Long id);

    @Query("SELECT COUNT(i.insumo.id) FROM InsumoPrenda i GROUP BY i.insumo.id HAVING i.insumo.id = ?1")
    Integer countByInsumoId(Long id);
}
