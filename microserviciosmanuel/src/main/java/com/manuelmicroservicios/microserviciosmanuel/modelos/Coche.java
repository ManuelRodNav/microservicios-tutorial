package com.manuelmicroservicios.microserviciosmanuel.modelos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Coche {
    private String marca;
    private String modelo;
    private int usuarioId;
    
}
