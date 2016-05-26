package com.websystique.springmvc.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Preduzece;

@Repository("preduzeceDao")
public class PreduzeceDaoImpl extends AbstractDao<Integer, Preduzece> implements PreduzeceDao {

	public Preduzece findById(int id) {
		return getByKey(id);
	}

	public void savePreduzece(Preduzece preduzece) {
		persist(preduzece);
	}

	public void deletePreduzeceById(int preduzeceId) {
		Query query = getSession().createSQLQuery("delete from preduzece where PREDUZECE_ID = :preduzeceId");
		System.out.println("ID preduzeca koji se brise je:" + preduzeceId);
		query.setInteger("preduzeceId", preduzeceId);
		query.executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	public List<Preduzece> findAllPreduzece() {
		Criteria criteria = createEntityCriteria();
//		Query query = getSession().createSQLQuery("select distinct * from preduzece");
		System.out.println("PREDUZECA SE PRIKAZUJU");
//		query.setInteger("preduzceId", preduzeceId);
//		List<Preduzece> list = new ArrayList<Preduzece>();
//		List <Preduzece> preduzeca =(List <Preduzece>) Arrays.asList(query.list());
//		List<Preduzece> list = new ArrayList <Preduzece> (Arrays.asList(query.list()));
//		for (Preduzece pred : preduzeca) {
//			System.out.println(pred);
//		}
//		 for (final Object o : query.list()) {
//	            list.add((Preduzece) o);
//	        }
//		query.executeUpdate();
		return (List<Preduzece>) criteria.list();
//		return (List<Preduzece>) query.list();
//		 return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Preduzece> findPreduzeceBy(String name) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.like("naziv", name));
		return (List<Preduzece>) criteria.list();
	}

	public Preduzece findPreduzeceBySsn(String ssn) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("ssn", ssn));
		return (Preduzece) criteria.uniqueResult();
	}
}
