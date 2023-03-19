package com.web.controllers;

import java.io.IOException;
import java.util.ArrayList;

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

import metier.entities.User;
import metier.session.SessionLocal;



@WebServlet(name = "Login", urlPatterns = { "/login", "/login.php" })
@MultipartConfig(fileSizeThreshold = 1048576, maxFileSize = 5242880L, maxRequestSize = 26214400L)
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	private SessionLocal metier;
	
	private Model model;
	
	
	
	
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/Login.jsp").forward((ServletRequest)request, (ServletResponse)response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String action = request.getParameter("action");
		this.model = new Model();
		this.model.setList_users(this.metier.getUsers());
		
		if (action.equals("login")) {
			final String email = request.getParameter("email");
			final String password = request.getParameter("password");
			
			if (email.isEmpty() || isValidEmail(email)) {
				ArrayList<User> users = this.model.getList_users();
				
				for (User user : users) {
					if (user.getEmail_address().equals(email)) {
						if(user.getPassword().equals(password)) {
							final HttpSession session = request.getSession();
			                session.setAttribute("username", (Object)email);
							request.setAttribute("model", (Object)this.model);
							request.getRequestDispatcher("/index.jsp").forward((ServletRequest)request, (ServletResponse)response);
						}
					}
				}
			} else {
				System.out.println("Email Format is not valid...");
			}
		}
	}
	
	
	public static boolean isValidEmail(String email) {
	    String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
	    return email.matches(regex);
	}

}
