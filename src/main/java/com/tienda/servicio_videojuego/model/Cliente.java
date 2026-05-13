package com.tienda.servicio_videojuego.model;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message="El nombre del usuario es obligatoria")
    @Size(min=2,max=50)
    @Column(name="cliente", nullable=false)
    private String nombre;

    @NotBlank(message="El email es obligatoria")
    @Size(min=2,max=50)
    @Column(nullable=false,length=60)
    private String email;

    @NotBlank(message = "El teléfono no puede estar vacío")
    @Size(min=7, max= 20, message = "El teléfono debe tener entre 7 y 20 caracteres")
    @Column(length=20,nullable = false)
    private String telefono;

    @NotNull(message = "la contraseña es obligatorio")
    @Min(value = 0000, message = "la contraseña debe ser de 4 dígitos")
    @Max(value = 9999, message = "la contraseña no puede tener más de 4 dígitos")
    @Column(nullable = false)
    private String contrasena;

    @ManyToOne
    @JoinColumn(name = "idbiblioteca")
    private Biblioteca biblioteca;

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;

}