package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Mesto;

public interface MestoService {

	Mesto findById(int id);
	
	void saveMesto(Mesto mesto);
	
	void updateMesto(Mesto mesto);
	
	void deleteMestoBySsn(String ssn);

	List<Mesto> findAllMesto(); 
	
	Mesto findMestoBySsn(String ssn);

	boolean isMestoSsnUnique(Integer id, String ssn);
	
}
