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
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String idCliente;
    @ManyToOne
    @JoinColumn(name = "IdTipoPersonaFk")
    private TipoPersona tipoPersona;
    private Date fechaRegistro;
    @ManyToOne
    @JoinColumn(name = "IdMunicipioFk")
    private Municipio municipio;
}
