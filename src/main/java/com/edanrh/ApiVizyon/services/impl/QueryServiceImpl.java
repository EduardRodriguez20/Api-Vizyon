package com.edanrh.ApiVizyon.services.impl;

import com.edanrh.ApiVizyon.dto.*;
import com.edanrh.ApiVizyon.dto.converters.*;
import com.edanrh.ApiVizyon.exceptions.BussinesRuleException;
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

    private CargoRepository cargoRepository;
    private ClienteRepository clienteRepository;
    private DetalleVentaRepository detalleVentaRepository;
    private DetalleOrdenRepository detalleOrdenRepository;
    private EmpleadoRepository empleadoRepository;
    private EmpresaRepository empresaRepository;
    private EstadoRepository estadoRepository;
    private FormaPagoRepository formaPagoRepository;
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
    private TipoPersonaRepository tPersonaRepository;
    private TipoProteccionRepository tProteccionRepository;
    private CargoDTOConvert cargoDTOConvert;
    private ClienteDTOConvert clienteDTOConvert;
    private EmpleadoDTOConvert empleadoDTOConvert;
    private EmpresaDTOConvert empresaDTOConvert;
    private EstadoDTOConvert estadoDTOConvert;
    private FormaPagoDTOConvert formaPagoDTOConvert;
    private InventarioDTOConvert inventarioDTOConvert;
    private VentaDTOConvert ventaDTOConvert;
    private OrdenDTOConvert ordenDTOConvert;
    private PrendaDTOConvert prendaDTOConvert;
    private ProveedorDTOConvert proveedorDTOConvert;
    private InsumoDTOConvert insumoDTOConvert;
    private DetalleVentaDTOConvert dvDTOConvert;
    private DetalleOrdenDTOConvert doDTOConvert;
    private TipoPersonaDTOConvert tPersonaDTOConvert;
    private TipoProteccionDTOConvert tProteccionDTOConvert;

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
                if (ventas == null) ventas = 0;
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
                    Integer cantidad = detalleVentaRepository.countByProductoId(inventario.get().getId());
                    if (cantidad == null) cantidad = 0;
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
    public List<VentaDTO> query16(Date fecha1, Date fecha2) throws NotFoundException, BussinesRuleException {
        if (fecha1.getTime() < fecha2.getTime()){
            throw new BussinesRuleException("code", "La fecha 1 debe ser mayor que la fecha 2", HttpStatus.BAD_REQUEST);
        }else {
            List<Venta> list = ventaRepository.findAllBetweenDates(fecha1, fecha2);
            if (list.isEmpty()){
                throw new NotFoundException("code", "No hay ventas registradas en esas fechas", HttpStatus.NO_CONTENT);
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
    }

    @Override
    public List<PrendaUsdDTO> query17() throws NotFoundException {
        List<Prenda> list = (List<Prenda>) prendaRepository.findAll();
        if (list.isEmpty()){
            throw new NotFoundException("code", "No hay prendas registradas", HttpStatus.NO_CONTENT);
        }else{
            List<PrendaUsdDTO> dtoList = new ArrayList<>();
            for (Prenda p : list){
                dtoList.add(prendaDTOConvert.toUsdDTO(p));
            }
            return dtoList;
        }
    }

    @Override
    public List<ClienteDTO> query18() throws NotFoundException {
        List<Cliente> list = (List<Cliente>) clienteRepository.findAll();
        if (list.isEmpty()){
            throw new NotFoundException("code", "No hay clientes registrados", HttpStatus.NO_CONTENT);
        }else {
            List<ClienteDTO> dtoList = new ArrayList<>();
            for (Cliente c : list){
                ClienteDTO cDTO = clienteDTOConvert.toDTO(c);
                Integer compras = ventaRepository.countByClienteId(c.getId());
                if (compras == null) compras = 0;
                cDTO.setCompras(compras);
                dtoList.add(cDTO);
            }
            return dtoList;
        }
    }

    @Override
    public List<OrdenDTO> query19() throws NotFoundException {
        List<Orden> list = (List<Orden>) ordenRepository.findAll();
        if (list.isEmpty()){
            throw new NotFoundException("code", "No hay ordenes registradas", HttpStatus.NO_CONTENT);
        }else {
            List<OrdenDTO> dtoList = new ArrayList<>();
            for (Orden o : list){
                OrdenDTO oDTO = ordenDTOConvert.toDTO(o);
                dtoList.add(oDTO);
            }
            return dtoList;
        }
    }

    @Override
    public List<CargoDTO> query20(double sueldoBase) throws NotFoundException {
        List<Cargo> list = cargoRepository.findBySueldoBaseGreaterThan(sueldoBase);
        if (list.isEmpty()){
            throw new NotFoundException("code", "No hay cargos con sueldo mayor al ingresado", HttpStatus.NO_CONTENT);
        }else{
            List<CargoDTO> dtoList = new ArrayList<>();
            for (Cargo c : list){
                CargoDTO cDTO = cargoDTOConvert.toDTO(c);
                dtoList.add(cDTO);
            }
            return dtoList;
        }
    }

    @Override
    public List<ClientePaisDTO> query21() throws NotFoundException {
        List<Cliente> list = (List<Cliente>) clienteRepository.findAll();
        if (list.isEmpty()){
            throw new NotFoundException("code", "No hay clientes registrados", HttpStatus.NO_CONTENT);
        }else {
            List<ClientePaisDTO> dtoList = new ArrayList<>();
            for (Cliente c : list){
                ClientePaisDTO cDTO = clienteDTOConvert.toPaisDTO(c);
                dtoList.add(cDTO);
            }
            return dtoList;
        }
    }

    @Override
    public List<TipoProteccionDTO> query22() throws NotFoundException {
        List<TipoProteccion> list = (List<TipoProteccion>) tProteccionRepository.findAll();
        if (list.isEmpty()){
            throw new NotFoundException("code", "No hay tipos de proteccion registrados", HttpStatus.NO_CONTENT);
        }else {
            List<TipoProteccionDTO> dtoList = new ArrayList<>();
            for (TipoProteccion tp : list){
                Integer cantidad = prendaRepository.countByTipoProteccionId(tp.getId());
                if (cantidad == null) cantidad = 0;
                TipoProteccionDTO tpDTO = tProteccionDTOConvert.toDTO(tp, cantidad);
                dtoList.add(tpDTO);
            }
            return dtoList;
        }
    }

    @Override
    public List<EmpleadoDTO> query23() throws NotFoundException {
        List<Empleado> list = empleadoRepository.findByOrderByFechaIngresoDesc();
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
    public List<CargoCantidadDTO> query24() throws NotFoundException {
        List<Cargo> list = (List<Cargo>) cargoRepository.findAll();
        if (list.isEmpty()){
            throw new NotFoundException("code", "No hay cargos registrados", HttpStatus.NO_CONTENT);
        }else {
            List<CargoCantidadDTO> dtoList = new ArrayList<>();
            for (Cargo c : list){
                Integer cantidad = empleadoRepository.countByCargoId(c.getId());
                if (cantidad == null) cantidad = 0;
                CargoCantidadDTO cDTO = cargoDTOConvert.toCantidadDTO(c, cantidad);
                dtoList.add(cDTO);
            }
            return dtoList;
        }
    }

    @Override
    public List<EstadoPrendaDTO> query25() throws NotFoundException {
        List<Estado> list = (List<Estado>) estadoRepository.findAll();
        if (list.isEmpty()){
            throw new NotFoundException("code", "No hay estados registrados", HttpStatus.NO_CONTENT);
        }else {
            List<EstadoPrendaDTO> dtoList = new ArrayList<>();
            for (Estado e : list){
                Integer cantidad = prendaRepository.countByEstadoId(e.getId());
                if (cantidad == null) cantidad = 0;
                EstadoPrendaDTO eDTO = estadoDTOConvert.toPrendaDTO(e, cantidad);
                dtoList.add(eDTO);
            }
            return dtoList;
        }
    }

    @Override
    public List<TipoPersonaDTO> query26() throws NotFoundException {
        List<TipoPersona> list = (List<TipoPersona>) tPersonaRepository.findAll();
        if (list.isEmpty()){
            throw new NotFoundException("code", "No hay tipos de persona registrados", HttpStatus.NO_CONTENT);
        }else {
            List<TipoPersonaDTO> dtoList = new ArrayList<>();
            for (TipoPersona tp : list){
                Integer cantidadCliente = clienteRepository.countByTipoPersonaId(tp.getId());
                if (cantidadCliente == null) cantidadCliente = 0;
                Integer cantidadProveedor = proveedorRepository.countByTipoPersonaId(tp.getId());
                if (cantidadProveedor == null) cantidadProveedor = 0;
                int cantidad = cantidadCliente + cantidadProveedor;
                TipoPersonaDTO tpDTO = tPersonaDTOConvert.toDTO(tp, cantidad);
                dtoList.add(tpDTO);
            }
            return dtoList;
        }
    }

    @Override
    public List<TipoProteccionDTO> query27() throws NotFoundException {
        List<TipoProteccion> list = (List<TipoProteccion>) tProteccionRepository.findAll();
        if (list.isEmpty()){
            throw new NotFoundException("code", "No hay tipos de proteccion registrados", HttpStatus.NO_CONTENT);
        }else {
            List<TipoProteccionDTO> dtoList = new ArrayList<>();
            for (TipoProteccion tp : list){
                Integer cantidad = prendaRepository.countByTipoProteccionId(tp.getId());
                if (cantidad == null) cantidad = 0;
                TipoProteccionDTO tpDTO = tProteccionDTOConvert.toDTO(tp, cantidad);
                dtoList.add(tpDTO);
            }
            return dtoList;
        }
    }

    @Override
    public List<EstadoOrdenDTO> query28() throws NotFoundException {
        List<Estado> list = (List<Estado>) estadoRepository.findAll();
        if (list.isEmpty()){
            throw new NotFoundException("code", "No hay estados registrados", HttpStatus.NO_CONTENT);
        }else {
            List<EstadoOrdenDTO> dtoList = new ArrayList<>();
            for (Estado e : list){
                Integer cantidad = ordenRepository.countByEstadoId(e.getId());
                if (cantidad == null) cantidad = 0;
                EstadoOrdenDTO eDTO = estadoDTOConvert.toOrdenDTO(e, cantidad);
                dtoList.add(eDTO);
            }
            return dtoList;
        }
    }

    @Override
    public List<FormaPagoDTO> query29() throws NotFoundException {
        List<FormaPago> list = (List<FormaPago>) formaPagoRepository.findAll();
        if (list.isEmpty()){
            throw new NotFoundException("code", "No hay formas de pago registrados", HttpStatus.NO_CONTENT);
        }else {
            List<FormaPagoDTO> dtoList = new ArrayList<>();
            for (FormaPago fp : list){
                Integer cantidad = ventaRepository.countByFormaPagoId(fp.getId());
                if (cantidad == null) cantidad = 0;
                FormaPagoDTO fpDTO = formaPagoDTOConvert.toDTO(fp, cantidad);
                dtoList.add(fpDTO);
            }
            return dtoList;
        }
    }

    @Override
    public List<InsumoPrendasDTO> query30() throws NotFoundException {
        List<Insumo> list = (List<Insumo>) insumoRepository.findAll();
        if (list.isEmpty()){
            throw new NotFoundException("code", "No hay insumos registrados", HttpStatus.NO_CONTENT);
        }else {
            List<InsumoPrendasDTO> dtoList = new ArrayList<>();
            for (Insumo i : list){
                Integer cantidad = insumoPrendaRepository.countByInsumoId(i.getId());
                if (cantidad == null) cantidad = 0;
                InsumoPrendasDTO iDTO = insumoDTOConvert.toPrendasDTO(i, cantidad);
                dtoList.add(iDTO);
            }
            return dtoList;
        }
    }

    @Override
    public List<ClienteTotalDTO> query31() throws NotFoundException {
        List<Cliente> list = (List<Cliente>) clienteRepository.findAll();
        if (list.isEmpty()){
            throw new NotFoundException("code", "No hay clientes registrados", HttpStatus.NO_CONTENT);
        }else {
            List<ClienteTotalDTO> dtoList = new ArrayList<>();
            for (Cliente c : list){
                List<Venta> ventas = ventaRepository.findAllByClienteId(c.getId());
                double totalCOP = 0;
                double totalUSD = 0;
                for (Venta v : ventas){
                    List<DetalleVenta> detalleVentas = detalleVentaRepository.findAllByVentaId(v.getId());
                    for (DetalleVenta dv : detalleVentas){
                        totalCOP = totalCOP + (dv.getCantidad() * dv.getProducto().getValorVtaCop());
                        totalUSD = totalUSD + (dv.getCantidad() * dv.getProducto().getValorVtaUsd());
                    }
                }
                ClienteTotalDTO cDTO = clienteDTOConvert.toTotalDTO(c, totalCOP, totalUSD);
                dtoList.add(cDTO);
            }
            return dtoList;
        }
    }

    @Override
    public List<PrendaTotalCopDTO> query32() throws NotFoundException {
        List<Prenda> list = (List<Prenda>) prendaRepository.findAll();
        if (list.isEmpty()){
            throw new NotFoundException("code", "No hay prendas registrados", HttpStatus.NO_CONTENT);
        }else {
            List<PrendaTotalCopDTO> dtoList = new ArrayList<>();
            for (Prenda p : list){
                Integer cantidad = detalleVentaRepository.findSumByProductoId(p.getId());
                double total = cantidad * p.getValorUnitCop();
                PrendaTotalCopDTO pDTO = prendaDTOConvert.toTotalCopDTO(p, total);
                dtoList.add(pDTO);
            }
            return dtoList;
        }
    }

    @Override
    public List<EstadoPrendaDTO> query33() {
        return List.of();
    }
}
