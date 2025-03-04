package com.luizbn2.finanzas.services;

import com.luizbn2.finanzas.entities.Ingreso;
import com.luizbn2.finanzas.repositories.IngresoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class IngresoService {
    private IngresoRepository ingresoRepository;

    //Constructor
    public IngresoService(IngresoRepository ingresoRepository){
        this.ingresoRepository = ingresoRepository;
    }

    //servicio GET
    public List<Ingreso> getRepository(){
        return this.ingresoRepository.findAll();
    }

    //servicio POST
    public Ingreso createIngreso(Ingreso ingreso){
        return this.ingresoRepository.save(ingreso);
    }

    //servicio PUT
    public Ingreso updateIngreso(Ingreso ingreso, Long id){
        Ingreso ingresoFromDb = ingresoRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);
        ingresoFromDb.setDescripcion(ingreso.getDescripcion());
        ingresoFromDb.setFechaIngreso(ingreso.getFechaIngreso());
        ingresoFromDb.setMonto(ingreso.getMonto());
        return ingresoRepository.save(ingresoFromDb);
    }

    //servicio DELETE
    public void deleteIngreso (Long id){
        Ingreso ingresoFromDb = ingresoRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);
        ingresoRepository.delete(ingresoFromDb);
    }

}
