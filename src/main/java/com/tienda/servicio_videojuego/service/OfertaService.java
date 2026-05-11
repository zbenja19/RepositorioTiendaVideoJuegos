package com.tienda.servicio_videojuego.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.servicio_videojuego.DTO.OfertaDTO;
import com.tienda.servicio_videojuego.model.Oferta;
import com.tienda.servicio_videojuego.repository.OfertaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OfertaService {

    @Autowired
    private OfertaRepository ofertaRepository;

    public List<OfertaDTO> obtenerTodos(){
        List<OfertaDTO> ofertas = new ArrayList<>();
        for (Oferta oferta : ofertaRepository.findAll()){
            ofertas.add(convertirAOfertaDTO(oferta));
        }
        return ofertas;
    }

    public OfertaDTO buscarPorId(Integer idOferta){
        Oferta oferta = ofertaRepository.findById(idOferta).orElseThrow(() -> new RuntimeException("Oferta no encontrada"));
        return convertirAOfertaDTO(oferta);
    }

    public OfertaDTO guardar(Oferta oferta){
        Oferta ofertaGuardada = ofertaRepository.save(oferta);
        return convertirAOfertaDTO(ofertaGuardada);
    }

    private OfertaDTO convertirAOfertaDTO(Oferta oferta) {
    OfertaDTO dto = new OfertaDTO();
    dto.setIdOferta(oferta.getIdOferta());
    dto.setFechaInicio(oferta.getFechaInicio());
    dto.setFechaTermino(oferta.getFechaTermino());

    
    if (oferta.getVideojuego() != null) {
        dto.setIdVideoJuego(oferta.getVideojuego().getIdVideoJuego());
    } else {
        dto.setIdVideoJuego(0);
    }

    return dto;
}

}
