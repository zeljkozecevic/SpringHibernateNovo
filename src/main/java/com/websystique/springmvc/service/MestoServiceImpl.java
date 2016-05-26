package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.MestoDao;
import com.websystique.springmvc.model.Mesto;

@Service("mestoService")
@Transactional
public class MestoServiceImpl implements MestoService {

	@Autowired
	private MestoDao dao;
	
	public Mesto findById(int id) {
		return dao.findById(id);
	}

	public void saveMesto(Mesto mesto) {
		dao.saveMesto(mesto);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateMesto(Mesto mesto) {
		Mesto entity = dao.findById(mesto.getMestoId());
		if(entity!=null){
			entity.setNazivMesta(mesto.getNazivMesta());
			entity.setZip(mesto.getZip());
			entity.setOkrug(mesto.getOkrug());
			entity.setOpstina(mesto.getOpstina());
		}
	}

	public void deleteMestoBySsn(String ssn) {
		dao.deleteMestoBySsn(ssn);
	}
	
	public List<Mesto> findAllMesto() {
		return dao.findAllMesto();
	}

	public Mesto findMestoBySsn(String ssn) {
		return dao.findMestoBySsn(ssn);
	}

	public boolean isMestoSsnUnique(Integer id, String ssn) {
		Mesto mesto = findMestoBySsn(ssn);
		return ( mesto == null || ((id != null) && (mesto.getMestoId() == id)));
	}
	
}
