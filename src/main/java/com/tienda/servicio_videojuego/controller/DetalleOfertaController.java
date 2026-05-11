package com.tienda.servicio_videojuego.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.servicio_videojuego.DTO.DetalleOfertaDTO;
import com.tienda.servicio_videojuego.service.DetalleOfertaService;

@RestController
@RequestMapping("/api/v1/detalle-oferta")
public class DetalleOfertaController {
    
    @Autowired
    private DetalleOfertaService detalleOfertaService;

    @GetMapping
    public ResponseEntity<?> todosLosDetallesOfertas(){
        List<DetalleOfertaDTO> detalleOfertas = detalleOfertaService.obtenerTodos();
        if(!detalleOfertas.isEmpty()){
            return new ResponseEntity<>(detalleOfertas, HttpStatus.OK);
    }
        return new ResponseEntity<>("No se encontraron detalles de ofertas", HttpStatus.NOT_FOUND);
    }
}
