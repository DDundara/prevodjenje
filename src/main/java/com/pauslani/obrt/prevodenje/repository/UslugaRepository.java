package com.pauslani.obrt.prevodenje.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pauslani.obrt.prevodenje.entitet.Usluga;

@Repository
public interface UslugaRepository extends JpaRepository<Usluga, Long> {
	
	Usluga findByVrstaUsluge(String vrstaUsluge);
}

