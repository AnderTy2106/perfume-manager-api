package com.perfumecollection.perfumemanagerapi.dto;

import com.perfumecollection.perfumemanagerapi.model.Perfume;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PerfumeResponseDTO {
    private Long id;
    private String nombre;
    private String marca;
    private double mililitrosTotales;
    private double mililitrosRestantes;
    private Perfume.Entorno entorno;
}
