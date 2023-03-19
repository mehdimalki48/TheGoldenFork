package com.web.controllers;

import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.models.Model;

import metier.entities.Customer;
import metier.entities.Order;
import metier.entities.User;
import metier.session.SessionLocal;


@WebServlet(name = "Signup", urlPatterns = { "/signup", "/signup.php" })
@MultipartConfig(fileSizeThreshold = 1048576, maxFileSize = 5242880L, maxRequestSize = 26214400L)
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private SessionLocal metier;
	
	private Model model;
	
	


	public void init(ServletConfig config) throws ServletException {
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/Signin.jsp").forward((ServletRequest)request, (ServletResponse)response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final String action = request.getParameter("action");
		this.model = new Model();
		
		this.model.setList_users(this.metier.getUsers());
		
		if (action.equals("sign up")) {
			final String password = request.getParameter("password");
			final String cpassword = request.getParameter("cpassword");
			if(password.equals(cpassword)) {
				final String email = request.getParameter("email");
				
				if(this.metier.getUserByEmail(email) == null) {
					final String firstName = request.getParameter("firstName");
					final String familyName = request.getParameter("familyName");
					final String fullname = firstName + " " + familyName;
					final String contact_number = request.getParameter("contact");
					
					final String username = request.getParameter("firstName");
					
					User user1 = new User(fullname, contact_number, email, username, password);
					
					this.metier.addUser(user1);
					
					
					Customer customer = new Customer(1, email, firstName, null, familyName, null, password, null, username);
					this.metier.addCustomer(customer);
					
					this.metier.addOrder(new Order(customer, new Date(), 0, 0, user1));
					
					
					
					final HttpSession session = request.getSession();
	                session.setAttribute("username", (Object)email);

					
		            request.setAttribute("model", (Object)this.model);
		            request.getRequestDispatcher("/index.jsp").forward((ServletRequest)request, (ServletResponse)response);
		            
				} {
					// user with the same email route
					System.out.println("User with this email address already exists...");
				}
			} else {
				// pass != cpass route
				System.out.println("Password is not the same as the Confim field");
			}
			
		}
	}

}
