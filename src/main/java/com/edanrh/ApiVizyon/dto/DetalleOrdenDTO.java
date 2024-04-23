package com.edanrh.ApiVizyon.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DetalleOrdenDTO {
    private String empleado;
    private String cliente;
    private Date fecha;
    private String prenda;
    private String cantidadProducir;
    private String cantidadProducida;
    private String estado;
}
