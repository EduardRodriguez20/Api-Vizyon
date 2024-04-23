package com.edanrh.ApiVizyon.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class VentaDTO {
    private Date fecha;
    private String empleado;
    private String cliente;
    private String idCliente;
    private String formaPago;
    private List<DetalleVentaDTO> items = new ArrayList<>();
}
