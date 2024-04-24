package com.edanrh.ApiVizyon.dto.converters;

import com.edanrh.ApiVizyon.dto.FormaPagoDTO;
import com.edanrh.ApiVizyon.repository.entities.FormaPago;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FormaPagoDTOConvert {

    private ModelMapper modelMapper;

    public FormaPagoDTO toDTO(FormaPago formaPago, int cantidad) {
        FormaPagoDTO dto = modelMapper.map(formaPago, FormaPagoDTO.class);
        dto.setCantidadVentas(cantidad);
        return dto;
    }
}
