package com.perfumecollection.perfumemanagerapi.repository;

import com.perfumecollection.perfumemanagerapi.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca,Long> {
}
