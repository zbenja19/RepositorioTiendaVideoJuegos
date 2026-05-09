package com.tienda.servicio_videojuego.DTO;

import lombok.Data;

@Data
public class OfertaDTO {

    private Integer idOferta;
    private String fechaInicio;
    private String fechaTermino;
    private String idVideoJuego;
}
