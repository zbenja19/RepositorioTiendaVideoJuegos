package com.tienda.servicio_videojuego.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.servicio_videojuego.model.Pago;

public interface PagoRepository extends JpaRepository<Pago, Integer> {

}