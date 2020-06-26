package com.student.demo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.student.demo.pojo.User;
import com.student.demo.service.LoginService;

public class LoginServlet extends HttpServlet{
	
	private LoginService loginService = new LoginService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		
		User user = loginService.validateUser(username, password);
		
		if(user == null){
			resp.sendRedirect("login.jsp?msg=Wrong USername and Password");
		}else{
			
			
			HttpSession session  = req.getSession();
			
			session.setAttribute("user",user);
			
			List<User> userList = loginService.findAllUsers();
			
			req.setAttribute("userList",userList);
			
			
			req.getRequestDispatcher("welcome.jsp").forward(req, resp);
			
			//resp.sendRedirect("welcome.jsp");
		}
		
		
		/*
		 * if(status){
		 * 
		 * List<User> userList = loginService.findAllUsers();
		 * 
		 * req.setAttribute("userList", userList);
		 * 
		 * 
		 * req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
		 * 
		 * //resp.sendRedirect("dashboard.jsp"); }else{ resp.sendRedirect("login.jsp");
		 * }
		 */
		
		
		
		
		
		
	}

}
