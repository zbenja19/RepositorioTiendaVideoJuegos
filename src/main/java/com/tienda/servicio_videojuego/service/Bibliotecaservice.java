package com.tienda.servicio_videojuego.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.servicio_videojuego.model.biblioteca;
import com.tienda.servicio_videojuego.repository.BibliotecaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class Bibliotecaservice {
    @Autowired
    private BibliotecaRepository bibliotecaRepository;

    public List<biblioteca> obtenerTodas() {
        return bibliotecaRepository.findAll();
    }

    public biblioteca buscarPorId(Integer id) {
        return bibliotecaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("La biblioteca con el Id " + id + " no existe mi amigo"));
    }

    public biblioteca guardar(biblioteca biblioteca) {
        return bibliotecaRepository.save(biblioteca);
    }

    public String eliminar(Integer id) {
        try {
            biblioteca biblio = bibliotecaRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("La biblioteca con el Id " + id + " no existe mi amigo."));
            
            if (biblio.getVideojuegos() != null && !biblio.getVideojuegos().isEmpty()) {
                return "No se puede eliminar la biblioteca Id " + id + " porque tiene juegos asociados :).";
            }

            bibliotecaRepository.delete(biblio);
            return "Biblioteca eliminada exitosamente.";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    public biblioteca actualizar(Integer id, biblioteca datosNuevos) {
        biblioteca biblioExistente = bibliotecaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Biblioteca no encontrada para actualizar."));

        if (datosNuevos.getFechaAgregada() != null) {
            biblioExistente.setFechaAgregada(datosNuevos.getFechaAgregada());
        }

        return bibliotecaRepository.save(biblioExistente);
    }
}



