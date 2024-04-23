package com.edanrh.ApiVizyon.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.edanrh.ApiVizyon.common.ErrorCode;
import com.edanrh.ApiVizyon.common.ValidateEmail;
import com.edanrh.ApiVizyon.dto.UserDTO;
import com.edanrh.ApiVizyon.dto.converters.UserDTOConvert;
import com.edanrh.ApiVizyon.exceptions.BussinesRuleException;
import com.edanrh.ApiVizyon.exceptions.ContentNullException;
import com.edanrh.ApiVizyon.exceptions.DuplicateCreationException;
import com.edanrh.ApiVizyon.exceptions.NotFoundException;
import com.edanrh.ApiVizyon.repository.RepositoryUser;
import com.edanrh.ApiVizyon.repository.entities.UserEntity;
import com.edanrh.ApiVizyon.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private RepositoryUser repositoryUser;
    private UserDTOConvert dtoConvert;

    @Override
    public UserDTO save(UserDTO user) throws DuplicateCreationException, BussinesRuleException {
        Optional<UserEntity> existing = repositoryUser.findByEmail(user.getUsername());
        if (existing.isPresent()) {
            throw new DuplicateCreationException(ErrorCode.USER_DUPLICATE_CREATION, "User already exists", HttpStatus.CONFLICT);
        }else{
            if (!ValidateEmail.validateEmail(user.getUsername())){
                throw new BussinesRuleException(ErrorCode.EMAIL_VALIDATION, "Email isn't valid", HttpStatus.CONFLICT);
            }else {
                UserEntity entity = dtoConvert.toEntity(user);
                return dtoConvert.toDTO(repositoryUser.save(entity));
            }
        }
    }

    @Override
    public UserDTO findByEmail(String email) throws NotFoundException {
        Optional<UserEntity> existing = repositoryUser.findByEmail(email);
        if (existing.isPresent()) {
            return dtoConvert.toDTO(existing.get());
        }else{
            throw new NotFoundException(ErrorCode.USER_EMAIL_NOT_FOUND, "User not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<UserDTO> findAll() throws ContentNullException {
        List<UserEntity> users = (List<UserEntity>) repositoryUser.findAll();
        if (users.isEmpty()){
            throw new ContentNullException(ErrorCode.USER_CONTENT_NOT_FOUND, "There isn't users", HttpStatus.NO_CONTENT);
        }else {
            List<UserDTO> resultDto = new ArrayList<>();
            for (UserEntity user : users) {
                resultDto.add(dtoConvert.toDTO(user));
            }
            return resultDto;
        }
    }

    @Override
    public void edit(String email, UserDTO user) throws NotFoundException {
        Optional<UserEntity> existing = repositoryUser.findByEmail(email);
        if (existing.isEmpty()){
            throw new NotFoundException(ErrorCode.USER_EMAIL_NOT_FOUND, "User not found", HttpStatus.NOT_FOUND);
        }else{
            UserEntity entity = existing.get();
            entity.setPassword(user.getPassword());
            repositoryUser.save(entity);
        }
    }

    @Override
    public void deleteByEmail(String email) throws NotFoundException {
        Optional<UserEntity> existing = repositoryUser.deleteByEmail(email);
        if (existing.isEmpty()){
            throw new NotFoundException(ErrorCode.USER_EMAIL_NOT_FOUND, "User not found", HttpStatus.NOT_FOUND);
        }else {
            repositoryUser.delete(existing.get());
        }
    }


}
