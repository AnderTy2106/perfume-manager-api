package com.perfumecollection.perfumemanagerapi.repository;

import com.perfumecollection.perfumemanagerapi.model.Perfume;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PerfumeRepository extends JpaRepository<Perfume,Long> {
    List<Perfume> findPerfumeByEntorno(Perfume.Entorno entorno);

    List<Perfume> findByMarcaId(Long marcaId);
}
