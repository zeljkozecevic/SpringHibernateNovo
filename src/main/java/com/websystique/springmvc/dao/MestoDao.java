package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.Mesto;

public interface MestoDao {

	Mesto findById(int id);

	void saveMesto(Mesto mesto);
	
	void deleteMestoBySsn(String ssn);
	
	List<Mesto> findAllMesto();

	Mesto findMestoBySsn(String ssn);

}
