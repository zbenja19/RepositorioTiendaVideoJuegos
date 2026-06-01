package com.tienda.servicio_videojuego.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="ofertas")
public class Oferta {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idOferta;

    @NotNull(message = "El descuento es obligatorio")
    @Min(value = 0 , message = "El descuento no puede ser negativo")
    @Column(name = "descuento", nullable = false)
    private Double descuento;

    @NotNull(message = "La fecha es obligatoria")
    @Column(name="fecha_inicio", nullable=false)
    private LocalDate fechaInicio;

    @NotNull(message = "La fecha es obligatoria")
    @Column(name="fecha_termino", nullable=false)
    private LocalDate fechaTermino;
    
    @ManyToOne
    @JoinColumn(name="idVideoJuego")
    private VideoJuego videoJuego;
}
