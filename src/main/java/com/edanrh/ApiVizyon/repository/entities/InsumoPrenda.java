package com.edanrh.ApiVizyon.repository.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "insumo_prendas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsumoPrenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "IdInsumoFk")
    private Insumo insumo;
    @ManyToOne
    @JoinColumn(name = "IdPrendaFk")
    private Prenda prenda;
    private int cantidad;
}
