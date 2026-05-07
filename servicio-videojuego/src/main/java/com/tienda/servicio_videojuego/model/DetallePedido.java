package com.tienda.servicio_videojuego.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="detalle_pedido")
public class DetallePedido {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idDetallePedido;

    @ManyToMany
    @JoinColumn(name= "idCarrito")
    private Carrito carrito;

    @ManyToMany
    @JoinColumn(name= "idVideoJuego")
    private VideoJuego videoJuego;
}
