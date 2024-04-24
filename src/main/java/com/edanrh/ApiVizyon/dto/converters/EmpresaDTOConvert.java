package com.edanrh.ApiVizyon.dto.converters;

import com.edanrh.ApiVizyon.dto.EmpresaDTO;
import com.edanrh.ApiVizyon.repository.entities.Empresa;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EmpresaDTOConvert {

    private ModelMapper modelMapper;

    public EmpresaDTO toDTO(Empresa empresa) {
        EmpresaDTO dto = modelMapper.map(empresa, EmpresaDTO.class);
        dto.setMunicipio(empresa.getMunicipio().getNombre());
        return dto;
    }
}
