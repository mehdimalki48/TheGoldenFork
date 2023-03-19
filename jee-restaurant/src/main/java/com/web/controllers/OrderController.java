package com.web.controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.models.Model;

import metier.session.SessionLocal;



@WebServlet(name = "Order", urlPatterns = { "/order", "/order.php" })
@MultipartConfig(fileSizeThreshold = 1048576, maxFileSize = 5242880L, maxRequestSize = 26214400L)
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	@EJB
    private SessionLocal metier;
	
    private Model model;
    
    public OrderController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.model = new Model();
		
		this.model.setList_orders(this.metier.getOrders());
		this.model.setList_customers(this.metier.getCustomers());
		this.model.setList_users(this.metier.getUsers());
		
		
		request.setAttribute("model", (Object)this.model);
		request.getRequestDispatcher("/Orders.jsp").forward((ServletRequest)request, (ServletResponse)response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
