package com.tienda.servicio_videojuego.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.servicio_videojuego.DTO.DetallePedidoDTO;
import com.tienda.servicio_videojuego.model.DetallePedido;
import com.tienda.servicio_videojuego.services.DetallePedidoService;

@RestController
@RequestMapping("/api/v1/detalle-pedido")
public class DetallePedidoController {

    @Autowired
    private DetallePedidoService detallePedidoService;

    @GetMapping
    public ResponseEntity<?> todosLosPedidos(){
        List<DetallePedidoDTO> detallePedidos = detallePedidoService.obtenerTodos();
        if(!detallePedidos.isEmpty()){
            return new ResponseEntity<>(detallePedidos, HttpStatus.OK);
    }
        return new ResponseEntity<>("No se encontraron detalles de pedidos", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(Integer idDetallePedido){
        try {
            DetallePedidoDTO detallePedidoDTO = detallePedidoService.buscarPorId(idDetallePedido);
            return new ResponseEntity<>(detallePedidoDTO, HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<DetallePedidoDTO> agregarDetallePedido(@RequestBody DetallePedido detallePedido){
        try{
            DetallePedidoDTO guardado = detallePedidoService.guardar(detallePedido);
            return new ResponseEntity<>(guardado, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
   
}