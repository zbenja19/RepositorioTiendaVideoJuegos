package com.tienda.servicio_videojuego.DTO;

import java.sql.Date;

import lombok.Data;

@Data
public class OfertaDTO {

    private Integer idOferta;
    private Double descuento;
    private Date fechaInicio;
    private Date fechaTermino;
    private Integer idVideoJuego;
}
