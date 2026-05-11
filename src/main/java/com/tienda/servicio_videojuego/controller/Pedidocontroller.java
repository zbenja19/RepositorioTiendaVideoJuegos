package com.tienda.servicio_videojuego.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.servicio_videojuego.DTO.PedidoDTO;
import com.tienda.servicio_videojuego.model.Pedido;
import com.tienda.servicio_videojuego.service.Pedidoservice;

@RestController
@RequestMapping("/api/v1/Pedidos")
public class Pedidocontroller {
    @Autowired
    private Pedidoservice pedidoService;

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> obtenerTodos() {
        List<PedidoDTO> pedidos = pedidoService.obtenerTodos();
        if (pedidos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    @GetMapping("/cliente/{clienteId}/total")
    public ResponseEntity<Double> obtenerTotalCliente(@PathVariable Integer clienteId) {
    Double total = pedidoService.gastosTotalescliente(clienteId); 
    return new ResponseEntity<>(total, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> buscarPorId(@PathVariable Integer id) {
        try {
            PedidoDTO dto = pedidoService.buscarPorId(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Pedido> guardar(@RequestBody Pedido pedido) {
        try {
            Pedido guardado = pedidoService.guardar(pedido);
            return new ResponseEntity<>(guardado, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<Void> alternarEstado(@PathVariable Integer id) {
        try {
            pedidoService.alternarEstado(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        String resultado = pedidoService.eliminar(id);
        if (resultado.contains("eliminado")) {
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(resultado, HttpStatus.NOT_FOUND);
        }
    }
}
