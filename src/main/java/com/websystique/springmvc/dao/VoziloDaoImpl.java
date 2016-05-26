package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Vozilo;

@Repository("VoziloDao")
public class VoziloDaoImpl extends AbstractDao<Integer, Vozilo> implements VoziloDao {

	public Vozilo findById(int id) {
		return getByKey(id);
	}

	public void saveVozilo(Vozilo vozilo) {
		persist(vozilo);
	}

	public void deleteVoziloBySsn(String ssn) {
		Query query = getSession().createSQLQuery("delete from Employee where ssn = :ssn");
		query.setString("ssn", ssn);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<Vozilo> findAllVozilo() {
		Criteria criteria = createEntityCriteria();
		return (List<Vozilo>) criteria.list();
	}

	public Vozilo findVoziloBySsn(String ssn) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("ssn", ssn));
		return (Vozilo) criteria.uniqueResult();
	}
}