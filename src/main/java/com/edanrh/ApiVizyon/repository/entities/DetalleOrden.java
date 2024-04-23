package com.edanrh.ApiVizyon.repository.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "detalle_orden")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleOrden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "IdOrdenFk")
    private Orden orden;
    @ManyToOne
    @JoinColumn(name = "IdPrendaFk")
    private Prenda prenda;
    @ManyToOne
    @JoinColumn(name = "PrendaId")
    private Prenda prendaId;
    @Column(name = "cantidad_producir")
    private int cantidadProducir;
    @ManyToOne
    @JoinColumn(name = "IdColorFk")
    private Color color;
    @Column(name = "cantidad_producida")
    private int cantidadProducida;
    @ManyToOne
    @JoinColumn(name = "IdEstadoFk")
    private Estado estado;
}
