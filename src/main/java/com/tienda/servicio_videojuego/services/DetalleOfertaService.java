package com.tienda.servicio_videojuego.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.servicio_videojuego.DTO.DetalleOfertaDTO;
import com.tienda.servicio_videojuego.model.detalleOfertas;
import com.tienda.servicio_videojuego.repository.DetalleOfertaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DetalleOfertaService {

    @Autowired
    private DetalleOfertaRepository detalleOfertaRepository;

    public List<DetalleOfertaDTO> obtenerTodos(){
        List<DetalleOfertaDTO>  detalleOfertas = new ArrayList<>();
        for (detalleOfertas detalleOferta : detalleOfertaRepository.findAll()){
            detalleOfertas.add(convertirADetalleOfertaDTO(detalleOferta));
        }
        return detalleOfertas;
    }

    public DetalleOfertaDTO buscarPorId(Integer idDetalleOferta){
        detalleOfertas detalleOferta = detalleOfertaRepository.findById(idDetalleOferta).orElseThrow(() -> new RuntimeException("DetalleOferta no encontrado"));
        return convertirADetalleOfertaDTO(detalleOferta);
    }

    public DetalleOfertaDTO guardar(detalleOfertas detalleOferta){
        detalleOfertas detalleOfertaGuardado = detalleOfertaRepository.save(detalleOferta);
        return convertirADetalleOfertaDTO(detalleOfertaGuardado);
    }

    private DetalleOfertaDTO convertirADetalleOfertaDTO(detalleOfertas detalle) {
        DetalleOfertaDTO dto = new DetalleOfertaDTO();
        
        dto.setIdDetalleOferta(detalle.getIdDetalleOferta());

        
        if (detalle.getIdDetalleOferta() != null) {
            dto.setIdOferta(detalle.getIdDetalleOferta().getIdDetalleOferta());
        } else {
            dto.setIdOferta(0);
        }
        
        if (detalle.getVideojuego() != null) {
            dto.setIdVideoJuegos(detalle.getVideojuego().getIdVideoJuego());
        } else {
            dto.setIdVideoJuegos(0);
        }

        return dto;
    }
}