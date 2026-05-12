package com.tienda.servicio_videojuego.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tienda.servicio_videojuego.DTO.PagoDTO;
import com.tienda.servicio_videojuego.model.Pago;
import com.tienda.servicio_videojuego.service.PagoService;


@RestController
@RequestMapping("/api/v1/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @GetMapping
    public ResponseEntity<?> todosLosPagos(){
        List<PagoDTO> pagos = pagoService.obtenerTodos();
        if(!pagos.isEmpty()){
            return new ResponseEntity<>(pagos, HttpStatus.OK);
    }
        return new ResponseEntity<>("No se encontraron pagos", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer idPago){
        try {
            PagoDTO pagoDTO = pagoService.buscarPorId(idPago);
            return new ResponseEntity<>(pagoDTO, HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<PagoDTO> agregarPago(@RequestBody Pago pago){
        try{
            PagoDTO guardado = pagoService.guardar(pago);
            return new ResponseEntity<>(guardado, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}