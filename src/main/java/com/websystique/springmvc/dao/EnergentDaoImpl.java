package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Energent;

@Repository("EnergentDao")
public class EnergentDaoImpl extends AbstractDao<Integer, Energent> implements EnergentDao {

	public Energent findById(int id) {
		return getByKey(id);
	}

	public void saveEnergent(Energent energent) {
		persist(energent);
	}
	
	public void sacuvajEnergent(Energent energent) {
		save(energent);
	}

	public void deleteEnergentBySsn(String ssn) {
		Query query = getSession().createSQLQuery("delete from Employee where ssn = :ssn");
		query.setString("ssn", ssn);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<Energent> findAllEnergent() {
		Criteria criteria = createEntityCriteria();
		return (List<Energent>) criteria.list();
	}

	public Energent findEnergentBySsn(String ssn) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("ssn", ssn));
		return (Energent) criteria.uniqueResult();
	}
}