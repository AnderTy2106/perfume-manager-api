package com.perfumecollection.perfumemanagerapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "PERFUME")
@Table(name = "PERFUMES")
@Data
public class Perfume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "MARCA")
    private String marca;

    @Column(name = "MILILITROS_TOTALES")
    private float mililitrosTotales;

    @Column(name = "MILILITROS_RESTANTES")
    private float mililitrosRestantes;

    @Column(name = "ENTORNO")
    @Enumerated(EnumType.STRING)
    private Perfume.Entorno entorno;
    public enum Entorno{
        OFICINA,
        CITAS,
        DIARIO
    }

}
