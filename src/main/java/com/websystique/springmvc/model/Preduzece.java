package com.websystique.springmvc.model;

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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "PREDUZECE")
public class Preduzece {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PREDUZECE_ID")
	private int preduzeceId;
	
	@ManyToOne
	@JoinColumn(name="KONTAKT_OSOBA_ID")
	private User user;
	
	@Fetch(FetchMode.SUBSELECT)
	@OneToMany(cascade=CascadeType.ALL, mappedBy="preduzece", fetch = FetchType.EAGER)
	List<Vozilo> vozila = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name="MESTO_ID")
	private Mesto mesto;
	
	@Column(name = "NAZIV")
	private String naziv;
	
	@Column(name = "VLASNISTVO")
	private String vlasnistvo;
	
	@Column(name = "ULICA")
	private String ulica;
	
	@Column(name = "ULICNI_BROJ")
	private int ulicniBroj;

	public int getPreduzeceId() {
		return preduzeceId;
	}

	public void setPreduzeceId(int preduzeceId) {
		this.preduzeceId = preduzeceId;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getVlasnistvo() {
		return vlasnistvo;
	}

	public void setVlasnistvo(String vlasnistvo) {
		this.vlasnistvo = vlasnistvo;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public int getUlicniBroj() {
		return ulicniBroj;
	}

	public void setUlicniBroj(int ulicniBroj) {
		this.ulicniBroj = ulicniBroj;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public List<Vozilo> getVozila() {
		System.out.println("uzima listu vozila");
		return vozila;
	}

	public void setVozila(List<Vozilo> vozila) {
		this.vozila = vozila;
	}

	public Mesto getMesto() {
		return mesto;
	}

	public void setMesto(Mesto mesto) {
		this.mesto = mesto;
	}

	@Override
	public String toString() {
		return "Preduzece [preduzeceId=" + preduzeceId + ", user=" + user + ", vozila=" + vozila + ", mesto=" + mesto
				+ ", naziv=" + naziv + ", vlasnistvo=" + vlasnistvo + ", ulica=" + ulica + ", ulicniBroj=" + ulicniBroj
				+ "]";
	}

	
}
