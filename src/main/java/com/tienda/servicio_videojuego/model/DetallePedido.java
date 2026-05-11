package com.tienda.servicio_videojuego.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="detalle_pedido")
public class DetallePedido {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idDetallePedido;

    @ManyToMany
    @JoinColumn(name= "idCarro")
    private Carro carro;

    @ManyToMany
    @JoinColumn(name= "idVideoJuego")
    private VideoJuego VideoJuego;
}
