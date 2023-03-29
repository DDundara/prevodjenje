package com.pauslani.obrt.prevodenje.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.pauslani.obrt.prevodenje.entitet.Usluga;
import com.pauslani.obrt.prevodenje.repository.UslugaRepository;

@Service
public class UslugaService {

    private final UslugaRepository uslugaRepository;

    @Autowired
    public UslugaService(UslugaRepository uslugaRepository) {
        this.uslugaRepository = uslugaRepository;
    }

    public List<Usluga> getAllUsluga() {
        return uslugaRepository.findAll();
    }

    public Usluga getUslugaById(Long id) throws NotFoundException {
        return uslugaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException());
    }
    
    public Usluga getUslugaByVrstaUsluge(String vrstaUsluge) {
        return uslugaRepository.findByVrstaUsluge(vrstaUsluge);
    }

    public Usluga createUsluga(Usluga usluga) {
        return uslugaRepository.save(usluga);
    }

//    public Kupac updateKupac(Kupac kupac) throws NotFoundException {
//        if (!UslugaRepository.existsById(kupac.getId)) {
//            throw new NotFoundException();
//        }
//        return UslugaRepository.save(kupac);
//    }

    public void deleteUsluga(Long id) throws NotFoundException {
        if (!uslugaRepository.existsById(id)) {
            throw new NotFoundException();
        }
        uslugaRepository.deleteById(id);
    }

}
