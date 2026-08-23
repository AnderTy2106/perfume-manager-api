package com.perfumecollection.perfumemanagerapi.controller;

import com.perfumecollection.perfumemanagerapi.dto.MarcaRequestDTO;
import com.perfumecollection.perfumemanagerapi.dto.MarcaResponseDTO;
import com.perfumecollection.perfumemanagerapi.service.MarcaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marcas")
@RequiredArgsConstructor
public class MarcaController {
    private final MarcaService marcaService;

    @PostMapping
    public MarcaResponseDTO postMarca(@Valid @RequestBody MarcaRequestDTO marcaRequestDTO){
        return marcaService.guardarMarca(marcaRequestDTO);
    }

    @GetMapping
    public List<MarcaResponseDTO> getListaMarca(){
        return marcaService.listaMarca();
    }

    @GetMapping("/{id}")
    public MarcaResponseDTO getMarcaPorId(@PathVariable Long id){
        return marcaService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public String deleteMarcaPorId(@PathVariable Long id){
        marcaService.eliminarMarca(id);
        return "Marca eliminada correctamente.";
    }

    @PutMapping("/{id}")
    public MarcaResponseDTO actualizarPerfumePorId(@PathVariable Long id, @Valid @RequestBody MarcaRequestDTO marcaActualizada){
        return marcaService.actualizarMarca(id, marcaActualizada);
    }
}
