package com.pauslani.obrt.prevodenje.entitet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "racun")
public class Racun {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brojracuna", nullable = false)
    private String brojRacuna;

    @Column(name = "datumizdavanja", nullable = false)
    private LocalDate datumIzdavanja;

    @Column(name = "ukupaniznos", nullable = false)
    private Double ukupanIznos;

    @Column(name = "jir", nullable = false)
    private String jir;

    @Column(name = "nacinplacanja", nullable = false)
    private String nacinPlacanja;

    @Column(name = "ukupaniznosnaknadeiporeza", nullable = false)
    private Double ukupanIznosNaknadeIPoreza;

    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kupacid", nullable = false)
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Kupac kupac;

 
    @OneToMany(mappedBy = "racun", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StavkaRacuna> stavkeRacuna = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrojRacuna() {
		return brojRacuna;
	}

	public void setBrojRacuna(String brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public LocalDate getDatumIzdavanja() {
		return datumIzdavanja;
	}

	public void setDatumIzdavanja(LocalDate datumIzdavanja) {
		this.datumIzdavanja = datumIzdavanja;
	}

	public Double getUkupanIznos() {
		return ukupanIznos;
	}

	public void setUkupanIznos(Double ukupanIznos) {
		this.ukupanIznos = ukupanIznos;
	}

	public String getJir() {
		return jir;
	}

	public void setJir(String jir) {
		this.jir = jir;
	}

	public String getNacinPlacanja() {
		return nacinPlacanja;
	}

	public void setNacinPlacanja(String nacinPlacanja) {
		this.nacinPlacanja = nacinPlacanja;
	}

	public Double getUkupanIznosNaknadeIPoreza() {
		return ukupanIznosNaknadeIPoreza;
	}

	public void setUkupanIznosNaknadeIPoreza(Double ukupanIznosNaknadeIPoreza) {
		this.ukupanIznosNaknadeIPoreza = ukupanIznosNaknadeIPoreza;
	}

	public Kupac getKupac() {
		return kupac;
	}

	public void setKupac(Kupac kupac) {
		this.kupac = kupac;
	}

	public List<StavkaRacuna> getStavkeRacuna() {
		return stavkeRacuna;
	}

	public void setStavkeRacuna(List<StavkaRacuna> stavkeRacuna) {
		this.stavkeRacuna = stavkeRacuna;
	}
    
    
}