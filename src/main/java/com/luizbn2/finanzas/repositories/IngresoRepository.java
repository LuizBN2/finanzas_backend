package com.luizbn2.finanzas.repositories;

import com.luizbn2.finanzas.entities.Ingreso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngresoRepository extends JpaRepository<Ingreso, Long> {
}
