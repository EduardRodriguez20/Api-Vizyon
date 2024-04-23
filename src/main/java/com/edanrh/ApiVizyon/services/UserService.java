package com.edanrh.ApiVizyon.services;

import java.util.List;

import com.edanrh.ApiVizyon.dto.UserDTO;
import com.edanrh.ApiVizyon.exceptions.BussinesRuleException;
import com.edanrh.ApiVizyon.exceptions.ContentNullException;
import com.edanrh.ApiVizyon.exceptions.DuplicateCreationException;
import com.edanrh.ApiVizyon.exceptions.NotFoundException;

public interface UserService {
    UserDTO save(UserDTO user) throws DuplicateCreationException, BussinesRuleException;
    UserDTO findByEmail(String email) throws NotFoundException;
    List<UserDTO> findAll() throws ContentNullException;
    void edit(String email, UserDTO user) throws NotFoundException;
    void deleteByEmail(String email) throws NotFoundException;
}

