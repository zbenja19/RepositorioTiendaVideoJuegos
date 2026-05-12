package com.tienda.servicio_videojuego.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tienda.servicio_videojuego.model.DetallePedido;

@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Integer> {

    List<DetallePedido> findByClase(String clase);

    @Query("SELECT p FROM DetallePedido WHERE p.idDetallePedido = :idDetallePedido")
    List<DetallePedido> buscarPedidos(@Param("idDetallePedido") Long idDetallePedido);
}
