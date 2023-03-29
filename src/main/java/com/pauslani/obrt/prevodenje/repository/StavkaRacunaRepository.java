package com.pauslani.obrt.prevodenje.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pauslani.obrt.prevodenje.entitet.StavkaRacuna;

@Repository
public interface StavkaRacunaRepository extends JpaRepository<StavkaRacuna, Long> {
    List<StavkaRacuna> findByRacunId(Long racunId);
}
