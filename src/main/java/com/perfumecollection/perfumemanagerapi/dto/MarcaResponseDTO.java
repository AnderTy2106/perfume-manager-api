package com.perfumecollection.perfumemanagerapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarcaResponseDTO {
    private Long id;
    private String nombreMarca;
}
