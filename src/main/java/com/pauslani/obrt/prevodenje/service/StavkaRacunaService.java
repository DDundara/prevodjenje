package com.pauslani.obrt.prevodenje.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.pauslani.obrt.prevodenje.entitet.StavkaRacuna;
import com.pauslani.obrt.prevodenje.repository.StavkaRacunaRepository;

@Service
public class StavkaRacunaService {

    private final StavkaRacunaRepository stavkaRacunaRepository;

    @Autowired
    public StavkaRacunaService(StavkaRacunaRepository stavkaRacunaRepository) {
        this.stavkaRacunaRepository = stavkaRacunaRepository;
    }

    public List<StavkaRacuna> getAllStavkaRacuna() {
        return stavkaRacunaRepository.findAll();
    }

    public StavkaRacuna getStavkaRacunaById(Long id) throws NotFoundException {
        return stavkaRacunaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException());
    }

    public StavkaRacuna createStavkaRacun(StavkaRacuna stavkaRacuna) {
        return stavkaRacunaRepository.save(stavkaRacuna);
    }

//    public Kupac updateKupac(Kupac kupac) throws NotFoundException {
//        if (!kupacRepository.existsById(kupac.getId)) {
//            throw new NotFoundException();
//        }
//        return kupacRepository.save(kupac);
//    }

    public void deleteStavkaRacuna(Long id) throws NotFoundException {
        if (!stavkaRacunaRepository.existsById(id)) {
            throw new NotFoundException();
        }
        stavkaRacunaRepository.deleteById(id);
    }

}
