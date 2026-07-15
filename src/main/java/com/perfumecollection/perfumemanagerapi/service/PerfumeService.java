package com.perfumecollection.perfumemanagerapi.service;

import com.perfumecollection.perfumemanagerapi.model.Perfume;
import com.perfumecollection.perfumemanagerapi.repository.PerfumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PerfumeService {
    private final PerfumeRepository perfumeRepository;

    public Perfume guardarPerfume(Perfume perfume){
        return perfumeRepository.save(perfume);
    }

    public List<Perfume> listaPerfume(){
        return perfumeRepository.findAll();
    }

    public Perfume buscarPorId(Long id){
        return perfumeRepository.findById(id).orElse(null);
    }

    public void eliminarPerfume(Long id){
        perfumeRepository.deleteById(id);
    }

    public Perfume actualizarPerfume(Long id, Perfume perfumeActualizado){
        Perfume perfumeExistente = perfumeRepository.findById(id).orElse(null);
        if (perfumeExistente != null){
            perfumeExistente.setNombre(perfumeActualizado.getNombre());
            perfumeExistente.setMarca(perfumeActualizado.getMarca());
            perfumeExistente.setMililitrosTotales(perfumeActualizado.getMililitrosTotales());
            perfumeExistente.setMililitrosRestantes(perfumeActualizado.getMililitrosRestantes());
            perfumeExistente.setEntorno(perfumeActualizado.getEntorno());
            return perfumeRepository.save(perfumeExistente);
        }
        System.out.println("No se encontró el perfume con el ID ingresado.");
        return null;
    }
}
