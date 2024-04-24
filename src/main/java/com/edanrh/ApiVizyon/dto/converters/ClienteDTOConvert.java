package com.edanrh.ApiVizyon.dto.converters;

import com.edanrh.ApiVizyon.dto.ClienteDTO;
import com.edanrh.ApiVizyon.dto.ClientePaisDTO;
import com.edanrh.ApiVizyon.dto.ClienteTotalDTO;
import com.edanrh.ApiVizyon.repository.entities.Cliente;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ClienteDTOConvert {

    private ModelMapper modelMapper;

    public ClienteDTO toDTO(Cliente entity) {
        ClienteDTO dto = modelMapper.map(entity, ClienteDTO.class);
        dto.setMunicipio(entity.getMunicipio().getNombre());
        return dto;
    }

    public ClientePaisDTO toPaisDTO(Cliente entity, String pais) {
        ClientePaisDTO dto = modelMapper.map(entity, ClientePaisDTO.class);
        dto.setMunicipio(entity.getMunicipio().getNombre());
        dto.setPais(pais);
        return dto;
    }

    public ClienteTotalDTO toTotalDTO(Cliente entity, double total) {
        ClienteTotalDTO dto = modelMapper.map(entity, ClienteTotalDTO.class);
        dto.setTotalCompras(total);
        return dto;
    }
}
