package com.student.demo.service;

import java.util.List;

import com.student.demo.dao.UserDao;
import com.student.demo.pojo.User;

public class LoginService {
	
	
	private UserDao dao = new UserDao();
	
	
	public User validateUser(String username,String password){
		
		// logic
		
		User user = dao.getUserByUsernameAndPassword(username, password);
		
		
		
		
		
		return user;
		
	}


	public List<User> findAllUsers() {
		
		return dao.findAll();
		
		
	}

}
