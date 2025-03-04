package com.luizbn2.finanzas.services;

import com.luizbn2.finanzas.entities.Gasto;
import com.luizbn2.finanzas.repositories.GastoRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class GastoService {
    private GastoRepository gastoRepository;

    //Constructor
    public GastoService(GastoRepository gastoRepository){
        this.gastoRepository = gastoRepository;
    }

    //servicio GET
    public List<Gasto> getRepository(){
        return this.gastoRepository.findAll();
    }

    //servicio POST
    public Gasto createGasto(Gasto gasto){
        return this.gastoRepository.save(gasto);
    }

    //servicio PUT
    public Gasto updateGasto(Gasto gasto, Long id){
        Gasto gastoFromDb = gastoRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);
        gastoFromDb.setDescripcion(gasto.getDescripcion());
        gastoFromDb.setFechaGasto(gasto.getFechaGasto());
        gastoFromDb.setMonto(gasto.getMonto());
        return gastoRepository.save(gastoFromDb);
    }

    //servicio DELETE
    public void deleteGasto (Long id){
        Gasto gastoFromDb = gastoRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);
        gastoRepository.delete(gastoFromDb);
    }
}
