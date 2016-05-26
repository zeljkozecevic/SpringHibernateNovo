package com.websystique.springmvc.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

@Entity
@Table(name = "KONTAKT_OSOBA")
public class User {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name = "KONTAKT_OSOBA_ID")
	private int userId;
	
	@OneToMany(cascade=CascadeType.MERGE, mappedBy="user")
	List<Preduzece> preduzece = new ArrayList<>();

	@Column(name = "IME")
	private String firstName;

	@Column(name = "PREZIME")
	private String lastName;

	@Column(name = "ZANIMANJE")
	private String zanimanje;
	
	@Column(name = "TELEFON")
	private String telefon;
	
	@Column(name = "FAX")
	private String fax;
	
	@Column(name = "MOBILNI")
	private String mobilni;
	
	@Column(name = "MAIL")
	private String emailAddress;

	public String getZanimanje() {
		return zanimanje;
	}

	public void setZanimanje(String zanimanje) {
		this.zanimanje = zanimanje;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getMobilni() {
		return mobilni;
	}

	public void setMobilni(String mobilni) {
		this.mobilni = mobilni;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public List<Preduzece> getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(List<Preduzece> preduzece) {
		this.preduzece = preduzece;
	}


}
