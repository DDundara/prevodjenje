package com.pauslani.obrt.prevodenje.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pauslani.obrt.prevodenje.entitet.Racun;
import com.pauslani.obrt.prevodenje.repository.RacunRepository;

@Service
public class RacunService {

    private final RacunRepository racunRepository;

    @Autowired
    public RacunService(RacunRepository racunRepository) {
        this.racunRepository = racunRepository;
    }

    public Racun kreirajRacun(Racun racun) {
        return racunRepository.save(racun);
    }

    public List<Racun> dohvatiSveRacune() {
        return racunRepository.findAll();
    }

    public Optional<Racun> dohvatiRacunPoId(Long id) {
        return racunRepository.findById(id);
    }

    public List<Racun> dohvatiRacunePoOsobi(Long kupacId) {
        return racunRepository.findByKupacId(kupacId);
    }

    public List<Racun> dohvatiRacunePoUsluzi(String vrstaUsluge) {
        return racunRepository.findByStavkeRacunaUslugaVrstaUsluge(vrstaUsluge);
    }

    public List<Racun> dohvatiRacunePoVremenskomPeriodu(LocalDate pocetak, LocalDate kraj) {
        return racunRepository.findByDatumIzdavanjaBetween(pocetak, kraj);
    }
    
    public List<Racun> findRacuniByPeriodAndKupac(LocalDate pocetak, LocalDate kraj, Long id) {
        return racunRepository.findRacuniByPeriodAndKupac(pocetak, kraj, id);
    }
    
    public List<Racun> findRacuniByPeriodKupacAndUsluga(LocalDate pocetak, LocalDate kraj, Long idKupca, Long idUlsuge) {
        return racunRepository.findRacuniByPeriodKupacAndUsluga(pocetak, kraj, idKupca, idUlsuge);
    }
    
    public List<Racun> findRacuniByPeriodAndUsluga(LocalDate pocetak, LocalDate kraj, Long idUlsuge) {
        return racunRepository.findRacuniByPeriodAndUsluga(pocetak, kraj,  idUlsuge);
    }


}