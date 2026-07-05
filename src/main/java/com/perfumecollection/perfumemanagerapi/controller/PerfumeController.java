package com.perfumecollection.perfumemanagerapi.controller;

import com.perfumecollection.perfumemanagerapi.model.Perfume;
import com.perfumecollection.perfumemanagerapi.service.PerfumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/perfumes")
@RequiredArgsConstructor
public class PerfumeController {
    private final PerfumeService perfumeService;
    @PostMapping
    public Perfume postPerfume(@RequestBody Perfume perfume){
        return perfumeService.guardarPerfume(perfume);
    }

    @GetMapping
    public List<Perfume> getListaPerfume(){
        return perfumeService.listaPerfume();
    }

    @GetMapping("/{id}")
    public Perfume getPerfumePorId(@PathVariable Long id){
        return perfumeService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public String deletePerfumePorId(@PathVariable Long id){
        perfumeService.eliminarPerfume(id);
        return "Perfume eliminado correctamente";
    }
}
