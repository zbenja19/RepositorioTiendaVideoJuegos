package com.tienda.servicio_videojuego.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tienda.servicio_videojuego.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository <Pedido,Integer>{

    List<Pedido> findByEstado(Boolean estado);

    @Query("SELECT SUM(p.total) FROM Pedido p WHERE p.cliente.id = :clienteId")
    Double moneycalculeitor(@Param("clienteId") Integer clienteId);
}
