package com.student.demo.service;

import com.student.demo.dao.UserDao;
import com.student.demo.pojo.User;

public class UserService {
	
	private UserDao userDao = new UserDao();
	
	
	public void deleteUserById(Integer id){
		
		userDao.delete(id);
		
		
		
	}


	public void saveUser(User user) {
		
		userDao.save(user);
	}


	public User getUserByUserId(Integer id) {
		return userDao.findById(id);
	}


	public void updareUser(User user) {
		userDao.update(user);
		
	}
	
	

}
