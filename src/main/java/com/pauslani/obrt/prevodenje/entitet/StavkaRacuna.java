package com.pauslani.obrt.prevodenje.entitet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "stavkaracuna")
public class StavkaRacuna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "kolicina")
    private Integer kolicina;
    
    @Transient
    private String vrstaUsluge;

   
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uslugaid")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Usluga usluga;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RacunID")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Racun racun;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getKolicina() {
		return kolicina;
	}

	public void setKolicina(Integer kolicina) {
		this.kolicina = kolicina;
	}

	public Usluga getUsluga() {
		return usluga;
	}

	public void setUsluga(Usluga usluga) {
		this.usluga = usluga;
	}

	public Racun getRacun() {
		return racun;
	}

	public void setRacun(Racun racun) {
		this.racun = racun;
	}

	public String getVrstaUsluge() {
		return vrstaUsluge;
	}

	public void setVrstaUsluge(String vrstaUsluge) {
		this.vrstaUsluge = vrstaUsluge;
	}
    
    
}