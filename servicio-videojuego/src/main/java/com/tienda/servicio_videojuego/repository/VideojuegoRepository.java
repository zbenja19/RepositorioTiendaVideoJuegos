package com.tienda.servicio_videojuego.repository;

import com.tienda.servicio_videojuego.model.VideoJuego;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VideojuegoRepository extends JpaRepository<VideoJuego,Integer> {

    List<VideoJuego> findByClase(String clase);

    @Query("SELECT v FROM VideoJuego v WHERE v.categoria.id = :idCategoria")
    List<VideoJuego> buscarVeteranos(@Param("idCategoria") Integer idCategoria);
}
