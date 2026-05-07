package com.tienda.servicio_videojuego.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="detalle_ofertas")
public class detalleOfertas {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idDetalleOferta;

    @ManyToMany
    @JoinColumn(name= "idOferta")
    private Oferta idOferta;

    @ManyToMany
    @JoinColumn(name= "idVideoJuego")
    private VideoJuego videoJuego;

}