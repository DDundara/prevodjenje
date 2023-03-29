package com.pauslani.obrt.prevodenje.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.pauslani.obrt.prevodenje.entitet.Kupac;
import com.pauslani.obrt.prevodenje.repository.KupacRepository;

@Service
public class KupacService {

    private final KupacRepository kupacRepository;

    @Autowired
    public KupacService(KupacRepository kupacRepository) {
        this.kupacRepository = kupacRepository;
    }

    public List<Kupac> getAllKupci() {
        return kupacRepository.findAll();
    }

    public Kupac getKupacById(Long id) throws NotFoundException {
        return kupacRepository.findById(id)
                .orElseThrow(() -> new NotFoundException());
    }

    public Kupac createKupac(Kupac kupac) {
        return kupacRepository.save(kupac);
    }

//    public Kupac updateKupac(Kupac kupac) throws NotFoundException {
//        if (!kupacRepository.existsById(kupac.getId)) {
//            throw new NotFoundException();
//        }
//        return kupacRepository.save(kupac);
//    }

    public void deleteKupac(Long id) throws NotFoundException {
        if (!kupacRepository.existsById(id)) {
            throw new NotFoundException();
        }
        kupacRepository.deleteById(id);
    }

}
