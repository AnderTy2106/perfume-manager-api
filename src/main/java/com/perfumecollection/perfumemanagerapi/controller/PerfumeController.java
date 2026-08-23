package com.perfumecollection.perfumemanagerapi.controller;

import com.perfumecollection.perfumemanagerapi.dto.PerfumeRequestDTO;
import com.perfumecollection.perfumemanagerapi.dto.PerfumeResponseDTO;
import com.perfumecollection.perfumemanagerapi.service.PerfumeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/perfumes")
@RequiredArgsConstructor
public class PerfumeController {
    private final PerfumeService perfumeService;
    @PostMapping
    public PerfumeResponseDTO postPerfume(@Valid @RequestBody PerfumeRequestDTO requestDTO){
        return perfumeService.guardarPerfume(requestDTO);
    }

    @GetMapping
    public List<PerfumeResponseDTO> getListaPerfume(){
        return perfumeService.listaPerfume();
    }

    @GetMapping("/{id}")
    public PerfumeResponseDTO getPerfumePorId(@PathVariable Long id){
        return perfumeService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public String deletePerfumePorId(@PathVariable Long id){
        perfumeService.eliminarPerfume(id);
        return "Perfume eliminado correctamente";
    }

    @PutMapping("/{id}")
    public PerfumeResponseDTO actualizarPerfumePorId(@PathVariable Long id, @Valid @RequestBody PerfumeRequestDTO perfumeActualizado){
        return perfumeService.actualizarPerfume(id, perfumeActualizado);
    }
}
