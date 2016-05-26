package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Preduzece;

public interface PreduzeceService {

	Preduzece findById(int id);
	
	void savePreduzece(Preduzece preduzece);
	
	void updatePreduzece(Preduzece preduzece);
	
	void deletePreduzeceById(int preduzeceId);

	List<Preduzece> findAllPreduzece();
	
	List<Preduzece> findPreduzeceBy(String name);
	
	Preduzece findPreduzeceBySsn(String ssn);

	boolean isPreduzeceSsnUnique(Integer id, String ssn);
	
}
