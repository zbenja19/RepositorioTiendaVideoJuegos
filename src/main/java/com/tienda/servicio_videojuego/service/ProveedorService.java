package com.tienda.servicio_videojuego.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tienda.servicio_videojuego.model.Proveedor;
import com.tienda.servicio_videojuego.repository.ProveedorRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    //Metodos

    public List <Proveedor> listar(){
        return proveedorRepository.findAll();
    }

    public Proveedor guardar(Proveedor proveedor){
        return proveedorRepository.save(proveedor);       
    }


    public String eliminar(Integer id){

        Proveedor proveedor = proveedorRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No encontrado"));
    
        proveedorRepository.delete(proveedor);
        return "Proveedor"+proveedor.getNombre()+"Eliminado exitosamente";
    }

    public Proveedor buscarPorId(Integer id){
        return proveedorRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
    }

    public Proveedor actualizarProveedor(Integer id,Proveedor nvoProveedor){
        Proveedor proveedor = proveedorRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("¡El Proveedor no esta registrado!"));
        if(nvoProveedor.getNombre() != null){
            proveedor.setNombre(proveedor.getNombre());
        }
        if(nvoProveedor.getEmail() != null){
            proveedor.setEmail(proveedor.getEmail());
        }
        if(nvoProveedor.getTelefono() != null){
            proveedor.setTelefono(nvoProveedor.getTelefono());
        }
        return proveedorRepository.save(proveedor);
    }





}
