package com.perfumecollection.perfumemanagerapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity(name = "PERFUME")
@Table(name = "PERFUMES")
@Data
public class Perfume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOMBRE")
    @NotBlank(message = "El nombre del perfume es obligatorio.")
    private String nombre;

    @Column(name = "MARCA")
    @NotBlank(message = "La marca del perfume es obligatorio.")
    private String marca;

    @Column(name = "MILILITROS_TOTALES")
    @NotNull(message = "Los mililitros son requeridos")
    @DecimalMin(value = "5.0", message = "El frasco debe de tener al menos 5 ml.")
    private double mililitrosTotales;

    @Column(name = "MILILITROS_RESTANTES")
    @NotNull(message = "Los mililitros son requeridos")
    @DecimalMin(value = "0.0", message = "Los mililitros restantes no pueden ser negativos.")
    private double mililitrosRestantes;

    @Column(name = "ENTORNO")
    @NotNull(message = "El entorno no puede ser nulo")
    @Enumerated(EnumType.STRING)
    private Perfume.Entorno entorno;
    public enum Entorno{
        OFICINA,
        CITAS,
        DIARIO
    }

}
