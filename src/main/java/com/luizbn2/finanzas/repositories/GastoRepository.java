package com.luizbn2.finanzas.repositories;

import com.luizbn2.finanzas.entities.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GastoRepository extends JpaRepository<Gasto, Long> {
}
