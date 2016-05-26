package com.websystique.springmvc.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.CascadeType;

@Entity
@Table(name = "VOZILO")
public class Vozilo {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "VOZILO_ID")
	private int voziloId;
/*	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="VOZILO_ID", nullable = false)
	List<Potrosnja> potrosnja = new ArrayList<>();
*/
/*	
	@ManyToOne
	@JoinColumn(name="KATEGORIJA_VOZILA_ID")
	private KategorijaVozila kategorija;
*/	
	

	
	@ManyToMany(mappedBy="vozila", fetch=FetchType.LAZY)
	private List <Energent> energenti = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="PREDUZECE_ID")
	private Preduzece preduzece;
	
	@Column (name = "GODISTE")
	private Integer godiste;
	
	@Column (name = "MARKA")
	private String marka;
	
	@Column (name = "MODEL")
	private String model;
	
	@Column (name = "KUBIKAZA")
	private Integer kubikaza;
	
	@Column (name = "EMISIONA_KLASA_MOTORA")
	private String emisionaKlasa;
	
	
	public int getVoziloId() {
		return voziloId;
	}

	public void setVoziloId(int voziloId) {
		this.voziloId = voziloId;
	}

	public Integer getGodiste() {
		return godiste;
	}

	public void setGodiste(Integer godiste) {
		this.godiste = godiste;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getKubikaza() {
		return kubikaza;
	}

	public void setKubikaza(Integer kubikaza) {
		this.kubikaza = kubikaza;
	}

	public String getEmisionaKlasa() {
		return emisionaKlasa;
	}

	public void setEmisionaKlasa(String emisionaKlasa) {
		this.emisionaKlasa = emisionaKlasa;
	}
	
/*
	public List<Potrosnja> getPotrosnja() {
		return potrosnja;
	}

	public void setPotrosnja(List<Potrosnja> potrosnja) {
		this.potrosnja = potrosnja;
	}
*/
	public Preduzece getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(Preduzece preduzece) {
		this.preduzece = preduzece;
	}
/*
	public KategorijaVozila getKategorija() {
		return kategorija;
	}

	public void setKategorija(KategorijaVozila kategorija) {
		this.kategorija = kategorija;
	}
*/

	public List<Energent> getEnergenti() {
		return energenti;
	}

	public void setEnergenti(List<Energent> energenti) {
		this.energenti = energenti;
	}

	
	
	

}
