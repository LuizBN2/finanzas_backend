package com.luizbn2.finanzas.controllers;

import com.luizbn2.finanzas.entities.Deuda;
import com.luizbn2.finanzas.entities.Ingreso;
import com.luizbn2.finanzas.services.DeudaService;
import com.luizbn2.finanzas.services.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;

@CrossOrigin
@RestController()
@RequestMapping("/deudas")
public class DeudaController {
    @Autowired
    DeudaService deudaService;
    @Autowired
    ReporteService reporteService;

    //control GET
    @GetMapping
    public List<Deuda> deudas(){
        return this.deudaService.getRepository();
    }

    //control POST
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Deuda Deuda(@RequestBody Deuda deuda){
        return deudaService.createDeuda(deuda);
    }

    //control PUT
    @PutMapping("{id}")
    public Deuda upDeuda(@RequestBody Deuda deuda, @PathVariable Long id){
        return this.deudaService.updateDeuda(deuda, id);
    }

    //control DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delDeuda(@PathVariable Long id){
        this.deudaService.deleteDeuda(id);
    }

    // control REPORTE deudas
    @GetMapping("/reporte")
    public List<Deuda> generarReporte(@RequestParam String fechaInicio, @RequestParam String fechaFin){
        try {
            LocalDateTime inicio = LocalDateTime.parse(fechaInicio);
            LocalDateTime fin = LocalDateTime.parse(fechaFin);
            return this.reporteService.generarInformeDeuda(inicio, fin);
        }catch (DateTimeParseException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Formato de fecha incorrecto", e);
        }

    }

    @PutMapping("/{id}/abonar")
    public Deuda abonDeuda(@PathVariable Long id, @RequestParam BigDecimal pago){
        return this.deudaService.abonarDeuda(id, pago);
    }
}
