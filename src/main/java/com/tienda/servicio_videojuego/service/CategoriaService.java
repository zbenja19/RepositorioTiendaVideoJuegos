package com.tienda.servicio_videojuego.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.servicio_videojuego.DTO.CategoriaDTO;
import com.tienda.servicio_videojuego.DTO.VideoJuegoDTO;
import com.tienda.servicio_videojuego.model.Categoria;
import com.tienda.servicio_videojuego.model.Proveedor;
import com.tienda.servicio_videojuego.model.VideoJuego;
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
    public List <CategoriaDTO> listarTodos(){
        return categoriaRepository.findAll().stream()
        .map(this::convertirADTO).toList();
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

    public CategoriaDTO buscarPorId(Integer id){
        Categoria categoria = categoriaRepository.findById(id)
           .orElseThrow(() -> new RuntimeException("¡La categoria no esta registrado!"));
        return convertirADTO(categoria);
    }

    public CategoriaDTO actualizar(Integer id,Categoria categoriaNva){
        Categoria categoriaDTO = categoriaRepository.findById(id)
         .orElseThrow(() -> new RuntimeException("No encontrada"));
         if(categoriaNva.getNombre() != null){
            categoriaDTO.setNombre(categoriaDTO.getNombre());
         }
         if (categoriaNva.getDescripcion() != null){
            categoriaDTO.setDescripcion(categoriaDTO.getDescripcion());
         }
         return convertirADTO(categoriaDTO);
    }

    private CategoriaDTO convertirADTO(Categoria categoria) {
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        
        categoriaDTO.setIdCategoria(categoria.getIdCategoria());
        categoriaDTO.setNombre(categoria.getNombre());
        categoriaDTO.setDescripcion(categoria.getDescripcion());

        if (categoriaDTO.getIdCategoria() != null) {
            categoriaDTO.setIdCategoria(categoria.getIdCategoria());
        } else {
            categoriaDTO.setIdCategoria(null);
        }
        return categoriaDTO;
  
    }
}