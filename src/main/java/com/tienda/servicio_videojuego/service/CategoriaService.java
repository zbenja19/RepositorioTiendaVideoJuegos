package com.tienda.servicio_videojuego.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.servicio_videojuego.model.Categoria;
import com.tienda.servicio_videojuego.repository.CategoriaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List <Categoria> listas (){
        return categoriaRepository.findAll();
    }

    public Categoria guardar (Categoria categoria){
        return categoriaRepository.save(categoria);       
    }

}
