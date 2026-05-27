package com.tienda.servicio_videojuego.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.servicio_videojuego.DTO.PagoDTO;
import com.tienda.servicio_videojuego.model.Pago;
import com.tienda.servicio_videojuego.repository.PagoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    public List<PagoDTO> obtenerTodos(){
        List<PagoDTO> pagos = new ArrayList<>();
        for (Pago pago : pagoRepository.findAll()){
            pagos.add(convertirAPagoDTO(pago));
        }
        return pagos;
    }
    
    public PagoDTO buscarPorId(Integer idPago){
        Pago pago = pagoRepository.findById(idPago).orElseThrow(() -> new RuntimeException("Pago no encontrado"));
        return convertirAPagoDTO(pago);
    }

    public PagoDTO guardar(Pago pago){
        Pago pagoGuardado = pagoRepository.save(pago);
        return convertirAPagoDTO(pagoGuardado);
    }

    //cree este metodo para calcular el total de pago
    //si no hay pagos devuelve 0.0
    public Double totalPagos(){
        Double total = pagoRepository.calcularTotalPagos();
        if (total != null){
            return total;
        }else{
            return 0.0;
        }
    }

    //cree este metodo para buscar pago segun su estado.
    //como pendiente,efectuado,cancelado
    public List<Pago> buscarPagosPorEstado(String estadoPago){
        return pagoRepository.buscarPagosPorEstado(estadoPago);
    }




    private PagoDTO convertirAPagoDTO(Pago pago){
        PagoDTO pagoDTO = new PagoDTO();
        pagoDTO.setIdPago(pago.getIdPago());
        pagoDTO.setEstadoPago(pago.getEstadoPago());
       
        if (pago.getDetallePedido() != null){
            pagoDTO.setIdDetallePedido(pago.getDetallePedido().getIdDetallePedido());
         
             pagoDTO.setMonto(pago.getDetallePedido().getPrecio());
           }
        return pagoDTO;
    }
}