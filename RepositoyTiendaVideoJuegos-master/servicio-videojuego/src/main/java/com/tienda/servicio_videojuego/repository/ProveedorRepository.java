package com.tienda.servicio_videojuego.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tienda.servicio_videojuego.model.Proveedor;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor,Integer>{

    
}
