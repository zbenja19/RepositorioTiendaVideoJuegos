package com.tienda.servicio_videojuego.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="oferta")
public class Oferta {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idOferta;

    @NotBlank(message="La fecha de inicio de la oferta de los juegos es obligatoria")
    @Column(name="fecha_inicio", nullable=false)
    private Date fechaInicio;

    @NotBlank(message="La fecha de término de la oferta de los juegos es obligatoria")
    @Column(name="fecha_termino", nullable=false)
    private Date fechaTermino;
    
    @ManyToMany
    @JoinColumn(name="idVideoJuego")
    private VideoJuego VideoJuego;
}
