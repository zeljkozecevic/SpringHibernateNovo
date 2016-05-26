package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Energent;

public interface EnergentService {

	Energent findById(int id);
	
	void saveEnergent(Energent energent);
	
	void sacuvajEnergent(Energent energent);
	
	void updateEnergent(Energent energent);
	
	void deleteEnergentBySsn(String ssn);

	List<Energent> findAllEnergent(); 
	
	Energent findEnergentBySsn(String ssn);

	boolean isEnergentSsnUnique(Integer id, String ssn);
	
}
