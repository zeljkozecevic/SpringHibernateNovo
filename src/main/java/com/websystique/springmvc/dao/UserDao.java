package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.User;

public interface UserDao {

	User findById(int id);

	void saveUser(User User);
	
	void deleteUserBySsn(String ssn);
	
	List<User> findAllUser();

	User findUserBySsn(String ssn);

}
