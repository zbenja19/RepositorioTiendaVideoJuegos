package com.tienda.servicio_videojuego.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tienda.servicio_videojuego.model.Biblioteca;

@Repository
public interface BibliotecaRepository extends JpaRepository<Biblioteca, Integer> {

}
