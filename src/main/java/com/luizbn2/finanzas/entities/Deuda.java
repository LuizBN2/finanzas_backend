package com.luizbn2.finanzas.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class Deuda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private BigDecimal monto;
    @PastOrPresent(message = "La fecha de deuda no puede ser en el futuro.")
    @Column(name = "fecha_deuda")
    private LocalDateTime fechaDeuda;
    private boolean abonada;
    @Column(name = "fecha_pago")
    private LocalDateTime fechaPago;
    private BigDecimal abonado = BigDecimal.ZERO;

    //Método para abonar pago
    public void abonarPago(BigDecimal pago){
        this.abonado = this.abonado.add(pago);
        if (this.abonado.compareTo(this.monto) >= 0){
            this.abonada = true;
            this.fechaPago = LocalDateTime.now(); // Asignamos la fecha de pago
        }
    }
}
