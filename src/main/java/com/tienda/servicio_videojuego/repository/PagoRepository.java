package com.tienda.servicio_videojuego.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tienda.servicio_videojuego.model.Pago;

public interface PagoRepository extends JpaRepository<Pago, Integer> {

    List<Pago> findByClase(String clase);

    @Query("SELECT p FROM p WHERE p.idPago = :idPago")
    Pago findByIdPago(@Param("idPago") Integer idPago);
}