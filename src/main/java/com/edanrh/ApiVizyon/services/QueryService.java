package com.edanrh.ApiVizyon.services;

import com.edanrh.ApiVizyon.dto.*;
import com.edanrh.ApiVizyon.exceptions.BussinesRuleException;
import com.edanrh.ApiVizyon.exceptions.NotFoundException;

import java.util.Date;
import java.util.List;

public interface QueryService {
    List<VentaDTO> query1(String mes, String year) throws NotFoundException;
    List<EmpleadoDTO> query2() throws NotFoundException;
    List<VentaDTO> query3() throws NotFoundException;
    List<OrdenDTO> query4() throws NotFoundException;
    List<InventarioDTO> query5() throws NotFoundException;
    List<ProveedorDTO> query6() throws NotFoundException;
    List<EmpleadoVentasDTO> query7() throws NotFoundException;
    List<OrdenDTO> query8() throws NotFoundException;
    List<EmpresaDTO> query9() throws NotFoundException;
    List<DetalleOrdenStockDTO> query10() throws NotFoundException;
    List<VentaDTO> query11(Date fecha) throws NotFoundException;
    List<EmpleadoDTO> query12() throws NotFoundException;
    List<PrendaTotalUsdDTO> query13() throws NotFoundException;
    List<PrendaInsumosDTO> query14() throws NotFoundException;
    List<EmpleadoDTO> query15() throws NotFoundException;
    List<VentaDTO> query16(Date fecha1, Date fecha2) throws NotFoundException, BussinesRuleException;
    List<PrendaUsdDTO> query17() throws NotFoundException;
    List<ClienteDTO> query18() throws NotFoundException;
    List<OrdenDTO> query19() throws NotFoundException;
    List<CargoDTO> query20(double sueldoBase) throws NotFoundException;
    List<ClientePaisDTO> query21() throws NotFoundException;
    List<TipoProteccionDTO> query22() throws NotFoundException;
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
