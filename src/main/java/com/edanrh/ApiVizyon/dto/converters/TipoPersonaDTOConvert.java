package com.edanrh.ApiVizyon.dto.converters;

import com.edanrh.ApiVizyon.dto.TipoPersonaDTO;
import com.edanrh.ApiVizyon.repository.entities.TipoPersona;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TipoPersonaDTOConvert {

    private ModelMapper modelMapper;

    public TipoPersonaDTO toDTO(TipoPersona tipoPersona, int cantidad) {
        TipoPersonaDTO dto = modelMapper.map(tipoPersona, TipoPersonaDTO.class);
        dto.setCantidadPersonas(cantidad);
        return dto;
    }
}
