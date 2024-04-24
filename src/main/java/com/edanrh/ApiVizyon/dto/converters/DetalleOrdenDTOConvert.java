package com.edanrh.ApiVizyon.dto.converters;

import com.edanrh.ApiVizyon.dto.DetalleOrdenDTO;
import com.edanrh.ApiVizyon.dto.DetalleOrdenStockDTO;
import com.edanrh.ApiVizyon.dto.OrdenDTO;
import com.edanrh.ApiVizyon.repository.entities.DetalleOrden;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DetalleOrdenDTOConvert {

    private ModelMapper modelMapper;

    public DetalleOrdenDTO toDTO(DetalleOrden detalleOrden, OrdenDTO ordenDTO) {
        DetalleOrdenDTO dto = modelMapper.map(detalleOrden, DetalleOrdenDTO.class);
        dto.setEmpleado(ordenDTO.getEmpleado());
        dto.setCliente(ordenDTO.getCliente());
        dto.setFecha(ordenDTO.getFecha());
        dto.setPrenda(detalleOrden.getPrenda().getNombre());
        dto.setEstado(detalleOrden.getEstado().getDescripcion());
        return dto;
    }

    public DetalleOrdenStockDTO toStockDTO(DetalleOrden detalleOrden) {
        DetalleOrdenStockDTO dto = modelMapper.map(detalleOrden, DetalleOrdenStockDTO.class);
        dto.setPrenda(detalleOrden.getPrenda().getNombre());
        return dto;
    }
}
