package com.web.controllers;

import java.io.File;
import java.io.IOException;

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

import com.web.models.Model;

import metier.entities.MenuType;
import metier.session.SessionLocal;


@WebServlet(name = "MenuType", urlPatterns = { "/menutype", "/menutype.php" })
@MultipartConfig(fileSizeThreshold = 1048576, maxFileSize = 5242880L, maxRequestSize = 26214400L)
public class MenuTypeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    @EJB
    private SessionLocal metier;
    private Model model;
    public static final String IMAGES_FOLDER = "assests";
    public String uploadPath;
    
    
    
    public void init() throws ServletException {
		this.model = new Model();
        /*this.uploadPath = this.getServletContext().getRealPath("assets");
        final File uploadDir = new File(this.uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }*/
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.model = new Model();
		this.model.setList_menu_types(this.metier.getMenuTypes());
        request.setAttribute("model", (Object)this.model);
		request.getRequestDispatcher("/MenuType.jsp").forward((ServletRequest)request, (ServletResponse)response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final String action = request.getParameter("action");
		
		if (action.equals("Enregistrer le type de menu")) {
	            final String type_name = request.getParameter("titre");
	            final String description = request.getParameter("description");
	            
	            final MenuType menuType = new MenuType(description, type_name);
	            this.metier.addMenuType(menuType);
	            this.model.setList_menu_types(this.metier.getMenuTypes());
	            request.setAttribute("model", (Object)this.model);
	            request.getRequestDispatcher("/MenuType.jsp").forward((ServletRequest)request, (ServletResponse)response);
            }
		}

}
