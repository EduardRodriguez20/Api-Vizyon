Los queries de insercion contenian errores, los cuales se pueden arreglar cambiando los siguientes insert:
- Retirar los ultimos insert ya que no pertenecen a insumos registrados:

INSERT INTO insumo_prendas (IdInsumoFk, IdPrendaFk, Cantidad)
VALUES
(1, 1, 2),
(2, 2, 1),
(3, 3, 3),
(4, 4, 2),
(5, 5, 1);
-- (6, 6, 10),
-- (7, 7, 5),
-- (8, 8, 3),
-- (9, 9, 2),
-- (10, 10, 1);

- Cambiar los IdProveedorFk puesto que no existen.
INSERT INTO insumo_proveedor (IdInsumoFk, IdProveedorFk)
VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);
