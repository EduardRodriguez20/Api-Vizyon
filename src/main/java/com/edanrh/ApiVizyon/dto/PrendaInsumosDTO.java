package com.edanrh.ApiVizyon.dto;

import lombok.Data;

import java.util.List;

@Data
public class PrendaInsumosDTO {
    private String prenda;
    private List<InsumoCantidadDTO> insumos;
}
