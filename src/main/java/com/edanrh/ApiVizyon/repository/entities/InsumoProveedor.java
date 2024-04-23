package com.edanrh.ApiVizyon.repository.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "insumo_proveedor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsumoProveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "IdInsumoFk")
    private Insumo insumo;
    @ManyToOne
    @JoinColumn(name = "IdProveedorFk")
    private Proveedor proveedor;
}
