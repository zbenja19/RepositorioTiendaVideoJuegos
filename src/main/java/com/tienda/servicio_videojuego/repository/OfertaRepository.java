package com.tienda.servicio_videojuego.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.tienda.servicio_videojuego.model.Oferta;

public interface OfertaRepository extends JpaRepository<Oferta, Integer>{
    
    List<Oferta> findByClase(String clase);

    @Query("SELECT o FROM o WHERE o.idOferta = :idOferta")
    Oferta findByIdOferta(@Param("idOferta") Integer idOferta);
}