package com.edanrh.ApiVizyon.dto.converters;

import com.edanrh.ApiVizyon.dto.EstadoOrdenDTO;
import com.edanrh.ApiVizyon.dto.EstadoPrendaDTO;
import com.edanrh.ApiVizyon.repository.entities.Estado;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EstadoDTOConvert {

    private ModelMapper modelMapper;

    public EstadoPrendaDTO toPrendaDTO(Estado estado, int cantidad) {
        EstadoPrendaDTO dto = modelMapper.map(estado, EstadoPrendaDTO.class);
        dto.setCantidadPrendas(cantidad);
        return dto;
    }

    public EstadoOrdenDTO toOrdenDTO(Estado estado, int cantidad) {
        EstadoOrdenDTO dto = modelMapper.map(estado, EstadoOrdenDTO.class);
        dto.setCantidadOrdenes(cantidad);
        return dto;
    }
}
