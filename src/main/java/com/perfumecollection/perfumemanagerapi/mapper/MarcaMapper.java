package com.perfumecollection.perfumemanagerapi.mapper;

import com.perfumecollection.perfumemanagerapi.dto.MarcaRequestDTO;
import com.perfumecollection.perfumemanagerapi.dto.MarcaResponseDTO;
import com.perfumecollection.perfumemanagerapi.model.Marca;
import org.springframework.stereotype.Component;

@Component
public class MarcaMapper {
    public MarcaResponseDTO toResponseDTO(Marca marca){
        return new MarcaResponseDTO(
                marca.getId(),
                marca.getNombre()
        );
    }
    public Marca toEntity(MarcaRequestDTO marcaRequestDTO){
        Marca marca = new Marca();
        marca.setNombre(marcaRequestDTO.getNombreMarca());
        return marca;
    }
}
