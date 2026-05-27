package com.tienda.servicio_videojuego.DTO;

import lombok.Data;

@Data
public class PagoDTO {

    private Integer idPago;
    private String estadoPago;
    private Integer idDetallePedido;// lo agregue porque esta relacionado al pago.
    private Double monto;// lo agregue para mostrar el monto que se obtiene 
                         // del precio del detalle pedido
}
