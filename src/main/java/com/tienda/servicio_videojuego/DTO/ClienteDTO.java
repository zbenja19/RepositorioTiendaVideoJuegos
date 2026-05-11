package com.tienda.servicio_videojuego.DTO;

import java.util.List;
import lombok.Data;

@Data
public class ClienteDTO {

  private Integer id;
  private String nombre;
  private String email;
  private String telefono;
  private String nombrebiblioteca;
  private List<String> nombrespedidos;

}
