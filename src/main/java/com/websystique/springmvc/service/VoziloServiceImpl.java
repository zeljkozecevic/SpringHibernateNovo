package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.VoziloDao;
import com.websystique.springmvc.model.Vozilo;

@Service("VoziloService")
@Transactional
public class VoziloServiceImpl implements VoziloService {

	@Autowired
	private VoziloDao dao;
	
	public Vozilo findById(int id) {
		return dao.findById(id);
	}

	public void saveVozilo(Vozilo vozilo) {
		dao.saveVozilo(vozilo);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateVozilo(Vozilo Vozilo) {
		Vozilo entity = dao.findById(Vozilo.getVoziloId());
		if(entity!=null){
			entity.setGodiste(Vozilo.getGodiste());
			entity.setMarka(Vozilo.getMarka());
			entity.setKubikaza(Vozilo.getKubikaza());
			entity.setModel(Vozilo.getModel());
			entity.setEmisionaKlasa(Vozilo.getEmisionaKlasa());

			
			
		}
	}

	public void deleteVoziloBySsn(String ssn) {
		dao.deleteVoziloBySsn(ssn);
	}
	
	public List<Vozilo> findAllVozilo() {
		return dao.findAllVozilo();
	}

	public Vozilo findVoziloBySsn(String ssn) {
		return dao.findVoziloBySsn(ssn);
	}

	public boolean isVoziloSsnUnique(Integer id, String ssn) {
		Vozilo Vozilo = findVoziloBySsn(ssn);
		return ( Vozilo == null || ((id != null) && (Vozilo.getVoziloId() == id)));
	}
	
}
