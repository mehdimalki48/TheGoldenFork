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

import metier.entities.Menu;
import metier.entities.Order;
import metier.entities.OrderDetails;
import metier.entities.User;
import metier.session.SessionLocal;


@WebServlet(name="MainController", urlPatterns = { "/main", "/main.php", "/" })
@MultipartConfig
public class MainController extends HttpServlet {
	@EJB
	private SessionLocal metier;
	
	private Model model;


	private static final long serialVersionUID = 1L;
	//@Override
	public void init() throws ServletException {
		this.model = new Model();
        
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.model = new Model();
		model.setList_menus(this.metier.getMenus());
		
		final String username = request.getSession().getAttribute("username").toString();
//		if(username.isEmpty())
//			request.getRequestDispatcher("/WEB-INF/Login.jsp").forward((ServletRequest)request, (ServletResponse)response);

		
		request.setAttribute("model", (Object)this.model);
		request.getRequestDispatcher("/index.jsp").forward((ServletRequest)request, (ServletResponse)response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.model.setList_order_details(this.metier.getAllOrderDetails());
		this.model.setList_orders(this.metier.getOrders());
		this.model.setList_customers(this.metier.getCustomers());
		this.model.setList_users(this.metier.getUsers());
		final String action = request.getParameter("action");
		
		
		final String username = request.getSession().getAttribute("username").toString();
		final User user = this.metier.getUserByEmail(username);
		Order ordertmp = new Order();
		for (Order order : this.model.getList_orders()) {
			if(order.getUser().getUser_id() == user.getUser_id())
			{
				ordertmp = order;
			}
		}
		
		if(ordertmp.getOrder_id() == 0) throw new ServletException(" **************** User's Order Not Found **************");
		
		//System.out.println(":::::::::::::: THE USERNAME ::::::::: " + username);
		
		
		if(action.equals("addOrderdetail")) {
			final String menuidtmp = request.getParameter("menuid"); 
			final String menupricetmp = request.getParameter("menuprice");
			
			final int menuid = Integer.parseInt(menuidtmp);
			final double menuprice = Double.parseDouble(menupricetmp);
			final Menu menu = this.metier.getMenu(menuid);
			
			//(Order order, Menu menu, int no_of_serving, double total_amount)
			OrderDetails od = new OrderDetails(ordertmp, menu, 1, menuprice);
			
			this.metier.addOrderDetails(od);
			
			
		}
		
	}
}
