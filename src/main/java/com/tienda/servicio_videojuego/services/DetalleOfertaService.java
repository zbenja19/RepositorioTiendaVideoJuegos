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

    private DetalleOfertaDTO convertirADetalleOfertaDTO(detalleOfertas detalleOferta){
        DetalleOfertaDTO detalleOfertaDTO = new DetalleOfertaDTO();
        detalleOfertaDTO.setIdDetalleOferta(detalleOferta.getIdDetalleOferta());
        detalleOfertaDTO.setIdOferta(detalleOferta.getIdOferta());
        detalleOfertaDTO.setIdVideoJuego(detalleOferta.getIdVideojuego());
        detalleOfertaDTO.setPrecio(detalleOferta.getPrecio());
        if (detalleOferta.getIdOferta() != null){
            detalleOfertaDTO.setIdOferta(detalleOferta.getIdOferta());
        }else{
            detalleOfertaDTO.setIdOferta("Desconocida");
        }
        return detalleOfertaDTO;
    }
}