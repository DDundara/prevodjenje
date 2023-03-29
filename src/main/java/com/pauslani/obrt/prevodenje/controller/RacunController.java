package com.pauslani.obrt.prevodenje.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pauslani.obrt.prevodenje.entitet.Kupac;
import com.pauslani.obrt.prevodenje.entitet.Racun;
import com.pauslani.obrt.prevodenje.entitet.StavkaRacuna;
import com.pauslani.obrt.prevodenje.entitet.Usluga;
import com.pauslani.obrt.prevodenje.service.KupacService;
import com.pauslani.obrt.prevodenje.service.RacunService;
import com.pauslani.obrt.prevodenje.service.StavkaRacunaService;
import com.pauslani.obrt.prevodenje.service.UslugaService;

@RestController
@RequestMapping("/racuni")
@CrossOrigin(origins = "http://localhost:3000")
public class RacunController {

    private final RacunService racunService;
    private final KupacService kupacService;
    private final StavkaRacunaService  stavkaRacunaService;
    private final UslugaService uslugaService;


    @Autowired
    public RacunController(RacunService racunService, KupacService kupacService, 
    		StavkaRacunaService  stavkaRacunaService, UslugaService uslugaService) {
        this.racunService = racunService;
        this.kupacService = kupacService;
        this.stavkaRacunaService = stavkaRacunaService;
        this.uslugaService = uslugaService;
    }
    
    @GetMapping("/test")
    public String hello() {
        return "Ovo je test";
    }

