package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.User;

public interface UserService {

	User findById(int id);
	
	void saveUser(User User);
	
	void updateUser(User User);
	
	void deleteUserBySsn(String ssn);

	List<User> findAllUser(); 
	
	User findUserBySsn(String ssn);

	boolean isUserSsnUnique(Integer id, String ssn);
	
}
