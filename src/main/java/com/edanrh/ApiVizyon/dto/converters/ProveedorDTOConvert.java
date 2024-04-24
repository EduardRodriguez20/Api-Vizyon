package com.edanrh.ApiVizyon.dto.converters;

import com.edanrh.ApiVizyon.dto.ProveedorDTO;
import com.edanrh.ApiVizyon.repository.entities.Proveedor;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProveedorDTOConvert {

    private ModelMapper modelMapper;

    public ProveedorDTO toDTO(Proveedor proveedor) {
        ProveedorDTO dto = modelMapper.map(proveedor, ProveedorDTO.class);
        dto.setMunicipio(proveedor.getMunicipio().getNombre());
        return dto;
    }
}
