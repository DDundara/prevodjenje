package com.pauslani.obrt.prevodenje.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.pauslani.obrt.prevodenje.entitet.Usluga;
import com.pauslani.obrt.prevodenje.service.UslugaService;

@RestController
@RequestMapping("/usluge")
@CrossOrigin(origins = "http://localhost:3000")
public class UslugaController {

    private final UslugaService uslugaService;

    public UslugaController(UslugaService uslugaService) {
        this.uslugaService = uslugaService;
    }

    @GetMapping
    public List<Usluga> getAllUsluga() {
        return uslugaService.getAllUsluga();
    }

    @GetMapping("/{id}")
    public Usluga getUslugaById(@PathVariable Long id) throws NotFoundException {
        return uslugaService.getUslugaById(id);
    }

}