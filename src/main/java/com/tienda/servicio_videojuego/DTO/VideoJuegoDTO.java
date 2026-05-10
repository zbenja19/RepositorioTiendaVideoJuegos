package com.tienda.servicio_videojuego.DTO;

import com.tienda.servicio_videojuego.model.Categoria;
import com.tienda.servicio_videojuego.model.Plataforma;
import com.tienda.servicio_videojuego.model.Proveedor;
import lombok.Data;

@Data
public class VideoJuegoDTO {

    private Integer id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer stock;
    private Categoria categoria;
    private Plataforma plataforma;
    private Proveedor proveedor;

}