    @PostMapping
    public ResponseEntity<Racun> kreirajRacun(@RequestBody Racun racun) {
    	
    	// Unijet prije Kupca
    	Kupac kupac = new Kupac();
		kupac.setImePrezime(racun.getKupac().getImePrezime());
		kupac.setAdresa(racun.getKupac().getAdresa());
		kupac.setOib(racun.getKupac().getOib());
		kupac.setEmail(racun.getKupac().getEmail());
		kupac.setBrojTelefona(racun.getKupac().getBrojTelefona());

    	Kupac kreirajKupca = kupacService.createKupac(kupac);
    	

    	
		racun.setBrojRacuna(racun.getBrojRacuna());
		racun.setDatumIzdavanja(LocalDate.now());
		racun.setUkupanIznos(100.0);
		racun.setJir(generateJIR());
		racun.setNacinPlacanja(racun.getNacinPlacanja());
		racun.setUkupanIznosNaknadeIPoreza(0.0);
		racun.setKupac(kupac);
        Racun kreiraniRacun = racunService.kreirajRacun(racun);
        
        Double ukupnaCijena = new Double(0);
        
        for (StavkaRacuna stavka : racun.getStavkeRacuna()) {
        	//Dohvati usluge
        	Usluga usluga = uslugaService.getUslugaByVrstaUsluge(stavka.getVrstaUsluge());
        	
        	stavka.setUsluga(usluga);
        	stavka.setRacun(racun);
        	stavka.setKolicina(stavka.getKolicina());
        	//Racunaj cijenu gdje je kolicina puta cijena usluge
        	Double cijena =  new Double( stavka.getKolicina().intValue()) * usluga.getCijenaPoJedinici().floatValue();
        	ukupnaCijena = ukupnaCijena + cijena;
        	stavkaRacunaService.createStavkaRacun(stavka);
        	}
        
          //Postaviti cijenu
          kreiraniRacun.setUkupanIznos(ukupnaCijena);
          racunService.kreirajRacun(kreiraniRacun);
        
        
        //Sada setirati Stavke racucna
        //Prije toga dohvatiti usluge
 /*       Usluga usluga1 = null;
        Usluga usluga2 = null;
		try {
			usluga1 = uslugaService.getUslugaById((long) 1);
            usluga2 = uslugaService.getUslugaById((long) 2);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        
		StavkaRacuna stavka1 = new StavkaRacuna();
		stavka1.setUsluga(usluga1);
		stavka1.setKolicina(1);
		stavka1.setRacun(racun);

		StavkaRacuna stavka2 = new StavkaRacuna();
		stavka2.setUsluga(usluga2);
		stavka2.setKolicina(1);
		stavka2.setRacun(racun);
		
		stavkaRacunaService.createStavkaRacun(stavka1);
		stavkaRacunaService.createStavkaRacun(stavka2);   */
		
        
       
        
        return new ResponseEntity<>(kreiraniRacun, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Racun>> dohvatiSveRacune() {
        List<Racun> racuni = racunService.dohvatiSveRacune();
        return new ResponseEntity<>(racuni, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Racun> dohvatiRacunPoId(@PathVariable Long id) {
        Optional<Racun> racun = racunService.dohvatiRacunPoId(id);
        return racun.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/kupac/{kupacId}")
    public ResponseEntity<List<Racun>> dohvatiRacunePoOsobi(@PathVariable Long kupacId) {
        List<Racun> racuni = racunService.dohvatiRacunePoOsobi(kupacId);
        return new ResponseEntity<>(racuni, HttpStatus.OK);
    }

    @GetMapping("/usluga/{vrstaUsluge}")
    public ResponseEntity<List<Racun>> dohvatiRacunePoUsluzi(@PathVariable String vrstaUsluge) {
        List<Racun> racuni = racunService.dohvatiRacunePoUsluzi(vrstaUsluge);
        return new ResponseEntity<>(racuni, HttpStatus.OK);
    }

//    @GetMapping("/period")
//    public ResponseEntity<List<Racun>> dohvatiRacunePoVremenskomPeriodu(@RequestParam("pocetak") Date pocetak,
//                                                                       @RequestParam("kraj") Date kraj) {
//        List<Racun> racuni = racunService.dohvatiRacunePoVremenskomPeriodu(pocetak, kraj);
//        return new ResponseEntity<>(racuni, HttpStatus.OK);
//    }
    
    
    @GetMapping("/period")
    public ResponseEntity<List<Racun>> dohvatiRacunePoVremenskomPerioduKupcu(@RequestParam("pocetak")  String pocetak,
                                                                       @RequestParam("kraj")  String kraj,
                                                                       @RequestParam("kupac") Long id) {
    	
    	LocalDate datePocetak = LocalDate.parse(pocetak);
    	LocalDate dateKraj = LocalDate.parse(kraj);

        List<Racun> racuni = racunService.findRacuniByPeriodAndKupac(datePocetak, dateKraj, id);
        return new ResponseEntity<>(racuni, HttpStatus.OK);
    }
    
    @GetMapping("/period/usluga")
    public ResponseEntity<List<Racun>> findRacuniByPeriodKupacAndUsluga(@RequestParam("pocetak")  String pocetak,
                                                                       @RequestParam("kraj")  String kraj,
                                                                       @RequestParam(name = "kupac", required = false) Long idKupca,
                                                                       @RequestParam(name = "usluga", required = false) Long idUsluga) {
    	
    	LocalDate datePocetak = LocalDate.parse(pocetak);
    	LocalDate dateKraj = LocalDate.parse(kraj);

        List<Racun> racuni;
        if (idKupca == null && idUsluga == null) {
            racuni = racunService.dohvatiRacunePoVremenskomPeriodu(datePocetak, dateKraj);
        } else if (idKupca == null) {
            racuni = racunService.findRacuniByPeriodAndUsluga(datePocetak, dateKraj, idUsluga);
        } else if (idUsluga == null) {
            racuni = racunService.findRacuniByPeriodAndKupac(datePocetak, dateKraj, idKupca);
        } else {
            racuni = racunService.findRacuniByPeriodKupacAndUsluga(datePocetak, dateKraj, idKupca, idUsluga);
        }
        return new ResponseEntity<>(racuni, HttpStatus.OK);
    }
    
    public static String generateJIR() {
        Random rand = new Random();
        String jir = "";

        for (int i = 0; i < 16; i++) {
            jir += rand.nextInt(10);
        }

        return jir;
    }
    

}
