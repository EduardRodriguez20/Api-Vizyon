package com.edanrh.ApiVizyon.dto.converters;

import com.edanrh.ApiVizyon.dto.TipoProteccionDTO;
import com.edanrh.ApiVizyon.repository.entities.TipoProteccion;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TipoProteccionDTOConvert {

    private ModelMapper modelMapper;

    public TipoProteccionDTO toDTO(TipoProteccion tipoProteccion) {
        TipoProteccionDTO dto = modelMapper.map(tipoProteccion, TipoProteccionDTO.class);
        return dto;
    }
}
