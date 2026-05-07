package com.tienda.servicio_videojuego.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message ="ingrese la fecha")
    @Size(min=10,max=10, message = "La fecha debe tener 10 caracteres ")
    @Column(nullable=false,length=10)
    private String fechaAgregada;

    @NotNull(message = "El monto total es requerido")
    @Min(value = 0, message = "El total no puede ser menor a 0")
    @Max(value = 1000000)
    @Column(name = "total_pago", nullable = false)
    private Integer total;

    @NotNull(message = "El estado es obligatorio")
    @Column(nullable = false)
    private Boolean estado;



}
