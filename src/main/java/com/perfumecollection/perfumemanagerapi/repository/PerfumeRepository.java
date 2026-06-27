package com.perfumecollection.perfumemanagerapi.repository;

import com.perfumecollection.perfumemanagerapi.model.Perfume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfumeRepository extends JpaRepository<Perfume,Long> {


}
