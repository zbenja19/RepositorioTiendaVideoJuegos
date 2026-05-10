package com.tienda.servicio_videojuego.DTO;

import lombok.Data;

@Data
public class DetallePedidoDTO {
   private Integer idDetallePedido;
   private String idCarrito;
   private String idVideoJuego;
}
