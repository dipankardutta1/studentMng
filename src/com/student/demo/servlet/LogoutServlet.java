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

public class LogoutServlet extends HttpServlet{
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getSession().invalidate();
		
		
		resp.sendRedirect("login.jsp");
		
		
	}
	

}
