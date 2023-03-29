package com.pauslani.obrt.prevodenje.entitet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "obrt")
public class Obrt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "naziv")
    private String naziv;

    @Column(name = "adresa")
    private String adresa;

    @Column(name = "url")
    private String url;

    @Column(name = "kontaktbroj")
    private String kontaktBroj;

    @Column(name = "Vlasnik")
    private String vlasnik;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getKontaktBroj() {
		return kontaktBroj;
	}

	public void setKontaktBroj(String kontaktBroj) {
		this.kontaktBroj = kontaktBroj;
	}

	public String getVlasnik() {
		return vlasnik;
	}

	public void setVlasnik(String vlasnik) {
		this.vlasnik = vlasnik;
	}
    
    
}