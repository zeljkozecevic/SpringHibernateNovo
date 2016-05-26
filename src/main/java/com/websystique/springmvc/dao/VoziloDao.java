package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.Vozilo;

public interface VoziloDao {

	Vozilo findById(int id);

	void saveVozilo(Vozilo vozilo);
	
	void deleteVoziloBySsn(String ssn);
	
	List<Vozilo> findAllVozilo();

	Vozilo findVoziloBySsn(String ssn);

}
