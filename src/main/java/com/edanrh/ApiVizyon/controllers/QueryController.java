package com.edanrh.ApiVizyon.controllers;

import com.edanrh.ApiVizyon.dto.*;
import com.edanrh.ApiVizyon.exceptions.BussinesRuleException;
import com.edanrh.ApiVizyon.exceptions.NotFoundException;
import com.edanrh.ApiVizyon.services.QueryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/query")
@AllArgsConstructor
public class QueryController {

    private QueryService queryService;

    @GetMapping("/query1")
    public ResponseEntity<?> query1(@RequestParam String mes, @RequestParam String year) throws NotFoundException {
        Map<String,Object> response=new HashMap<>();
        List<VentaDTO> list = queryService.query1(mes, year);
        response.put("Ventas", list);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/query2")
    public ResponseEntity<?> query2() throws NotFoundException {
        Map<String,Object> response=new HashMap<>();
        List<EmpleadoDTO> list = queryService.query2();
        response.put("Empleados", list);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/query3")
    public ResponseEntity<?> query3() throws NotFoundException {
        Map<String,Object> response=new HashMap<>();
        List<VentaDTO> list = queryService.query3();
        response.put("Ventas", list);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/query4")
    public ResponseEntity<?> query4() throws NotFoundException {
        Map<String,Object> response=new HashMap<>();
        List<OrdenDTO> list = queryService.query4();
        response.put("Ordenes", list);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/query5")
    public ResponseEntity<?> query5() throws NotFoundException {
        Map<String,Object> response=new HashMap<>();
        List<InventarioDTO> list = queryService.query5();
        response.put("Inventarios", list);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/query6")
    public ResponseEntity<?> query6() throws NotFoundException {
        Map<String,Object> response=new HashMap<>();
        List<ProveedorDTO> list = queryService.query6();
        response.put("Proveedores", list);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/query7")
    public ResponseEntity<?> query7() throws NotFoundException {
        Map<String,Object> response=new HashMap<>();
        List<EmpleadoVentasDTO> list = queryService.query7();
        response.put("Empleados", list);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/query8")
    public ResponseEntity<?> query8() throws NotFoundException {
        Map<String,Object> response=new HashMap<>();
        List<OrdenDTO> list = queryService.query8();
        response.put("Ordenes", list);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/query9")
    public ResponseEntity<?> query9() throws NotFoundException {
        Map<String,Object> response=new HashMap<>();
        List<EmpresaDTO> list = queryService.query9();
        response.put("Empresas", list);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/query10")
    public ResponseEntity<?> query10() throws NotFoundException {
        Map<String,Object> response=new HashMap<>();
        List<DetalleOrdenStockDTO> list = queryService.query10();
        response.put("Prendas y Stock", list);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/query11")
    public ResponseEntity<?> query11(@RequestParam Date fecha) throws NotFoundException {
        Map<String,Object> response=new HashMap<>();
        List<VentaDTO> list = queryService.query11(fecha);
        response.put("Ventas", list);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/query12")
    public ResponseEntity<?> query12() throws NotFoundException {
        Map<String,Object> response=new HashMap<>();
        List<EmpleadoDTO> list = queryService.query12();
        response.put("Empleados", list);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/query13")
    public ResponseEntity<?> query13() throws NotFoundException {
        Map<String,Object> response=new HashMap<>();
        List<PrendaTotalUsdDTO> list = queryService.query13();
        response.put("Total prendas USD", list);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/query14")
    public ResponseEntity<?> query14() throws NotFoundException {
        Map<String,Object> response=new HashMap<>();
        List<PrendaInsumosDTO> list = queryService.query14();
        response.put("Prendas e Insumos", list);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/query15")
    public ResponseEntity<?> query15() throws NotFoundException {
        Map<String,Object> response=new HashMap<>();
        List<EmpleadoDTO> list = queryService.query15();
        response.put("Empleados", list);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/query16")
    public ResponseEntity<?> query16(@RequestParam Date fecha1,@RequestParam Date fecha2) throws NotFoundException, BussinesRuleException {
        Map<String,Object> response=new HashMap<>();
        List<VentaDTO> list = queryService.query16(fecha1, fecha2);
        response.put("Ventas", list);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/query17")
    public ResponseEntity<?> query17() throws NotFoundException {
        Map<String,Object> response=new HashMap<>();
        List<PrendaUsdDTO> list = queryService.query17();
        response.put("Prendas", list);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/query18")
    public ResponseEntity<?> query18() throws NotFoundException {
        Map<String,Object> response=new HashMap<>();
        List<ClienteDTO> list = queryService.query18();
        response.put("Clientes", list);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/query19")
    public ResponseEntity<?> query19() throws NotFoundException {
        Map<String,Object> response=new HashMap<>();
        List<OrdenDTO> list = queryService.query19();
        response.put("Ordenes", list);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/query20")
    public ResponseEntity<?> query20(@RequestParam double sueldoBase) throws NotFoundException {
        Map<String,Object> response=new HashMap<>();
        List<CargoDTO> list = queryService.query20(sueldoBase);
        response.put("Cargos", list);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/query21")
    public ResponseEntity<?> query21() throws NotFoundException {
        Map<String,Object> response=new HashMap<>();
        List<ClientePaisDTO> list = queryService.query21();
        response.put("Clientes", list);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/query22")
    public ResponseEntity<?> query22() throws NotFoundException {
        Map<String,Object> response=new HashMap<>();
        List<TipoProteccionDTO> list = queryService.query22();
        response.put("Tipos de proteccion", list);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/query23")
    public ResponseEntity<?> query23() throws NotFoundException {
        Map<String,Object> response=new HashMap<>();
        List<EmpleadoDTO> list = queryService.query23();
        response.put("Empleados", list);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/query24")
    public ResponseEntity<?> query24() throws NotFoundException {
        Map<String,Object> response=new HashMap<>();
        List<CargoCantidadDTO> list = queryService.query24();
        response.put("Cargos", list);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/query25")
    public ResponseEntity<?> query25() throws NotFoundException {
        Map<String,Object> response=new HashMap<>();
        List<EstadoPrendaDTO> list = queryService.query25();
        response.put("Estados de prendas", list);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/query26")
    public ResponseEntity<?> query26() throws NotFoundException {
        Map<String,Object> response=new HashMap<>();
        List<TipoPersonaDTO> list = queryService.query26();
        response.put("Tipos persona", list);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/query27")
    public ResponseEntity<?> query27() throws NotFoundException {
        Map<String,Object> response=new HashMap<>();
        List<TipoProteccionDTO> list = queryService.query27();
        response.put("Tipos proteccion", list);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/query28")
    public ResponseEntity<?> query28() throws NotFoundException {
        Map<String,Object> response=new HashMap<>();
        List<EstadoOrdenDTO> list = queryService.query28();
        response.put("Estados ordenes", list);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/query29")
    public ResponseEntity<?> query29() throws NotFoundException {
        Map<String,Object> response=new HashMap<>();
        List<FormaPagoDTO> list = queryService.query29();
        response.put("Formas de pago", list);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/query30")
    public ResponseEntity<?> query30() throws NotFoundException {
        Map<String,Object> response=new HashMap<>();
        List<InsumoPrendasDTO> list = queryService.query30();
        response.put("Tipo Insumos", list);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/query31")
    public ResponseEntity<?> query31() throws NotFoundException {
        Map<String,Object> response=new HashMap<>();
        List<ClienteTotalDTO> list = queryService.query31();
        response.put("Total compras cliente", list);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/query32")
    public ResponseEntity<?> query32() throws NotFoundException {
        Map<String,Object> response=new HashMap<>();
        List<PrendaTotalCopDTO> list = queryService.query32();
        response.put("Total Prendas", list);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/query33")
    public ResponseEntity<?> query33() throws NotFoundException {
        Map<String,Object> response=new HashMap<>();
        List<EstadoPrendaDTO> list = queryService.query33();
        response.put("Estado de prendas", list);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
