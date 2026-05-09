package com.tienda.servicio_videojuego.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tienda.servicio_videojuego.model.VideoJuego;

@Repository
public interface VideojuegoRepository extends JpaRepository<VideoJuego,Integer> {

    @Query("SELECT v FROM VideoJuego v WHERE v.categoria.id = :idCategoria")
    List<VideoJuego> buscarVideoJuegos(@Param("idCategoria") Integer idCategoria);

    List<VideoJuego>findByNombreContaining(String nombre);
}
