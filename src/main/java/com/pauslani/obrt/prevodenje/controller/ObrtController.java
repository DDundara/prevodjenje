package com.pauslani.obrt.prevodenje.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.pauslani.obrt.prevodenje.entitet.Obrt;
import com.pauslani.obrt.prevodenje.service.ObrtService;


@RestController
@RequestMapping("/obrt")
@CrossOrigin(origins = "http://localhost:3000")
public class ObrtController {

    private final ObrtService obrtService;

    public ObrtController(ObrtService obrtService) {
        this.obrtService = obrtService;
    }

    @GetMapping
    public List<Obrt> getAllObrt() {
        return obrtService.getAllObrt();
    }

    @GetMapping("/{id}")
    public Obrt getUslugaById(@PathVariable Long id) throws NotFoundException {
        return obrtService.getObrtById(id);
    }

}