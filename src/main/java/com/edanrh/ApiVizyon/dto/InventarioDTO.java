package com.edanrh.ApiVizyon.dto;

import lombok.Data;

@Data
public class InventarioDTO {
    private String codigoInventario;
    private String prenda;
    private String talla;
    private String color;
    private double valorVtaCop;
    private double valorVtaUsd;
}
