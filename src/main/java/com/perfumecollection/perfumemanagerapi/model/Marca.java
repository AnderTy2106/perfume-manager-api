package com.perfumecollection.perfumemanagerapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "MARCA")
@Table(name = "MARCAS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @OneToMany(mappedBy = "marca", cascade = CascadeType.ALL)
    private List<Perfume> perfumes;
}
