package com.perfumecollection.perfumemanagerapi.service;

import com.perfumecollection.perfumemanagerapi.model.Perfume;
import com.perfumecollection.perfumemanagerapi.repository.PerfumeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PerfumeServiceTest {
    @Mock
    private PerfumeRepository perfumeRepository;

    @InjectMocks
    private PerfumeService perfumeService;

    @Test
    void guardarPerfume() {
        Perfume perfume = new Perfume();
        perfume.setNombre("9 PM");
        perfume.setMarca("Afnan");
        perfume.setMililitrosTotales(10.0);
        perfume.setMililitrosRestantes(9.5);
        perfume.setEntorno(Perfume.Entorno.CITAS);

        Mockito.when(perfumeRepository.save(perfume)).thenReturn(perfume);

        Perfume perfumeSimulado = perfumeService.guardarPerfume(perfume);

        assertEquals("9 PM", perfumeSimulado.getNombre());
    }
}