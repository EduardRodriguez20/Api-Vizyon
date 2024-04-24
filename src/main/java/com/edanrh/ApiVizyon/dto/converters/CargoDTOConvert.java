package com.edanrh.ApiVizyon.dto.converters;

import com.edanrh.ApiVizyon.dto.CargoCantidadDTO;
import com.edanrh.ApiVizyon.dto.CargoDTO;
import com.edanrh.ApiVizyon.repository.entities.Cargo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CargoDTOConvert {

    private ModelMapper modelMapper;

    public CargoDTO toDTO(Cargo cargo) {
        return modelMapper.map(cargo, CargoDTO.class);
    }

    public CargoCantidadDTO toCantidadDTO(Cargo cargo, int cantidad) {
        CargoCantidadDTO dto = modelMapper.map(cargo, CargoCantidadDTO.class);
        dto.setCantidadEmpleados(cantidad);
        return dto;
    }

}
