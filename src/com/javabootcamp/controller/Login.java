package com.javabootcamp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javabootcamp.dto.User;
import com.javabootcamp.service.Authentication;
import com.javabootcamp.service.AuthenticationImpl;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	
	private Authentication auth;
	
	public Login() {
		// TODO Auto-generated constructor stub
		this.auth = new AuthenticationImpl();
	}
	
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		User user = new User(request.getParameter("uname"),request.getParameter("psw"));
		
		HttpSession session = request.getSession(true);
		
		Integer user_id = this.auth.authorized(user);
		
		if(user_id>-1)
		{
			System.out.println("Authorized");
			session.setAttribute("username", user.getUsername());
			session.setAttribute("user_id", user_id);
			response.sendRedirect("commodity");
		}
		else
		{
			System.out.println("No");
			response.sendRedirect("login");
		}
		
	}

}
