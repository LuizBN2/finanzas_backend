package com.luizbn2.finanzas.repositories;

import com.luizbn2.finanzas.entities.Deuda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeudaRepository extends JpaRepository<Deuda, Long> {

}
