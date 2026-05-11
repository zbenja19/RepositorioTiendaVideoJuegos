package com.tienda.servicio_videojuego.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.servicio_videojuego.model.biblioteca;
import com.tienda.servicio_videojuego.service.Bibliotecaservice;

@RestController
@RequestMapping("/api/v1/bibliotecas")
public class Bibliotecacontroller {
    @Autowired
    private Bibliotecaservice bibliotecaService;

    @GetMapping
    public ResponseEntity<List<biblioteca>> obtenerTodas() {
        List<biblioteca> bibliotecas = bibliotecaService.obtenerTodas();
        if (bibliotecas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bibliotecas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<biblioteca> buscarPorId(@PathVariable Integer id) {
        try {
            biblioteca biblio = bibliotecaService.buscarPorId(id);
            return new ResponseEntity<>(biblio, HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<biblioteca> guardar(@RequestBody biblioteca biblioteca) {
        try {
            biblioteca guardada = bibliotecaService.guardar(biblioteca);
            return new ResponseEntity<>(guardada, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<biblioteca> actualizar(@PathVariable Integer id, @RequestBody biblioteca datosNuevos) {
        try {
            biblioteca actualizada = bibliotecaService.actualizar(id, datosNuevos);
            return new ResponseEntity<>(actualizada, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        String resultado = bibliotecaService.eliminar(id);
        if (resultado.contains("exitosamente")) {
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(resultado, HttpStatus.BAD_REQUEST);
        }
    }
}
