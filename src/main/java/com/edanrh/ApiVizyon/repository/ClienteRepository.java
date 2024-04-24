package com.edanrh.ApiVizyon.repository;

import com.edanrh.ApiVizyon.repository.entities.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    
}
