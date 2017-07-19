package com.student.demo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.demo.pojo.User;
import com.student.demo.service.LoginService;

public class LoginServlet extends HttpServlet{
	
	private LoginService loginService = new LoginService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		
		Boolean status = loginService.validateUser(username, password);
		
		if(status){
			
			List<User> userList =   loginService.findAllUsers();
			
			req.setAttribute("userList", userList);
			
			
			req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
			
			//resp.sendRedirect("dashboard.jsp");
		}else{
			resp.sendRedirect("login.jsp");
		}
		
		
		
		
		
		
	}

}
