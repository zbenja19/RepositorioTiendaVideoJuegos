package com.tienda.servicio_videojuego.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.servicio_videojuego.DTO.PagoDTO;
import com.tienda.servicio_videojuego.model.Pago;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PagoService {

    @Autowired
    private DetallePedidoService detallePedidoService;

    public List<PagoDTO> obtenerTodos(){
        List<PagoDTO> pagos = new ArrayList<>();
        for (Pago pago : PagoRepository.findAll()){
            pagos.add(convertirAPagoDTO(pago));
        }
        return pagos;
    }
    
    public PagoDTO buscarPorId(Integer idPago){
        Pago pago = PagoRepository.findById(idPago).orElseThrow(() -> new RuntimeException("Pago no encontrado"));
        return convertirAPagoDTO(pago);
    }

    public PagoDTO guardar(Pago pago){
        Pago pagoGuardado = PagoRepository.save(pago);
        return convertirAPagoDTO(pagoGuardado);
    }

    private PagoDTO convertirAPagoDTO(Pago pago){
        PagoDTO pagoDTO = new PagoDTO();
        pagoDTO.setIdPago(pago.getIdPago());
        pagoDTO.setIdDetallePedido(pago.getIdDetallePedido());
        pagoDTO.setMonto(pago.getMonto());
        if (pago.getIdDetallePedido() != null){
            pagoDTO.setIdDetallePedido(pago.getIdDetallePedido());
        }else{
            pagoDTO.setIdDetallePedido("Desconocida");
        }
        return pagoDTO;
    }
}