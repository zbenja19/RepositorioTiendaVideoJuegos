package com.tienda.servicio_videojuego.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.servicio_videojuego.DTO.ClienteDTO;
import com.tienda.servicio_videojuego.model.Cliente;
import com.tienda.servicio_videojuego.model.Pedido;
import com.tienda.servicio_videojuego.repository.ClienteRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteDTO> obtenerTodos() {
        return clienteRepository.findAll().stream()
                 .map(this::convertirADTO)
                 .toList();
    }

    public ClienteDTO buscarPorId(Integer id) {
        Cliente cliente = clienteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("¡Cliente no encontrado!"));
        return convertirADTO(cliente);
    }

    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public String eliminar(Integer id) {
        try {
            Cliente cliente = clienteRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("¡Error! El cliente con ID " + id + " no existe."));
            clienteRepository.delete(cliente);
            return "El cliente '" + cliente.getNombre() + "' ha sido eliminado del sistema.";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    public Cliente actualizarCliente(Integer id, Cliente datosNuevos) {
        Cliente clienteExistente = clienteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("¡El cliente no existe!"));
        
        if(datosNuevos.getNombre() != null) {
            clienteExistente.setNombre(datosNuevos.getNombre());
        }
        if(datosNuevos.getEmail() != null) {
            clienteExistente.setEmail(datosNuevos.getEmail());
        }
        if(datosNuevos.getTelefono() != null) {
            clienteExistente.setTelefono(datosNuevos.getTelefono());
        }
        if(datosNuevos.getContrasena() != null) {
            clienteExistente.setContrasena(datosNuevos.getContrasena());
        }
        
        return clienteRepository.save(clienteExistente);
    }

    private ClienteDTO convertirADTO(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setNombre(cliente.getNombre());
        dto.setEmail(cliente.getEmail());
        dto.setTelefono(cliente.getTelefono());

        List<String> infoPedidos = new ArrayList<>();
        if (cliente.getPedidos() != null) { 
            for (Pedido p : cliente.getPedidos()) {
                infoPedidos.add("Pedido #" + p.getId());
            }
        }
        dto.setNombrespedidos(infoPedidos);
        return dto;
    }
}
