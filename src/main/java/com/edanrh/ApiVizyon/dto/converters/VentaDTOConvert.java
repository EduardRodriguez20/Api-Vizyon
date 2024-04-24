package com.edanrh.ApiVizyon.dto.converters;

import com.edanrh.ApiVizyon.dto.VentaDTO;
import com.edanrh.ApiVizyon.repository.entities.Venta;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class VentaDTOConvert {
    private ModelMapper modelMapper;

    public VentaDTO toDTO(Venta venta) {
        VentaDTO dto = modelMapper.map(venta, VentaDTO.class);
        dto.setEmpleado(venta.getEmpleado().getNombre());
        dto.setCliente(venta.getCliente().getNombre());
        dto.setIdCliente(venta.getCliente().getIdCliente());
        dto.setFormaPago(venta.getFormaPago().getDescripcion());
        return dto;
    }
}
