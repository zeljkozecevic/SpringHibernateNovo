package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.EnergentDao;
import com.websystique.springmvc.model.Energent;

@Service("EnergentService")
@Transactional
public class EnergentServiceImpl implements EnergentService {

	@Autowired
	private EnergentDao dao;
	
	public Energent findById(int id) {
		return dao.findById(id);
	}

	public void saveEnergent(Energent Energent) {
		dao.saveEnergent(Energent);
	}
	
	public void sacuvajEnergent(Energent Energent) {
		dao.sacuvajEnergent(Energent);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateEnergent(Energent Energent) {
		Energent entity = dao.findById(Energent.getEnergentId());
		if(entity!=null){
			entity.setNaziv(Energent.getNaziv());
			entity.setJedinicaMere(Energent.getJedinicaMere());
			entity.setKalorijskaVrednost(Energent.getKalorijskaVrednost());
			entity.setEmisija(Energent.getEmisija());
		}
	}

	public void deleteEnergentBySsn(String ssn) {
		dao.deleteEnergentBySsn(ssn);
	}
	
	public List<Energent> findAllEnergent() {
		return dao.findAllEnergent();
	}

	public Energent findEnergentBySsn(String ssn) {
		return dao.findEnergentBySsn(ssn);
	}

	public boolean isEnergentSsnUnique(Integer id, String ssn) {
		Energent energent = findEnergentBySsn(ssn);
		return ( energent == null || ((id != null) && (energent.getEnergentId() == id)));
	}
	
}
