package com.perfumecollection.perfumemanagerapi.service;

import com.perfumecollection.perfumemanagerapi.model.Perfume;
import com.perfumecollection.perfumemanagerapi.repository.PerfumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PerfumeService {
    private final PerfumeRepository perfumeRepository;

    public Perfume guardarPerfume(Perfume perfume){
        return perfumeRepository.save(perfume);
    }
}
