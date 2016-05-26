package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.UserDao;
import com.websystique.springmvc.model.User;

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;
	
	public User findById(int id) {
		return dao.findById(id);
	}

	public void saveUser(User User) {
		dao.saveUser(User);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateUser(User User) {
		User entity = dao.findById(User.getUserId());
		if(entity!=null){
			entity.setFirstName(User.getFirstName());
			entity.setLastName(User.getLastName());
			entity.setZanimanje(User.getZanimanje());
			entity.setTelefon(User.getTelefon());
			entity.setFax(User.getFax());
			entity.setMobilni(User.getMobilni());
			entity.setEmailAddress(User.getEmailAddress());
			
			
		}
	}

	public void deleteUserBySsn(String ssn) {
		dao.deleteUserBySsn(ssn);
	}
	
	public List<User> findAllUser() {
		return dao.findAllUser();
	}

	public User findUserBySsn(String ssn) {
		return dao.findUserBySsn(ssn);
	}

	public boolean isUserSsnUnique(Integer id, String ssn) {
		User user = findUserBySsn(ssn);
		return ( user == null || ((id != null) && (user.getUserId() == id)));
	}
	
}
