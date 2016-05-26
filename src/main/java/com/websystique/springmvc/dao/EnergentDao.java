package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.Energent;

public interface EnergentDao {

	Energent findById(int id);

	void saveEnergent(Energent energent);
	
	void sacuvajEnergent(Energent energent);
	
	void deleteEnergentBySsn(String ssn);
	
	List<Energent> findAllEnergent();

	Energent findEnergentBySsn(String ssn);

}
