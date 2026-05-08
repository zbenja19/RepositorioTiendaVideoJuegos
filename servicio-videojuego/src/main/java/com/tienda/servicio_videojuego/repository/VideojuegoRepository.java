package com.tienda.servicio_videojuego.repository;

import com.tienda.servicio_videojuego.model.VideoJuego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
<<<<<<< HEAD
public interface VideojuegoRepository extends JpaRepository<VideoJuego,Long> {
=======
public interface VideoJuegoRepository extends JpaRepository<VideoJuego,Integer> {
>>>>>>> rama-benja

}
