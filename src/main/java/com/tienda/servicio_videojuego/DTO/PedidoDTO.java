package com.tienda.servicio_videojuego.DTO;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;


@Data
public class PedidoDTO {

  private Integer id;
  private LocalDate fechaAgregada;
  private Integer total;
  private Boolean estado;
  private String nombreCliente;
  private List<String> nombresVideojuegos;



}