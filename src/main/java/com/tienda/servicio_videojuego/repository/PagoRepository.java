package com.tienda.servicio_videojuego.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tienda.servicio_videojuego.model.Pago;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer> {

    //cree esta query para crear el metodo total de pagos registrados
    @Query("SELECT SUM(d.precio) FROM Pago p JOIN p.detallePedido d") 
    Double calcularTotalPagos();


    //cree esta query para buscar pagos segun su estado
    @Query("SELECT p FROM Pago p WHERE p.estadoPago = :estadoPago")
    List<Pago> buscarPagosPorEstado(@Param("estadoPago") String estadoPago);
}