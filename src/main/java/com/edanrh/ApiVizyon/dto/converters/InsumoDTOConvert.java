package com.edanrh.ApiVizyon.dto.converters;

import com.edanrh.ApiVizyon.dto.InsumoCantidadDTO;
import com.edanrh.ApiVizyon.dto.InsumoDTO;
import com.edanrh.ApiVizyon.dto.InsumoPrendasDTO;
import com.edanrh.ApiVizyon.repository.entities.Insumo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InsumoDTOConvert {

    private ModelMapper modelMapper;

    public InsumoDTO toProveedorDTO(Insumo insumo) {
        return modelMapper.map(insumo, InsumoDTO.class);
    }

    public InsumoCantidadDTO toCantidadDTO(Insumo insumo) {
        return modelMapper.map(insumo, InsumoCantidadDTO.class);
    }

    public InsumoPrendasDTO toPrendasDTO(Insumo insumo, int cantidad) {
        InsumoPrendasDTO dto = modelMapper.map(insumo, InsumoPrendasDTO.class);
        dto.setCantidadPrendas(cantidad);
        return dto;
    }
}
