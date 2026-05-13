package com.tienda.servicio_videojuego.DTO;

import lombok.Data;

@Data
public class DetallePedidoDTO {
   
   private Integer idDetallePedido;
   private Double precio;
   private Integer idPedido;
   private Integer idVideoJuego;
}
