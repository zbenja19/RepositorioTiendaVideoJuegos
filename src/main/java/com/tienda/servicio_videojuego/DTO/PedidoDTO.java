package com.tienda.servicio_videojuego.DTO;

import java.util.List;
import lombok.Data;

@Data

public class PedidoDTO {

  private Integer id;
  private String fechaAgregada;
  private Integer total;
  private Boolean estado;
  private String nombreCliente;
  private List<String> nombresVideojuegos;



}