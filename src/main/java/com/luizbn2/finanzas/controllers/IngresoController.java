package com.luizbn2.finanzas.controllers;

import com.luizbn2.finanzas.entities.Ingreso;
import com.luizbn2.finanzas.services.IngresoService;
import com.luizbn2.finanzas.services.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin
@RestController()
@RequestMapping("/ingresos")
public class IngresoController {
    @Autowired
    IngresoService ingresoService;
    @Autowired
    ReporteService reporteService;

    //control GET
    @GetMapping
    public List<Ingreso> ingresos(){
        return this.ingresoService.getRepository();
    }

    //control POST
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Ingreso crIngreso(@RequestBody Ingreso ingreso){
        return ingresoService.createIngreso(ingreso);
    }

    //control PUT
    @PutMapping("{id}")
    public Ingreso upIngreso(@RequestBody Ingreso ingreso, @PathVariable Long id){
        return this.ingresoService.updateIngreso(ingreso, id);
    }

    //control DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delIngreso(@PathVariable Long id){
        this.ingresoService.deleteIngreso(id);
    }

    // control REPORTE ingresos
    @GetMapping("/reporte")
    public List<Ingreso> generarReporte(@RequestParam String fechaInicio, @RequestParam String fechaFin){
        LocalDateTime inicio = LocalDateTime.parse(fechaInicio);
        LocalDateTime fin = LocalDateTime.parse(fechaFin);
        return this.reporteService.generarInformeIngresos(inicio, fin);
    }
}
