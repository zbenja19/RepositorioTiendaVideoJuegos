package com.tienda.servicio_videojuego.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tienda.servicio_videojuego.model.DetalleOfertas;

public interface DetalleOfertaRepository extends JpaRepository <DetalleOfertas, Integer>{

    List<DetalleOfertas> findByClase(String clase);

    @Query("SELECT d FROM Oferta d WHERE d.oferta.id = :idOferta ")
    List<DetalleOfertas> buscarOfertas(@Param("idOferta") Long  idOferta);
}