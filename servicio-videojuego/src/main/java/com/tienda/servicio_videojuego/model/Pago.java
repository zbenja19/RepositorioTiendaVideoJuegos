package com.tienda.servicio_videojuego.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="pago")
public class Pago {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idPago;

    @NotBlank(message="El estado del pago es obligatorio")
    @Size(min=10, max=20,message="El estado del pago debe ser de entre 10 y 20 caracteres")
    @Column(name="estadoPago", nullable=false)
    private String estadoPago;

}