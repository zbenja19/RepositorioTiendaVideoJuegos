package com.tienda.servicio_videojuego.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tienda.servicio_videojuego.model.detalleOfertas;

public interface DetalleOfertaRepository extends JpaRepository <detalleOfertas, Integer>{

    List<detalleOfertas> findByClase(String clase);

    @Query("SELECT d FROM Oferta d WHERE d.oferta.id = :idOferta ")
    List<detalleOfertas> buscarOfertas(@Param("idoferta") Long  idOferta);
}