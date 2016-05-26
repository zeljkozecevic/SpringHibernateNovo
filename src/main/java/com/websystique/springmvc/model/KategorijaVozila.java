package com.websystique.springmvc.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "KATEGORIJA_VOZILA")
public class KategorijaVozila {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name = "KATEGORIJA_VOZILA_ID")
	private Long kategorijaVozilaId;
/*	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="KATEGORIJA_VOZILA_ID", nullable = false)
	List<Vozilo> vozilo = new ArrayList<>();
*/	
	@Column(name = "NAZIV")
	private String naziv;
	
	@Column(name = "OPIS")
	private String opis;

	public Long getKategorijaVozilaId() {
		return kategorijaVozilaId;
	}

	public void setKategorijaVozilaId(Long kategorijaVozilaId) {
		this.kategorijaVozilaId = kategorijaVozilaId;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}
/*
	public List<Vozilo> getVozilo() {
		return vozilo;
	}

	public void setVozilo(List<Vozilo> vozilo) {
		this.vozilo = vozilo;
	}
*/	
	

}
