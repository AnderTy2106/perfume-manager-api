package com.perfumecollection.perfumemanagerapi.service;

import com.perfumecollection.perfumemanagerapi.dto.MarcaRequestDTO;
import com.perfumecollection.perfumemanagerapi.dto.MarcaResponseDTO;
import com.perfumecollection.perfumemanagerapi.exception.ResourceNotFoundException;
import com.perfumecollection.perfumemanagerapi.mapper.MarcaMapper;
import com.perfumecollection.perfumemanagerapi.model.Marca;
import com.perfumecollection.perfumemanagerapi.repository.MarcaRepository;
import com.perfumecollection.perfumemanagerapi.repository.PerfumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MarcaService {
    private final MarcaRepository marcaRepository;
    private final MarcaMapper marcaMapper;
    private final PerfumeRepository perfumeRepository;

    public MarcaResponseDTO guardarMarca(MarcaRequestDTO marcaRequestDTO){
        Marca marcaNueva = marcaMapper.toEntity(marcaRequestDTO);
        Marca marcaGuardada = marcaRepository.save(marcaNueva);
        return marcaMapper.toResponseDTO(marcaGuardada);
    }

    public List<MarcaResponseDTO> listaMarca(){
        List<Marca> marcas = marcaRepository.findAll();
        List<MarcaResponseDTO> marcaResponseDTOS = new ArrayList<>();
        for(Marca m : marcas){
            marcaResponseDTOS.add(marcaMapper.toResponseDTO(m));
        }
        return marcaResponseDTOS;
    }

    public MarcaResponseDTO buscarPorId(Long id){
        Marca marcaEncontrada = marcaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se encontró la marca con el ID: " + id));
        return marcaMapper.toResponseDTO(marcaEncontrada);
    }

    public void eliminarMarca(Long id){
        marcaRepository.deleteById(id);
    }

    public MarcaResponseDTO actualizarMarca(Long id, MarcaRequestDTO marcaActualizada){
        Marca marcaExistente = marcaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se encontró la marca con el ID: " + id));
        marcaExistente.setNombre(marcaActualizada.getNombreMarca());
        marcaRepository.save(marcaExistente);
        return marcaMapper.toResponseDTO(marcaExistente);
    }
}
