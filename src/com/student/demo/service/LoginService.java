package com.student.demo.service;

import java.util.List;

import com.student.demo.dao.UserDao;
import com.student.demo.pojo.User;

public class LoginService {
	
	
	private UserDao dao = new UserDao();
	
	
	public Boolean validateUser(String username,String password){
		
		
		User user = dao.getUserByUsernameAndPassword(username, password);
		
		if(user == null){
			return false;
		}else{
			return true;
		}
		
		
		
	}


	public List<User> findAllUsers() {
		
		return dao.findAll();
		
		
	}

}
