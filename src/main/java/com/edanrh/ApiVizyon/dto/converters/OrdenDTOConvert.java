package com.edanrh.ApiVizyon.dto.converters;

import com.edanrh.ApiVizyon.dto.OrdenDTO;
import com.edanrh.ApiVizyon.repository.entities.Orden;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OrdenDTOConvert {

    private ModelMapper modelMapper;

    public OrdenDTO toDTO(Orden orden) {
        OrdenDTO dto = modelMapper.map(orden, OrdenDTO.class);
        dto.setEmpleado(orden.getEmpleado().getNombre());
        dto.setCliente(orden.getCliente().getNombre());
        dto.setEstado(orden.getEstado().getDescripcion());
        return dto;
    }
}
