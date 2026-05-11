package com.tienda.servicio_videojuego.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.servicio_videojuego.model.Plataforma;
import com.tienda.servicio_videojuego.repository.PlataformaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class Plataformaservice {
    @Autowired
    private PlataformaRepository plataformaRepository;

    public List<Plataforma> obtenerTodas() {
        return plataformaRepository.findAll();
    }

    public Plataforma buscarPorId(Integer id) {
        return plataformaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("¡Plataforma no encontrada!"));
    }

    public Plataforma guardar(Plataforma plataforma) {
        return plataformaRepository.save(plataforma);
    }

    public String eliminar(Integer id) {
        try {
            Plataforma plataforma = plataformaRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("¡Error! La plataforma con ID " + id + " no existe."));
            plataformaRepository.delete(plataforma);
            return "La plataforma '" + plataforma.getNombre() + "' ha sido eliminada.";
        } catch (RuntimeException e) {
            return e.getMessage();
        }

    }
}

