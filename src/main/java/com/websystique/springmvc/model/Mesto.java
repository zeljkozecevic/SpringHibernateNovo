package com.websystique.springmvc.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MESTO")
public class Mesto {
	
	@Id
	@GeneratedValue
	@Column(name = "MESTO_ID")
	private int mestoId;
	
//	@OneToMany(cascade=CascadeType.ALL, mappedBy="mesto")
//	List<Preduzece> preduzeca = new ArrayList<>();
	
	@Column(name = "ZIP")
	private Integer zip;
	
	@Column(name = "NAZIV")
	private String nazivMesta;
	
	@Column(name = "OKRUG")
	private String okrug;
	
	@Column(name = "OPSTINA")
	private String opstina;

	public int getMestoId() {
		return mestoId;
	}

	public void setMestoId(int mestoId) {
		this.mestoId = mestoId;
	}

	public Integer getZip() {
		return zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}

		
	public String getNazivMesta() {
		return nazivMesta;
	}

	public void setNazivMesta(String nazivMesta) {
		this.nazivMesta = nazivMesta;
	}

	public String getOkrug() {
		return okrug;
	}

	public void setOkrug(String okrug) {
		this.okrug = okrug;
	}

	public String getOpstina() {
		return opstina;
	}

	public void setOpstina(String opstina) {
		this.opstina = opstina;
	}
/*
	public List<Preduzece> getPreduzeca() {
		return preduzeca;
	}

	public void setPreduzeca(List<Preduzece> preduzeca) {
		this.preduzeca = preduzeca;
	}
*/	
	

}
