package com.edanrh.ApiVizyon.repository.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codInv;
    @OneToOne
    @JoinColumn(name = "IdPrendaFk")
    private Prenda prenda;
    private double valorVtaCop;
    private double valorVtaUsd;
}
