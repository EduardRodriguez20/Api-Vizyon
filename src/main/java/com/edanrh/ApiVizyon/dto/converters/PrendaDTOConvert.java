package com.edanrh.ApiVizyon.dto.converters;

import com.edanrh.ApiVizyon.dto.PrendaInsumosDTO;
import com.edanrh.ApiVizyon.dto.PrendaTotalCopDTO;
import com.edanrh.ApiVizyon.dto.PrendaTotalUsdDTO;
import com.edanrh.ApiVizyon.dto.PrendaUsdDTO;
import com.edanrh.ApiVizyon.repository.entities.Prenda;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PrendaDTOConvert {

    private ModelMapper modelMapper;

    public PrendaTotalUsdDTO toTotalDTO(Prenda prenda, double total) {
        PrendaTotalUsdDTO dto = new PrendaTotalUsdDTO();
        dto.setPrenda(prenda.getNombre());
        dto.setValorTotalUsd(total);
        return dto;
    }

    public PrendaInsumosDTO toInsumosDTO(Prenda prenda){
        PrendaInsumosDTO dto = new PrendaInsumosDTO();
        dto.setPrenda(prenda.getNombre());
        return dto;
    }

    public PrendaUsdDTO toUsdDTO(Prenda prenda){
        PrendaUsdDTO dto = modelMapper.map(prenda, PrendaUsdDTO.class);
        dto.setPrenda(prenda.getNombre());
        dto.setEstado(prenda.getEstado().getDescripcion());
        return dto;
    }

    public PrendaTotalCopDTO toTotalCopDTO(Prenda prenda, double total){
        PrendaTotalCopDTO dto = new PrendaTotalCopDTO();
        dto.setPrenda(prenda.getNombre());
        dto.setTotalVentasCOP(total);
        return dto;
    }
}
