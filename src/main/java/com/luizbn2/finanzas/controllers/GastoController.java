package com.luizbn2.finanzas.controllers;

import com.luizbn2.finanzas.entities.Gasto;
import com.luizbn2.finanzas.services.GastoService;
import com.luizbn2.finanzas.services.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin
@RestController()
@RequestMapping("/gastos")
public class GastoController {
    @Autowired
    GastoService gastoService;

    @Autowired
    ReporteService reporteService;

    //control GET
    @GetMapping
    public List<Gasto> gastos(){
        return this.gastoService.getRepository();
    }

    //control POST
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Gasto crGasto(@RequestBody Gasto gasto){
        return gastoService.createGasto(gasto);
    }

    //control PUT
    @PutMapping("{id}")
    public Gasto upGasto(@RequestBody Gasto gasto, @PathVariable Long id){
        return this.gastoService.updateGasto(gasto, id);
    }

    //control DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delGasto(@PathVariable Long id){
        this.gastoService.deleteGasto(id);
    }

    // control REPORTE gastos
    @GetMapping("/reporte")
    public List<Gasto> generarReporte(@RequestParam String fechaInicio, @RequestParam String fechaFin){
        LocalDateTime inicio = LocalDateTime.parse(fechaInicio);
        LocalDateTime fin = LocalDateTime.parse(fechaFin);
        return this.reporteService.generarInformeGastos(inicio, fin);
    }

}
