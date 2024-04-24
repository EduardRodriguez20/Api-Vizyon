package com.edanrh.ApiVizyon.controllers;

import com.edanrh.ApiVizyon.dto.*;
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
    public ResponseEntity<?> query16(@RequestParam Date fecha1,@RequestParam Date fecha2) throws NotFoundException {
        Map<String,Object> response=new HashMap<>();
        List<VentaDTO> list = queryService.query16(fecha1, fecha2);
        response.put("Ventas", list);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
