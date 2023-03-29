package com.pauslani.obrt.prevodenje.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pauslani.obrt.prevodenje.entitet.Racun;



@Repository
public interface RacunRepository extends JpaRepository<Racun, Long> {
    List<Racun> findByKupacId(Long kupacId);
    List<Racun> findByUkupanIznosBetween(BigDecimal minIznos, BigDecimal maxIznos);
    List<Racun> findByDatumIzdavanjaBetween(LocalDate startDate, LocalDate endDate);
    List<Racun> findByKupacIdAndDatumIzdavanjaBetween(Long kupacId, LocalDate startDate, LocalDate endDate);
    
    @Query("SELECT DISTINCT r FROM Racun r JOIN r.stavkeRacuna sr JOIN sr.usluga u WHERE u.vrstaUsluge = :vrstaUsluge")
    List<Racun> findByStavkeRacunaUslugaVrstaUsluge(@Param("vrstaUsluge") String vrstaUsluge);
    
    @Query("SELECT r FROM Racun r WHERE r.datumIzdavanja BETWEEN :vrijemeOd AND :vrijemeDo AND r.kupac.id = :idKupca")
    List<Racun> findRacuniByPeriodAndKupac(LocalDate vrijemeOd, LocalDate vrijemeDo, Long idKupca);
    
    @Query("SELECT r FROM Racun r JOIN r.stavkeRacuna sr JOIN sr.usluga u WHERE r.datumIzdavanja BETWEEN :vrijemeOd AND :vrijemeDo AND r.kupac.id = :idKupca AND u.id = :idUsluge")
    List<Racun> findRacuniByPeriodKupacAndUsluga(LocalDate vrijemeOd, LocalDate vrijemeDo, Long idKupca, Long idUsluge);
    
    @Query("SELECT r FROM Racun r JOIN r.stavkeRacuna sr JOIN sr.usluga u WHERE r.datumIzdavanja BETWEEN :vrijemeOd AND :vrijemeDo AND u.id = :idUsluge")
    List<Racun> findRacuniByPeriodAndUsluga(LocalDate vrijemeOd, LocalDate vrijemeDo, Long idUsluge);
}