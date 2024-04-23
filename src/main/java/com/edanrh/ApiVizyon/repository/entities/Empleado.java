package com.edanrh.ApiVizyon.repository.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "IdCargoFk")
    private Cargo cargo;
    @Column(name = "fecha_ingreso")
    private Date fechaIngreso;
    @ManyToOne
    @JoinColumn(name = "IdMunicipioFk")
    private Municipio municipio;
}
