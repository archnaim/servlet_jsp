package com.javabootcamp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javabootcamp.dto.Cart;
import com.javabootcamp.dto.Product;
import com.javabootcamp.dto.User;
import com.javabootcamp.service.Carts;
import com.javabootcamp.service.CartsImpl;
import com.javabootcamp.service.Goods;
import com.javabootcamp.service.GoodsImpl;

/**
 * Servlet implementation class Commodity
 */
@WebServlet("/commodity")
public class Commodity extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Goods goods = new GoodsImpl();
	private Carts carts = new CartsImpl();
	List<Product> allProduct = new ArrayList<Product>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Commodity() {
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
		
		
		List<String> categories = goods.findCategories();
		
		
		request.setAttribute("categories", categories);
		
		String category = (String) request.getParameter("category");
		
		if(category==null)
		{
			this.allProduct = goods.findAll();
		}
		else {
			this.allProduct = goods.findByCategories(category);
			System.out.println(this.allProduct);
		}
		
		request.setAttribute("products", this.allProduct);
		
		request.getRequestDispatcher("commodity.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		Integer id = Integer.parseInt(request.getParameter("id"));
		Product product = this.allProduct.stream().filter(x->x.getId()==id).findFirst().get();
		User user = new User((int) session.getAttribute("user_id"), (String) session.getAttribute("username"));
		Cart cart = new Cart(0,user, product, 1);
		carts.save(cart);
		
		response.sendRedirect("report");
	}

}
