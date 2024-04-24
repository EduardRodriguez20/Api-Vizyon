package com.edanrh.ApiVizyon.services.impl;

import com.edanrh.ApiVizyon.dto.*;
import com.edanrh.ApiVizyon.dto.converters.*;
import com.edanrh.ApiVizyon.exceptions.NotFoundException;
import com.edanrh.ApiVizyon.repository.*;
import com.edanrh.ApiVizyon.repository.entities.*;
import com.edanrh.ApiVizyon.services.QueryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class QueryServiceImpl implements QueryService {

    private DetalleVentaRepository detalleVentaRepository;
    private DetalleOrdenRepository detalleOrdenRepository;
    private EmpleadoRepository empleadoRepository;
    private EmpresaRepository empresaRepository;
    private InsumoRepository insumoRepository;
    private InsumoPrendaRepository insumoPrendaRepository;
    private InsumoProveedorRepository ipRepository;
    private InventarioRepository inventarioRepository;
    private InventarioTallaRepository itRepository;
    private OrdenRepository ordenRepository;
    private PrendaRepository prendaRepository;
    private VentaRepository ventaRepository;
    private ProveedorRepository proveedorRepository;
    private DetalleVentaRepository dvRepository;
    private DetalleOrdenRepository doRepository;
    private EmpleadoDTOConvert empleadoDTOConvert;
    private EmpresaDTOConvert empresaDTOConvert;
    private InventarioDTOConvert inventarioDTOConvert;
    private VentaDTOConvert ventaDTOConvert;
    private OrdenDTOConvert ordenDTOConvert;
    private PrendaDTOConvert prendaDTOConvert;
    private ProveedorDTOConvert proveedorDTOConvert;
    private InsumoDTOConvert insumoDTOConvert;
    private DetalleVentaDTOConvert dvDTOConvert;
    private DetalleOrdenDTOConvert doDTOConvert;

    @Override
    public List<VentaDTO> query1(String mes, String year) throws NotFoundException {
        List<Venta> list = ventaRepository.findByDates(mes, year);
        if (list.isEmpty()){
            throw new NotFoundException("code", "No hay ventas en esa fecha", HttpStatus.NO_CONTENT);
        }else {
            List<VentaDTO> dtoList = new ArrayList<>();
            for (Venta v : list){
                VentaDTO vDTO = ventaDTOConvert.toDTO(v);
                List<DetalleVenta> dvList = dvRepository.findAllByVentaId(v.getId());
                for (DetalleVenta dv : dvList){
                    vDTO.addItem(dvDTOConvert.toDTO(dv));
                }
                dtoList.add(vDTO);
            }
            return dtoList;
        }
    }

    @Override
    public List<EmpleadoDTO> query2() throws NotFoundException {
        List<Empleado> list = (List<Empleado>) empleadoRepository.findAll();
        if (list.isEmpty()){
            throw new NotFoundException("code", "No hay empleados registrados", HttpStatus.NO_CONTENT);
        } else {
            List<EmpleadoDTO> dtoList = new ArrayList<>();
            for (Empleado e : list){
                EmpleadoDTO eDTO = empleadoDTOConvert.toDTO(e);
                dtoList.add(eDTO);
            }
            return dtoList;
        }
    }

    @Override
    public List<VentaDTO> query3() throws NotFoundException {
        List<Venta> list = (List<Venta>) ventaRepository.findAll();
        if (list.isEmpty()){
            throw new NotFoundException("code", "No hay ventas registradas", HttpStatus.NO_CONTENT);
        } else {
            List<VentaDTO> dtoList = new ArrayList<>();
            for (Venta v : list){
                VentaDTO vDTO = ventaDTOConvert.toDTO(v);
                List<DetalleVenta> dvList = dvRepository.findAllByVentaId(v.getId());
                for (DetalleVenta dv : dvList){
                    vDTO.addItem(dvDTOConvert.toDTO(dv));
                }
                dtoList.add(vDTO);
            }
            return dtoList;
        }
    }

    @Override
    public List<OrdenDTO> query4() throws NotFoundException {
        List<Orden> list = (List<Orden>) ordenRepository.findAll();
        if (list.isEmpty()){
            throw new NotFoundException("code", "No hay ordenes registradas", HttpStatus.NO_CONTENT);
        }else {
            List<OrdenDTO> dtoList = new ArrayList<>();
            for (Orden o : list){
                OrdenDTO oDTO = ordenDTOConvert.toDTO(o);
                List<DetalleOrden> doList = doRepository.findAllByOrdenId(o.getId());
                for (DetalleOrden doEntity : doList){
                    oDTO.addItem(doDTOConvert.toDTO(doEntity, oDTO));
                }
                dtoList.add(oDTO);
            }
            return dtoList;
        }
    }

    @Override
    public List<InventarioDTO> query5() throws NotFoundException {
        List<Inventario> list = (List<Inventario>) inventarioRepository.findAll();
        if (list.isEmpty()){
            throw new NotFoundException("code", "No hay inventario registrado", HttpStatus.NO_CONTENT);
        }else {
            List<InventarioDTO> dtoList = new ArrayList<>();
            for (Inventario i : list){
                InventarioDTO iDTO = inventarioDTOConvert.toDTO(i);
                Optional<InventarioTalla> it = itRepository.findFirstByInventarioId(i.getId());
                Optional<DetalleOrden> dOrden = doRepository.findFirstByPrendaId(i.getPrenda().getId());
                if (it.isPresent()) iDTO.setTalla(it.get().getTalla().getDescripcion());
                if (dOrden.isPresent()) iDTO.setColor(dOrden.get().getColor().getDescripcion());
                dtoList.add(iDTO);
            }
            return dtoList;
        }
    }

    @Override
    public List<ProveedorDTO> query6() throws NotFoundException {
        List<Proveedor> list = (List<Proveedor>) proveedorRepository.findAll();
        if (list.isEmpty()){
            throw new NotFoundException("code", "No hay proveedores registrados", HttpStatus.NO_CONTENT);
        }else {
            List<ProveedorDTO> dtoList = new ArrayList<>();
            for (Proveedor p : list){
                ProveedorDTO pDTO = proveedorDTOConvert.toDTO(p);
                List<InsumoProveedor> iList = ipRepository.findAllByProveedorId(p.getId());
                for (InsumoProveedor ip : iList){
                    pDTO.addInsumos(insumoDTOConvert.toProveedorDTO(ip.getInsumo()));
                }
                dtoList.add(pDTO);
            }
            return dtoList;
        }
    }

    @Override
    public List<EmpleadoVentasDTO> query7() throws NotFoundException {
        List<Empleado> list = (List<Empleado>) empleadoRepository.findAll();
        if (list.isEmpty()){
            throw new NotFoundException("code", "No hay empleados registrados", HttpStatus.NO_CONTENT);
        }else {
            List<EmpleadoVentasDTO> dtoList = new ArrayList<>();
            for (Empleado e : list){
                Integer ventas = ventaRepository.countByEmpleadoId(e.getId());
                if (ventas == null){
                    ventas = 0;
                }
                EmpleadoVentasDTO eDTO = empleadoDTOConvert.toVentasDTO(e, ventas);
                dtoList.add(eDTO);
            }
            return dtoList;
        }
    }

    @Override
    public List<OrdenDTO> query8() throws NotFoundException {
        List<Orden> list = ordenRepository.findAllInProceso();
        if (list.isEmpty()){
            throw new NotFoundException("code", "No hay ordenes en proceso registradas", HttpStatus.NO_CONTENT);
        }else {
            List<OrdenDTO> dtoList = new ArrayList<>();
            for (Orden o : list){
                OrdenDTO oDTO = ordenDTOConvert.toDTO(o);
                List<DetalleOrden> doList = doRepository.findAllByOrdenId(o.getId());
                for (DetalleOrden doEntity : doList){
                    oDTO.addItem(doDTOConvert.toDTO(doEntity, oDTO));
                }
                dtoList.add(oDTO);
            }
            return dtoList;
        }
    }

    @Override
    public List<EmpresaDTO> query9() throws NotFoundException {
        List<Empresa> list = (List<Empresa>) empresaRepository.findAll();
        if (list.isEmpty()){
            throw new NotFoundException("code", "No hay empresas registradas", HttpStatus.NO_CONTENT);
        }else {
            List<EmpresaDTO> dtoList = new ArrayList<>();
            for (Empresa e : list){
                EmpresaDTO eDTO = empresaDTOConvert.toDTO(e);
                dtoList.add(eDTO);
            }
            return dtoList;
        }
    }

    @Override
    public List<DetalleOrdenStockDTO> query10() throws NotFoundException {
        List<DetalleOrden> list = (List<DetalleOrden>) detalleOrdenRepository.findAll();
        if (list.isEmpty()){
            throw new NotFoundException("code", "No hay prendas registradas", HttpStatus.NO_CONTENT);
        }else {
            List<DetalleOrdenStockDTO> dtoList = new ArrayList<>();
            for (DetalleOrden doEntity : list){
                DetalleOrdenStockDTO doDTO = doDTOConvert.toStockDTO(doEntity);
                dtoList.add(doDTO);
            }
            return dtoList;
        }
    }

    @Override
    public List<VentaDTO> query11(Date fecha) throws NotFoundException {
        List<Venta> list = ventaRepository.findAllByFecha(fecha);
        if (list.isEmpty()){
            throw new NotFoundException("code", "No hay ventas registradas en esa fecha", HttpStatus.NO_CONTENT);
        }else {
            List<VentaDTO> dtoList = new ArrayList<>();
            for (Venta v : list){
                VentaDTO vDTO = ventaDTOConvert.toDTO(v);
                List<DetalleVenta> dvList = dvRepository.findAllByVentaId(v.getId());
                for (DetalleVenta dvEntity : dvList){
                    vDTO.addItem(dvDTOConvert.toDTO(dvEntity));
                }
                dtoList.add(vDTO);
            }
            return dtoList;
        }
    }

    @Override
    public List<EmpleadoDTO> query12() throws NotFoundException {
        List<Empleado> list = (List<Empleado>) empleadoRepository.findAll();
        if (list.isEmpty()){
            throw new NotFoundException("code", "No hay empleados registrados", HttpStatus.NO_CONTENT);
        }else {
            List<EmpleadoDTO> dtoList = new ArrayList<>();
            for (Empleado e : list){
                EmpleadoDTO eDTO = empleadoDTOConvert.toDTO(e);
                dtoList.add(eDTO);
            }
            return dtoList;
        }
    }

    @Override
    public List<PrendaTotalUsdDTO> query13() throws NotFoundException {
        List<Prenda> list = (List<Prenda>) prendaRepository.findAll();
        if (list.isEmpty()){
            throw new NotFoundException("code", "No hay prendas registradas", HttpStatus.NO_CONTENT);
        }else {
            List<PrendaTotalUsdDTO> dtoList = new ArrayList<>();
            for (Prenda p : list){
                Optional<Inventario> inventario = inventarioRepository.findFirstByPrendaId(p.getId());
                if (inventario.isPresent()){
                    int cantidad = detalleVentaRepository.countByProductoId(inventario.get().getId());
                    PrendaTotalUsdDTO pDTO = prendaDTOConvert.toTotalDTO(p, (cantidad * p.getValorUnitUsd()));
                    dtoList.add(pDTO);
                }else {
                    PrendaTotalUsdDTO pDTO = prendaDTOConvert.toTotalDTO(p, 0);
                    dtoList.add(pDTO);
                }
            }
            return dtoList;
        }
    }

    @Override
    public List<PrendaInsumosDTO> query14() throws NotFoundException {
        List<Prenda> list = (List<Prenda>) prendaRepository.findAll();
        if (list.isEmpty()){
            throw new NotFoundException("code", "No hay prendas registradas", HttpStatus.NO_CONTENT);
        }else {
            List<PrendaInsumosDTO> dtoList = new ArrayList<>();
            for (Prenda p : list){
                PrendaInsumosDTO dto = prendaDTOConvert.toInsumosDTO(p);
                List<InsumoPrenda> insumos = insumoPrendaRepository.findAllByPrendaId(p.getId());
                for (InsumoPrenda ip : insumos){
                    dto.addInsumo(insumoDTOConvert.toCantidadDTO(ip.getInsumo()));
                }
            }
            return dtoList;
        }
    }

    @Override
    public List<EmpleadoDTO> query15() throws NotFoundException {
        List<Empleado> list = (List<Empleado>) empleadoRepository.findAll();
        if (list.isEmpty()){
            throw new NotFoundException("code", "No hay empleados registrados", HttpStatus.NO_CONTENT);
        }else {
            List<EmpleadoDTO> dtoList = new ArrayList<>();
            for (Empleado e : list){
                EmpleadoDTO eDTO = empleadoDTOConvert.toDTO(e);
                dtoList.add(eDTO);
            }
            return dtoList;
        }
    }

    @Override
    public List<VentaDTO> query16(Date fecha1, Date fecha2) throws NotFoundException{
        return List.of();
    }

    @Override
    public List<PrendaUsdDTO> query17() {
        return List.of();
    }

    @Override
    public List<ClienteDTO> query18() {
        return List.of();
    }

    @Override
    public List<OrdenDTO> query19() {
        return List.of();
    }

    @Override
    public List<CargoDTO> query20() {
        return List.of();
    }

    @Override
    public List<ClientePaisDTO> query21() {
        return List.of();
    }

    @Override
    public List<TipoProteccionDTO> query22() {
        return List.of();
    }

    @Override
    public List<EmpleadoDTO> query23() {
        return List.of();
    }

    @Override
    public List<CargoCantidadDTO> query24() {
        return List.of();
    }

    @Override
    public List<EstadoPrendaDTO> query25() {
        return List.of();
    }

    @Override
    public List<TipoPersonaDTO> query26() {
        return List.of();
    }

    @Override
    public List<TipoProteccionDTO> query27() {
        return List.of();
    }

    @Override
    public List<EstadoOrdenDTO> query28() {
        return List.of();
    }

    @Override
    public List<FormaPagoDTO> query29() {
        return List.of();
    }

    @Override
    public List<InsumoPrendasDTO> query30() {
        return List.of();
    }

    @Override
    public List<ClienteTotalDTO> query31() {
        return List.of();
    }

    @Override
    public List<PrendaCopDTO> query32() {
        return List.of();
    }

    @Override
    public List<EstadoPrendaDTO> query33() {
        return List.of();
    }
}
