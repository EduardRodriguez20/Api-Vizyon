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
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fecha;
    @ManyToOne
    @JoinColumn(name = "IdEmpleadoFk")
    private Empleado empleado;
    @ManyToOne
    @JoinColumn(name = "IdClienteFk")
    private Cliente cliente;
    @OneToOne
    @JoinColumn(name = "IdEstadoFk")
    private Estado estado;
}
