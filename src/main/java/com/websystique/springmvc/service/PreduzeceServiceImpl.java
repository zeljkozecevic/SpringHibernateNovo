package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.PreduzeceDao;
import com.websystique.springmvc.model.Preduzece;

@Service("preduzeceService")
@Transactional
public class PreduzeceServiceImpl implements PreduzeceService {

	@Autowired
	private PreduzeceDao dao;
	
	public Preduzece findById(int id) {
		return dao.findById(id);
	}

	public void savePreduzece(Preduzece preduzece) {
		dao.savePreduzece(preduzece);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updatePreduzece(Preduzece preduzece) {
		
		System.out.println("usao u update preduzece");
		Preduzece entity = dao.findById(preduzece.getPreduzeceId());
		if(entity!=null){
			entity.setNaziv(preduzece.getNaziv());
			entity.setVlasnistvo(preduzece.getVlasnistvo());
			entity.setUlica(preduzece.getUlica());
			entity.setUlicniBroj(preduzece.getUlicniBroj());
			entity.setMesto(preduzece.getMesto());
			dao.savePreduzece(entity);
		}
	}

	public void deletePreduzeceById(int preduzeceId) {
		dao.deletePreduzeceById(preduzeceId);
	}
	
	public List<Preduzece> findAllPreduzece() {
		return dao.findAllPreduzece();
	}
	
	public List<Preduzece> findPreduzeceBy(String name) {
		return dao.findPreduzeceBy(name);
	}

	public Preduzece findPreduzeceBySsn(String ssn) {
		return dao.findPreduzeceBySsn(ssn);
	}

	public boolean isPreduzeceSsnUnique(Integer id, String ssn) {
		Preduzece preduzece = findPreduzeceBySsn(ssn);
		return ( preduzece == null || ((id != null) && (preduzece.getPreduzeceId() == id)));
	}
	
}
