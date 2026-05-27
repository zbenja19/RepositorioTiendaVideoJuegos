package com.tienda.servicio_videojuego.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.servicio_videojuego.DTO.PedidoDTO;
import com.tienda.servicio_videojuego.model.DetallePedido;
import com.tienda.servicio_videojuego.model.Pedido;
import com.tienda.servicio_videojuego.repository.PedidoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public List<PedidoDTO> obtenerTodos() {
        return pedidoRepository.findAll().stream()
                 .map(this::convertirADTO)
                 .toList();
    }

    public PedidoDTO buscarPorId(Integer id) {
        Pedido pedido = pedidoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("¡Pedido no encontrado!"));
        return convertirADTO(pedido);
    }

    public Pedido guardar(Pedido pedido) {
        if (pedido.getEstado() == null) {
            pedido.setEstado(false); 
        }
        return pedidoRepository.save(pedido);
    }
    public List<PedidoDTO> buscarPorEstado(Boolean estado) {
        return pedidoRepository.findByEstado(estado).stream()
                .map(this::convertirADTO)
                .toList();
    }

    public Double gastosTotalescliente(Integer clienteId) {
        Double total = pedidoRepository.moneycalculeitor(clienteId);
        return (total != null) ? total : 0.0;
    }

    
    public void alternarEstado(Integer id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el pedido para cambiar estado"));
        
        pedido.setEstado(!pedido.getEstado());
        pedidoRepository.save(pedido);
    }

    public String eliminar(Integer id) {
        try {
            Pedido pedido = pedidoRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("¡Error! El pedido con ID " + id + " no existe."));
            pedidoRepository.delete(pedido);
            return "El pedido con ID " + id + " ha sido eliminado.";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    private PedidoDTO convertirADTO(Pedido pedido) {
        PedidoDTO dto = new PedidoDTO();
        dto.setId(pedido.getId());
        dto.setFechaAgregada(pedido.getFechaAgregada());
        dto.setTotal(pedido.getTotal());
        dto.setEstado(pedido.getEstado());

        if (pedido.getCliente() != null) {
            dto.setNombreCliente(pedido.getCliente().getNombre());
        } else {
            dto.setNombreCliente("Sin cliente asignado");
        }
        List<String> nombresgames = new ArrayList<>();
        if (pedido.getDetallesPedido() != null) {
            for (DetallePedido detalleP : pedido.getDetallesPedido()) {
                if (detalleP.getVideoJuego() != null){
                    nombresgames.add(detalleP.getVideoJuego().getNombre());
                } 
            }
        }
        dto.setNombresVideojuegos(nombresgames);
        return dto;
    }
}
