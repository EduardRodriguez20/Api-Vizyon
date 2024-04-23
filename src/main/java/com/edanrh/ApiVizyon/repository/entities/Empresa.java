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
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nit;
    @Column(name = "razon_social")
    private String razonSocial;
    @Column(name = "representante_legal")
    private String representateLegal;
    private Date fechaCreacion;
    @ManyToOne
    @JoinColumn(name = "idMunicipioFk")
    private Municipio municipio;
}
