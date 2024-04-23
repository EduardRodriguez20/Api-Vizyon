package com.edanrh.ApiVizyon.dto.converters;

import com.edanrh.ApiVizyon.dto.UserDTO;
import com.edanrh.ApiVizyon.repository.entities.UserEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserDTOConvert {
    private ModelMapper modelMapper;

    public UserDTO toDTO(UserEntity user) {
        UserDTO dto = modelMapper.map(user, UserDTO.class);
        dto.setUsername(user.getEmail());
        return dto;
    }

    public UserEntity toEntity(UserDTO userDTO) {
        UserEntity user = modelMapper.map(userDTO, UserEntity.class);
        user.setEmail(userDTO.getUsername());
        return user;
    }
}
