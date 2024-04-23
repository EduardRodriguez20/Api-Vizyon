package com.edanrh.ApiVizyon.repository.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private double valorUnitCop;
    private double valorUnitUsd;
    @ManyToOne
    @JoinColumn(name = "IdEstadoFk")
    private Estado estado;
    @ManyToOne
    @JoinColumn(name = "IdTipoProteccion")
    private TipoProteccion tipoProteccion;
    @ManyToOne
    @JoinColumn(name = "IdGeneroFk")
    private Genero genero;
    private String codigo;
//    @ManyToMany
//    @JoinTable(
//            name = "insumo_prendas",
//            joinColumns = @JoinColumn(name = "id_prenda"),
//            inverseJoinColumns = @JoinColumn(name = "id_insumo")
//    )
//    private List<Insumo> insumos = new ArrayList<>();
}
