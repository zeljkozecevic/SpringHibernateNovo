package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Mesto;

@Repository("mestoDao")
public class MestoDaoImpl extends AbstractDao<Integer, Mesto> implements MestoDao {

	public Mesto findById(int id) {
		return getByKey(id);
	}

	public void saveMesto(Mesto mesto) {
		persist(mesto);
	}

	public void deleteMestoBySsn(String ssn) {
		Query query = getSession().createSQLQuery("delete from Employee where ssn = :ssn");
		query.setString("ssn", ssn);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<Mesto> findAllMesto() {
		Criteria criteria = createEntityCriteria();
		return (List<Mesto>) criteria.list();
	}

	public Mesto findMestoBySsn(String ssn) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("ssn", ssn));
		return (Mesto) criteria.uniqueResult();
	}
}