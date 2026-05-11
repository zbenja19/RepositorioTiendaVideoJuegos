package com.tienda.servicio_videojuego.DTO;

import lombok.Data;

@Data
public class VideoJuegoDTO {

    private Integer idVideoJuego;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer stock;
    private String nombreCategoria;// Cambie los atributos de Integer a String para
    private String nombreplataforma;// poder validar sin errores en el dto
    private String nombreProveedor;

}
