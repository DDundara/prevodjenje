package com.pauslani.obrt.prevodenje.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;

import com.pauslani.obrt.prevodenje.entitet.Kupac;
import com.pauslani.obrt.prevodenje.service.KupacService;

@RestController
@RequestMapping("/kupci")
@CrossOrigin(origins = "http://localhost:3000")
public class KupacController {

    private final KupacService kupacService;

    public KupacController(KupacService kupacService) {
        this.kupacService = kupacService;
    }

    @GetMapping
    public List<Kupac> getAllKupci() {
        return kupacService.getAllKupci();
    }

    @GetMapping("/{id}")
    public Kupac getKupacById(@PathVariable Long id) throws NotFoundException {
        return kupacService.getKupacById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Kupac createKupac(@RequestBody Kupac kupacDto) {
        return kupacService.createKupac(kupacDto);
    }

//    @PutMapping("/{id}")
//    public KupacDto updateKupac(@PathVariable Long id, @RequestBody Kupac kupac) {
//        return kupacService.updateKupac(id, kupac);
//    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteKupac(@PathVariable Long id) {
        try {
			kupacService.deleteKupac(id);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}