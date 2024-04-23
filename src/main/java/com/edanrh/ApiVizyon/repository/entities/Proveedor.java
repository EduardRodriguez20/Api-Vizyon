package com.edanrh.ApiVizyon.repository.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String NitProveedor;
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "IdTipoPersona")
    private TipoPersona tipoPersona;
    @ManyToOne
    @JoinColumn(name = "IdMunicipioFk")
    private Municipio municipio;
}
