package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Vozilo;

public interface VoziloService {

	Vozilo findById(int id);
	
	void saveVozilo(Vozilo vozilo);
	
	void updateVozilo(Vozilo vozilo);
	
	void deleteVoziloBySsn(String ssn);

	List<Vozilo> findAllVozilo(); 
	
	Vozilo findVoziloBySsn(String ssn);

	boolean isVoziloSsnUnique(Integer id, String ssn);
	
}
