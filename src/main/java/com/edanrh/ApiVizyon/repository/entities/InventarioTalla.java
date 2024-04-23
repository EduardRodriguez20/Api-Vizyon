package com.edanrh.ApiVizyon.repository.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "inventario_talla")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventarioTalla {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "IdInvFk")
    private Inventario inventario;
    @ManyToOne
    @JoinColumn(name = "IdTallaFk")
    private Talla talla;
}
