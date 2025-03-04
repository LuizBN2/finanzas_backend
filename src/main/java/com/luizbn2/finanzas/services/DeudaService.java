package com.luizbn2.finanzas.services;

import com.luizbn2.finanzas.entities.Deuda;
import com.luizbn2.finanzas.repositories.DeudaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;
@Service
public class DeudaService {

        private DeudaRepository deudaRepository;

        //Constructor
        public DeudaService(DeudaRepository deudaRepository){
            this.deudaRepository = deudaRepository;
        }

        //servicio GET
        public List<Deuda> getRepository(){
            return this.deudaRepository.findAll();
        }

        //servicio POST
        public Deuda createDeuda(Deuda deuda){
            return this.deudaRepository.save(deuda);
        }

        //servicio PUT
        public Deuda updateDeuda(Deuda deuda, Long id){
            Deuda deudaFromDb = deudaRepository
                    .findById(id)
                    .orElseThrow(RuntimeException::new);
            deudaFromDb.setDescripcion(deuda.getDescripcion());
            deudaFromDb.setFechaDeuda(deuda.getFechaDeuda());
            deudaFromDb.setMonto(deuda.getMonto());
            return deudaRepository.save(deudaFromDb);
        }

        //servicio DELETE
        public void deleteDeuda(Long id){
            Deuda deudaFromDb = deudaRepository
                    .findById(id)
                    .orElseThrow(RuntimeException::new);
            deudaRepository.delete(deudaFromDb);
        }

        //servicio ABONAR a deuda
        public Deuda abonarDeuda(Long id, BigDecimal pago){
            Deuda deuda = deudaRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Deuda no encontrada"));
            deuda.abonarPago(pago);
            return deudaRepository.save(deuda);
        }
}
