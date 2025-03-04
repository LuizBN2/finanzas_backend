package com.luizbn2.finanzas.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class Gasto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private BigDecimal monto;
    @PastOrPresent(message = "La fecha de gasto no puede ser en el futuro.")
    @Column(name = "fecha_gasto")
    private LocalDateTime fechaGasto;
}
