package com.tienda.servicio_videojuego.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tienda.servicio_videojuego.model.Plataforma;

@Repository
public interface PlataformaRepository extends JpaRepository<Plataforma,Integer> {



}
