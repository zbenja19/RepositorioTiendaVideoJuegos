package com.tienda.servicio_videojuego.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tienda.servicio_videojuego.DTO.VideoJuegoDTO;
import com.tienda.servicio_videojuego.model.VideoJuego;
import com.tienda.servicio_videojuego.repository.VideojuegoRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class VideoJuegoService {

    @Autowired
    private VideojuegoRepository videojuegoRepository;

    // Metodos
    public List <VideoJuegoDTO> listarTodos(){
        return videojuegoRepository.findAll().stream()
                        .map(this::convertirADTO)
                        .toList();
    }

    public VideoJuego guardar(VideoJuego videoJuego){
        return videojuegoRepository.save(videoJuego);       
    }

    public String eliminar(Integer id){
        VideoJuego videoJ = videojuegoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("VideoJuego no encontrado"));
    
        videojuegoRepository.delete(videoJ);
        return "Videojuego"+  videoJ.getNombre()+"Eliminado exitosamente";
    } 

    public VideoJuego buscarPorId(Integer id){
        return videojuegoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Videojuego no encontrado"));
    }

    public List<VideoJuego> buscarPornombre(String nombre){
        List<VideoJuego> juegos = videojuegoRepository.findByNombreContaining(nombre);

        if(juegos.isEmpty()){
            throw new RuntimeException("No se encontraron videosjuego asociados al nombre"+ nombre);
        }
        return juegos;
    }

    public VideoJuego actualizaVideoJuego(Integer id,VideoJuego nvoVideoJuego){
        VideoJuego videoj = videojuegoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("¡El Videojuego no esta registrado!"));
        if(nvoVideoJuego.getNombre() != null){
            videoj.setNombre(nvoVideoJuego.getNombre());
        }
        if(nvoVideoJuego.getDescripcion() != null){
            videoj.setDescripcion(nvoVideoJuego.getDescripcion());
        }
        if(nvoVideoJuego.getPrecio() != null){
            videoj.setPrecio(nvoVideoJuego.getPrecio());
        }
        if(nvoVideoJuego.getStock() != null){
            videoj.setStock(nvoVideoJuego.getStock());
        }
        if(nvoVideoJuego.getCategoria() != null){
            videoj.setCategoria(nvoVideoJuego.getCategoria());
        }
        if(nvoVideoJuego.getPlataforma() != null){
            videoj.setPlataforma(nvoVideoJuego.getPlataforma());
        }
        if(nvoVideoJuego.getProveedor() != null){
            videoj.setProveedor(nvoVideoJuego.getProveedor());
        }
        return videojuegoRepository.save(videoj);
    }

    private VideoJuegoDTO convertirADTO(VideoJuego videoJuego) {
        VideoJuegoDTO videoJuegoDTO = new VideoJuegoDTO();
        
        videoJuegoDTO.setIdVideoJuego(videoJuego.getIdVideoJuego());
        videoJuegoDTO.setNombre(videoJuego.getNombre());
        videoJuegoDTO.setDescripcion(videoJuego.getDescripcion());
        videoJuegoDTO.setPrecio(videoJuego.getPrecio());
        videoJuegoDTO.setStock(videoJuego.getStock());
        videoJuegoDTO.setPrecio(videoJuego.getPrecio());

        if (videoJuego.getCategoria() != null) {
            videoJuegoDTO.setNombreCategoria(videoJuego.getCategoria().getNombre());
        } else {
            videoJuegoDTO.setNombreCategoria(null);
        }
        if(videoJuego.getPlataforma() != null){
            videoJuegoDTO.setNombreplataforma(videoJuego.getPlataforma().getNombre());
        }

        return videoJuegoDTO;

    }

}
