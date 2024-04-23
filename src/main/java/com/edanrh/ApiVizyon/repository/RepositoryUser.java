package com.edanrh.ApiVizyon.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.edanrh.ApiVizyon.repository.entities.UserEntity;

public interface RepositoryUser extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);
    Optional<UserEntity> deleteByEmail(String email);
    
}
