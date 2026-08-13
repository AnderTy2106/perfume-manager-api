package com.perfumecollection.perfumemanagerapi.dto;

import com.perfumecollection.perfumemanagerapi.model.Perfume;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PerfumeRequestDTO {
    @NotBlank(message = "El nombre del perfume es obligatorio.")
    private String nombre;

    @NotNull(message = "La marca del perfume es obligatorio.")
    private Long marcaId;

    @NotNull(message = "Los mililitros son requeridos")
    @DecimalMin(value = "5.0", message = "El frasco debe de tener al menos 5 ml.")
    private double mililitrosTotales;

    @NotNull(message = "Los mililitros son requeridos")
    @DecimalMin(value = "0.0", message = "Los mililitros restantes no pueden ser negativos.")
    private double mililitrosRestantes;

    @NotNull(message = "El entorno no puede ser nulo")
    private Perfume.Entorno entorno;
}
