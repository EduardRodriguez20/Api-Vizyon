package com.edanrh.ApiVizyon.dto;

import lombok.Data;

import java.util.Calendar;
import java.util.Date;

@Data
public class EmpleadoDTO {
    private String nombre;
    private String cargo;
    private Date fechaIngreso;
    private int añosEmpleado;
    private String municipio;

    public void calculateAñosEmpleado(){
        Calendar c1 = Calendar.getInstance();
        c1.setTime(this.fechaIngreso);
        Calendar c2 = Calendar.getInstance();
        c2.setTime(new Date());
        int diff = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
        if (diff <= 0){
            diff = 0;
        }else if (c2.get(Calendar.DAY_OF_YEAR) < c1.get(Calendar.DAY_OF_YEAR)){
            diff--;
        }
        this.añosEmpleado = diff;
    }
}
