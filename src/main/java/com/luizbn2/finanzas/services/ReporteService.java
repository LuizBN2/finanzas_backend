package com.luizbn2.finanzas.services;

import com.luizbn2.finanzas.entities.Deuda;
import com.luizbn2.finanzas.entities.Gasto;
import com.luizbn2.finanzas.entities.Ingreso;
import com.luizbn2.finanzas.repositories.DeudaRepository;
import com.luizbn2.finanzas.repositories.GastoRepository;
import com.luizbn2.finanzas.repositories.IngresoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReporteService {
    @Autowired
    private IngresoRepository ingresoRepository;
    @Autowired
    private GastoRepository gastoRepository;
    @Autowired
    private DeudaRepository deudaRepository;

    //Generar reporte de ingresos entre fechas
    public List<Ingreso> generarInformeIngresos(LocalDateTime fechaInicio, LocalDateTime fechaFin){
        return ingresoRepository.findAll().stream()
                .filter(ingreso -> ingreso.getFechaIngreso().isAfter(fechaInicio) && ingreso.getFechaIngreso().isBefore(fechaFin))
                .collect(Collectors.toList());
    }

    //Generar reporte de gastos entre fechas
    public List<Gasto> generarInformeGastos(LocalDateTime fechaInicio, LocalDateTime fechaFin){
        return gastoRepository.findAll().stream()
                .filter(gasto -> gasto.getFechaGasto().isAfter(fechaInicio) && gasto.getFechaGasto().isBefore(fechaFin))
                .collect(Collectors.toList());
    }

    //Generar reporte de deudas entre fechas
    public List<Deuda> generarInformeDeuda(LocalDateTime fechaInicio, LocalDateTime fechaFin){
        return deudaRepository.findAll().stream()
                .filter(deuda -> deuda.getFechaDeuda().isAfter(fechaInicio) && deuda.getFechaDeuda().isBefore(fechaFin))
                .collect(Collectors.toList());
    }
}
