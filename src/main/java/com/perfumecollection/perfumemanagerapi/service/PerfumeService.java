package com.perfumecollection.perfumemanagerapi.service;

import com.perfumecollection.perfumemanagerapi.dto.PerfumeRequestDTO;
import com.perfumecollection.perfumemanagerapi.dto.PerfumeResponseDTO;
import com.perfumecollection.perfumemanagerapi.mapper.PerfumeMapper;
import com.perfumecollection.perfumemanagerapi.model.Perfume;
import com.perfumecollection.perfumemanagerapi.repository.PerfumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PerfumeService {
    private final PerfumeRepository perfumeRepository;
    private final PerfumeMapper perfumeMapper;

    public PerfumeResponseDTO guardarPerfume(PerfumeRequestDTO requestDTO){
        Perfume perfume = perfumeMapper.toEntity(requestDTO);
        Perfume perfumeGuardado = perfumeRepository.save(perfume);
        return perfumeMapper.toResponseDTO(perfumeGuardado);
    }

    public List<PerfumeResponseDTO> listaPerfume(){
        List<Perfume> perfumes = perfumeRepository.findAll();
        List<PerfumeResponseDTO> perfumesDTO = new ArrayList<>();
        for (Perfume p : perfumes) {
            perfumesDTO.add(perfumeMapper.toResponseDTO(p));
        }
        return perfumesDTO;
    }

    public PerfumeResponseDTO buscarPorId(Long id){
        Perfume perfumeEncontrado = perfumeRepository.findById(id).orElse(null);
        if (perfumeEncontrado != null){
            return perfumeMapper.toResponseDTO(perfumeEncontrado);
        }
        System.out.println("No se encontró el perfume con el ID ingresado.");
        return null;
    }

    public void eliminarPerfume(Long id){
        perfumeRepository.deleteById(id);
    }

    public PerfumeResponseDTO actualizarPerfume(Long id, PerfumeRequestDTO perfumeActualizado){
        Perfume perfumeExistente = perfumeRepository.findById(id).orElse(null);
        if (perfumeExistente != null){
            perfumeExistente.setNombre(perfumeActualizado.getNombre());
            perfumeExistente.setMarca(perfumeActualizado.getMarca());
            perfumeExistente.setMililitrosTotales(perfumeActualizado.getMililitrosTotales());
            perfumeExistente.setMililitrosRestantes(perfumeActualizado.getMililitrosRestantes());
            perfumeExistente.setEntorno(perfumeActualizado.getEntorno());
            perfumeRepository.save(perfumeExistente);
            return perfumeMapper.toResponseDTO(perfumeExistente);
        }
        System.out.println("No se encontró el perfume con el ID ingresado.");
        return null;
    }
}
