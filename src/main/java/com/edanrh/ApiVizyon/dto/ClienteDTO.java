package com.edanrh.ApiVizyon.dto;

import lombok.Data;

@Data
public class ClienteDTO {
    private String nombre;
    private String idCliente;
    private String municipio;
    private String pais;
    private int compras;
}
