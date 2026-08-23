package com.perfumecollection.perfumemanagerapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarcaRequestDTO {
    @NotBlank(message = "El nombre de la marca es obligatorio.")
    private String nombreMarca;
}
