package com.tienda.servicio_videojuego.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tienda.servicio_videojuego.DTO.ClienteDTO;
import com.tienda.servicio_videojuego.model.Cliente;
import com.tienda.servicio_videojuego.service.ClienteService;

@RestController
@RequestMapping("/api/v1/pedidos")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteservice;

    @GetMapping
    public List<ClienteDTO> listarTodos() {
        return clienteservice.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> obtenerPorId(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(clienteservice.buscarPorId(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteservice.guardarCliente(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizar(@PathVariable Integer id, @RequestBody Cliente datosNuevos) {
        try {
            return ResponseEntity.ok(clienteservice.actualizarCliente(id, datosNuevos));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        String mensaje = clienteservice.eliminar(id);
        if (mensaje.contains("Error")) {
            return ResponseEntity.badRequest().body(mensaje);
        }
        return ResponseEntity.ok(mensaje);
    }
}


