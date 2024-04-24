package com.edanrh.ApiVizyon.dto.converters;

import com.edanrh.ApiVizyon.dto.DetalleVentaDTO;
import com.edanrh.ApiVizyon.repository.entities.DetalleVenta;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DetalleVentaDTOConvert {

    private ModelMapper modelMapper;

    public DetalleVentaDTO toDTO(DetalleVenta detalleVenta) {
        DetalleVentaDTO dto = modelMapper.map(detalleVenta, DetalleVentaDTO.class);
        dto.setPrenda(detalleVenta.getProducto().getPrenda().getNombre());
        dto.setTalla(detalleVenta.getTalla().getDescripcion());
        dto.setCantidad(detalleVenta.getCantidad());
        return dto;
    }
}
