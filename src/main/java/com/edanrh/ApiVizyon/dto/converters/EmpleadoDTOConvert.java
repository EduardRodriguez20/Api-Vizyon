package com.edanrh.ApiVizyon.dto.converters;

import com.edanrh.ApiVizyon.dto.EmpleadoDTO;
import com.edanrh.ApiVizyon.dto.EmpleadoVentasDTO;
import com.edanrh.ApiVizyon.repository.entities.Empleado;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EmpleadoDTOConvert {

    private ModelMapper modelMapper;

    public EmpleadoDTO toDTO(Empleado empleado) {
        EmpleadoDTO dto = modelMapper.map(empleado, EmpleadoDTO.class);
        dto.setCargo(empleado.getCargo().getDescripcion());
        dto.setMunicipio(empleado.getMunicipio().getNombre());
        dto.calculateAñosEmpleado();
        return dto;
    }

    public EmpleadoVentasDTO toVentasDTO(Empleado empleado, int cantidad){
        EmpleadoVentasDTO dto = modelMapper.map(empleado, EmpleadoVentasDTO.class);
        dto.setVentas(cantidad);
        return dto;
    }
}
