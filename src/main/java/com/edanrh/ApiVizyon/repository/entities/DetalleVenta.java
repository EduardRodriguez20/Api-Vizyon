package com.edanrh.ApiVizyon.repository.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "detalle_venta")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "IdVentaFk")
    private Venta venta;
    @ManyToOne
    @JoinColumn(name = "IdProductoFk")
    private Inventario producto;
    @ManyToOne
    @JoinColumn(name = "IdTallaFk")
    private Talla talla;
    private int cantidad;
    @Column(name = "valor_unit")
    private double valorUnit;
}
