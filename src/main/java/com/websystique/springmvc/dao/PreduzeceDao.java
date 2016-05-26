package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.Preduzece;

public interface PreduzeceDao {

	Preduzece findById(int id);

	void savePreduzece(Preduzece preduzece);
	
	void deletePreduzeceById(int preduzeceId);
	
	List<Preduzece> findAllPreduzece();
	
	List<Preduzece> findPreduzeceBy(String name);

	Preduzece findPreduzeceBySsn(String ssn);
	
	

}
