package com.edanrh.ApiVizyon.dto.converters;

import com.edanrh.ApiVizyon.dto.InventarioDTO;
import com.edanrh.ApiVizyon.repository.entities.Inventario;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InventarioDTOConvert {

    private ModelMapper modelMapper;

    public InventarioDTO toDTO(Inventario inventario) {
        InventarioDTO dto = modelMapper.map(inventario, InventarioDTO.class);
        dto.setCodigoInventario(inventario.getCodInv());
        dto.setPrenda(inventario.getPrenda().getNombre());
        return dto;
    }
}
