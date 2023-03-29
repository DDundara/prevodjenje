package com.pauslani.obrt.prevodenje.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.pauslani.obrt.prevodenje.entitet.Obrt;
import com.pauslani.obrt.prevodenje.repository.ObrtRepository;


@Service
public class ObrtService {

    private final ObrtRepository obrtRepository;

    @Autowired
    public ObrtService(ObrtRepository obrtRepository) {
        this.obrtRepository = obrtRepository;
    }

    public List<Obrt> getAllObrt() {
        return obrtRepository.findAll();
    }

    public Obrt getObrtById(Long id) throws NotFoundException {
        return obrtRepository.findById(id)
                .orElseThrow(() -> new NotFoundException());
    }

    public Obrt createObrt(Obrt obrt) {
        return obrtRepository.save(obrt);
    }

//    public Kupac updateKupac(Kupac kupac) throws NotFoundException {
//        if (!UslugaRepository.existsById(kupac.getId)) {
//            throw new NotFoundException();
//        }
//        return UslugaRepository.save(kupac);
//    }

    public void deleteObrt(Long id) throws NotFoundException {
        if (!obrtRepository.existsById(id)) {
            throw new NotFoundException();
        }
        obrtRepository.deleteById(id);
    }

}
