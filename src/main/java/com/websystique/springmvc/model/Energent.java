package com.websystique.springmvc.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "ENERGENT")
public class Energent {
	
	@Id
	@GeneratedValue
	@Column(name = "ENERGENT_ID")
	private int energentId;
	
	@Column(name = "NAZIV")
	private String naziv;
	
	@Column(name = "JEDINICA_MERE")
	private String jedinicaMere;
	
	@Column(name = "KALORIJSKA_VREDNOST")
	private Double kalorijskaVrednost;
	
	@Column(name = "EMISIJA_CO2")
	private Double emisija;
	
	

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "energent_has_vozilo", catalog = "voznipark", joinColumns = {
			@JoinColumn(name = "ENERGENT_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "VOZILO_ID", nullable = false, updatable = false) })
	private List<Vozilo> vozila = new ArrayList<>();

	public int getEnergentId() {
		return energentId;
	}

	public void setEnergentId(int energentId) {
		this.energentId = energentId;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getJedinicaMere() {
		return jedinicaMere;
	}

	public void setJedinicaMere(String jedinicaMere) {
		this.jedinicaMere = jedinicaMere;
	}

	public Double getKalorijskaVrednost() {
		return kalorijskaVrednost;
	}

	public void setKalorijskaVrednost(Double kalorijskaVrednost) {
		this.kalorijskaVrednost = kalorijskaVrednost;
	}

	public Double getEmisija() {
		return emisija;
	}

	public void setEmisija(Double emisija) {
		this.emisija = emisija;
	}

	public List<Vozilo> getVozila() {
		return vozila;
	}

	public void setVozila(List<Vozilo> vozila) {
		this.vozila = vozila;
	}

	
}
