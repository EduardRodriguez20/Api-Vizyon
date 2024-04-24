package com.edanrh.ApiVizyon.repository;

import com.edanrh.ApiVizyon.repository.entities.Cargo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CargoRepository extends CrudRepository<Cargo, Long> {
    List<Cargo> findBySueldoBaseGreaterThan(double sueldoBase);
}
