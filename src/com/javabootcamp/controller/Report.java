package com.javabootcamp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javabootcamp.dto.Cart;
import com.javabootcamp.service.Carts;
import com.javabootcamp.service.CartsImpl;

/**
 * Servlet implementation class Report
 */
@WebServlet("/report")
public class Report extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Carts carts = new CartsImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Report() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		
		if(session.getAttribute("username") == null)
		{
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else {
			Integer user_id = (Integer) session.getAttribute("user_id");
			
			List<Cart> allcarts = carts.findByUserId(user_id);
			
			request.setAttribute("carts", allcarts);
			request.getRequestDispatcher("report.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user_id = request.getParameter("cart_id");
		
		carts.delete(new Cart(Integer.parseInt(user_id)));
		
		doGet(request, response);
	}
	
	

}
