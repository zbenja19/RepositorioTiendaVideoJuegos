package com.tienda.servicio_videojuego.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.servicio_videojuego.model.Categoria;
import com.tienda.servicio_videojuego.repository.CategoriaRepository;
import com.tienda.servicio_videojuego.repository.VideojuegoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private VideojuegoRepository videojuegoRepository;

    //METODOS
    public List <Categoria> listar(){
        return categoriaRepository.findAll();
    }

    public Categoria guardar(Categoria categoria){
        return categoriaRepository.save(categoria);       
    }

    public String eliminar(Integer id){

        Categoria categoria = categoriaRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No encontrada"));
        
        if (!videojuegoRepository.buscarVideoJuegos(id).isEmpty()){
            throw new RuntimeException("La categoria no se puede eliminar, tiene juegos asociados");
        }
        categoriaRepository.delete(categoria);
        return "Categoria"+categoria.getNombre()+"Eliminada exitosamente";
    }

    public Categoria buscarPorId(Integer id){
        return categoriaRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
    }

    public Categoria actualizar(Integer id,Categoria categoria){
        Categoria categoria = categoriaRepository.findById(id)
         .orElseThrow(() -> new RuntimeException("No encontrada"));
         if(categoria.getNombre() != null){
            categoria.setNombre(categoria.ge);
         }

    }

}
