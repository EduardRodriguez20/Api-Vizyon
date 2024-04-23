package com.edanrh.ApiVizyon.services;

import com.edanrh.ApiVizyon.dto.*;

import java.util.Date;
import java.util.List;

public interface QueryService {
    List<VentaDTO> query1(String mes, String year);
    List<EmpleadoDTO> query2();
    List<VentaDTO> query3();
    List<OrdenDTO> query4();
    List<InventarioDTO> query5();
    List<ProveedorDTO> query6();
    List<VentaDTO> query7();
    List<OrdenDTO> query8();
    List<EmpresaDTO> query9();
    List<DetalleOrdenStockDTO> query10();
    List<VentaDTO> query11(Date fecha);
    List<EmpleadoDTO> query12();
    List<PrendaUsdDTO> query13();
    List<PrendaInsumosDTO> query14();
    List<EmpleadoDTO> query15();
    List<VentaDTO> query16();
    List<PrendaUsdDTO> query17();
    List<ClienteDTO> query18();
    List<OrdenDTO> query19();
    List<CargoDTO> query20();
    List<ClientePaisDTO> query21();
    List<TipoProteccionDTO> query22();
    List<EmpleadoDTO> query23();
    List<CargoCantidadDTO> query24();
    List<EstadoPrendaDTO> query25();
    List<TipoPersonaDTO> query26();
    List<TipoProteccionDTO> query27();
    List<EstadoOrdenDTO> query28();
    List<FormaPagoDTO> query29();
    List<InsumoPrendasDTO> query30();
    List<ClienteTotalDTO> query31();
    List<PrendaCopDTO> query32();
    List<EstadoPrendaDTO> query33();
}
