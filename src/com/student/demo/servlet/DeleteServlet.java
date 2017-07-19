package com.student.demo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.demo.pojo.User;
import com.student.demo.service.LoginService;
import com.student.demo.service.UserService;

public class DeleteServlet extends HttpServlet{
	
	private UserService userService = new UserService();
	
	private LoginService loginService = new LoginService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer id = Integer.valueOf(req.getParameter("id"));
		
		userService.deleteUserById(id);
		
		List<User> userList =   loginService.findAllUsers();
		
		req.setAttribute("userList", userList);
		
		
		req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
		
		
	}
	

}
