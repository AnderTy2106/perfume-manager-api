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
}
