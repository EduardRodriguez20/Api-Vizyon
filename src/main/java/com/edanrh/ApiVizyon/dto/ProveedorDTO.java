package com.edanrh.ApiVizyon.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProveedorDTO {
    private String NitProveedor;
    private String nombre;
    private String municipio;
    private List<InsumoDTO> insumos = new ArrayList<>();
}
