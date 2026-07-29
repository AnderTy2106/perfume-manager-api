package com.perfumecollection.perfumemanagerapi.mapper;

import com.perfumecollection.perfumemanagerapi.dto.PerfumeRequestDTO;
import com.perfumecollection.perfumemanagerapi.dto.PerfumeResponseDTO;
import com.perfumecollection.perfumemanagerapi.model.Perfume;
import org.springframework.stereotype.Component;

@Component
public class PerfumeMapper {
    public PerfumeResponseDTO toResponseDTO(Perfume perfume){
        return new PerfumeResponseDTO(
                perfume.getId(),
                perfume.getNombre(),
                perfume.getMarca(),
                perfume.getMililitrosTotales(),
                perfume.getMililitrosRestantes(),
                perfume.getEntorno()
        );
    }
    public Perfume toEntity(PerfumeRequestDTO perfumeRequestDTO){
        Perfume perfume = new Perfume();
        perfume.setNombre(perfumeRequestDTO.getNombre());
        perfume.setMarca(perfumeRequestDTO.getMarca());
        perfume.setMililitrosTotales(perfumeRequestDTO.getMililitrosTotales());
        perfume.setMililitrosRestantes(perfumeRequestDTO.getMililitrosRestantes());
        perfume.setEntorno(perfumeRequestDTO.getEntorno());
        return perfume;
    }
}
