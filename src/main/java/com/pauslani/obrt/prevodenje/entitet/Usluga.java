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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "usluga")
public class Usluga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vrstausluge", nullable = false)
    private String vrstaUsluge;

    @Column(name = "cijenapojedinici", nullable = false)
    private Double cijenaPoJedinici;

    @Column(name = "jedinicamjere", nullable = false)
    private String jedinicaMjere;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "obrtid", nullable = false)
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Obrt obrt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVrstaUsluge() {
		return vrstaUsluge;
	}

	public void setVrstaUsluge(String vrstaUsluge) {
		this.vrstaUsluge = vrstaUsluge;
	}

	public Double getCijenaPoJedinici() {
		return cijenaPoJedinici;
	}

	public void setCijenaPoJedinici(Double cijenaPoJedinici) {
		this.cijenaPoJedinici = cijenaPoJedinici;
	}

	public String getJedinicaMjere() {
		return jedinicaMjere;
	}

	public void setJedinicaMjere(String jedinicaMjere) {
		this.jedinicaMjere = jedinicaMjere;
	}

	public Obrt getObrt() {
		return obrt;
	}

	public void setObrt(Obrt obrt) {
		this.obrt = obrt;
	}
    
    
}