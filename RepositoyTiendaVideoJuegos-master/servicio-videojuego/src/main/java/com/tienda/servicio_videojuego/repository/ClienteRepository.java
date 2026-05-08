package com.tienda.servicio_videojuego.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tienda.servicio_videojuego.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer>{

}
