package com.edanrh.ApiVizyon.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class OrdenDTO {
    private Date fecha;
    private String empleado;
    private String cliente;
    private String estado;
    private List<DetalleOrdenDTO> items = new ArrayList<>();

    public void addItem(DetalleOrdenDTO item){
        items.add(item);
    }
}
