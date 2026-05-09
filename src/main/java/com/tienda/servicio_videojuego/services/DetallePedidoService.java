package com.tienda.servicio_videojuego.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.servicio_videojuego.DTO.DetallePedidoDTO;
import com.tienda.servicio_videojuego.model.DetallePedido;
import com.tienda.servicio_videojuego.repository.DetallePedidoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DetallePedidoService {

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    public List<DetallePedidoDTO> obtenerTodos(){
        List<DetallePedidoDTO> detallePedidos = new ArrayList<>();
        for (DetallePedido detallePedido : detallePedidoRepository.findAll()){
            detallePedidos.add(convertirADetallePedidoDTO(detallePedido));
        }
        return detallePedidos;
    }

    public DetallePedidoDTO buscarPorId(Integer idDetallePedido){
        DetallePedido detallePedido = detallePedidoRepository.findById(idDetallePedido).orElseThrow(() -> new RuntimeException("DetallePedido no encontrado"));
        return convertirADetallePedidoDTO(detallePedido);
    }

    public DetallePedidoDTO guardar(DetallePedido detallePedido){
        DetallePedido detallePedidoGuardado = detallePedidoRepository.save(detallePedido);
        return convertirADetallePedidoDTO(detallePedidoGuardado);
    }

    private DetallePedidoDTO convertirADetallePedidoDTO(DetallePedido detallePedido) {
    DetallePedidoDTO detallePedidoDTO = new DetallePedidoDTO();

    detallePedidoDTO.setIdDetallePedido(detallePedido.getIdDetallePedido());

    if (detallePedido.getVideoJuego() != null) {
        detallePedidoDTO.setIdVideoJuego(detallePedido.getVideoJuego().getIdVideoJuego());
    } else {
        
        detallePedidoDTO.setIdVideoJuego(0); 
        }
    return detallePedidoDTO;
    }
}