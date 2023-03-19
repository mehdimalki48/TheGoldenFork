package com.web.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.web.models.Model;

import metier.entities.Menu;
import metier.entities.MenuType;
import metier.session.SessionLocal;


/*
	@MultipartConfig(fileSizeThreshold=1024*1024*2, 
	maxFileSize=1024*1024*10, 
	maxRequestSize=1024*1024*50)
 */

@WebServlet(name = "Menus", urlPatterns = { "/menu", "/menu.do" })
@MultipartConfig
public class MenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
    private SessionLocal metier;
	
    private Model model;
    public static final String IMAGES_FOLDER = "MenusAssets";
    public String uploadPath;
    public String logoPath;
    
    
    public void init() throws ServletException {
		this.model = new Model();
		this.model.setList_menu_types(this.metier.getMenuTypes());
		this.model.setList_menus(this.metier.getMenus());
		
        this.uploadPath = this.getServletContext().getRealPath("MenusAssets");

        
		final File uploadDir = new File(this.uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.logoPath = "assets/images/logo.png";
		this.model = new Model();
		this.model.setList_menu_types(this.metier.getMenuTypes());
		this.model.setList_menus(this.metier.getMenus());
		
        request.setAttribute("model", (Object)this.model);
		request.getRequestDispatcher("/Menus.jsp").forward((ServletRequest)request, (ServletResponse)response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String action = request.getParameter("action");
		this.model = new Model();
		this.model.setList_menu_types(this.metier.getMenuTypes());
		
		if (action.equals("Enregistrer le menu")) {
	            final String ingredients = request.getParameter("ingredients");

	            final String menu_name = request.getParameter("titre");
	            final int menu_status = 1;
	            final double price = Double.parseDouble(request.getParameter("price"));

	            final String menuType = request.getParameter("category");
	            
	            final int menuTypeId = Integer.parseInt(menuType);
	            
	            MenuType mt = this.metier.getMenuType(menuTypeId);
	            
	            
	            this.uploadPath = request.getServletContext().getRealPath("MenusAssets");
	            
	            String monimage = null;
	            for (final Part part : request.getParts()) {
	                final String fileName = this.getFileName(part);
	                final String fullPath = String.valueOf(this.uploadPath) + File.separator + fileName;
	                if (fileName != null) {
	                    monimage = fileName;
	                    part.write(fullPath);
	                }
	            }
	            
	            
	            //C:\Users\malki\eclipse-workspace\jee-restaurant\src\main\webapp\assets\MenusAssets
	            
	            
	            // C:\ejb outils\wildfly-26.1.3.Final\standalone\deployments\GoldenFork.ear\jee-restaurant.war
	            // C:\ejb outils\wildfly-26.1.3.Final\standalone\deployments\GoldenFork.ear\jee-restaurant.war\MenusAssets\
	            
	            System.out.println("************** This Upload Path : " + this.uploadPath + "**************");
	            	
	            //String ingredients, String menu_image, String menu_name, int menu_status, double price, MenuType menuType
	            final Menu menu = new Menu(ingredients, "assets"+ File.separator+ monimage, menu_name, menu_status, price, mt);
	            this.metier.addMenu(menu);
	            this.model.setList_menus(this.metier.getMenus());
	            request.setAttribute("model", (Object)this.model);
	            request.getRequestDispatcher("/Menus.jsp").forward((ServletRequest)request, (ServletResponse)response);
		}
	}
	
	
	private String getFileName(final Part part) {
        String[] split;
        for (int length = (split = part.getHeader("content-disposition").split(";")).length, i = 0; i < length; ++i) {
            final String content = split[i];
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
            }
        }
        return null;
    }
}


/*
<%--                     <c:if test="${menu.menu_status == 1}"> --%>
<!--                     	<td>Active</td> -->
<%--                     </c:if> --%>
<%--                     <c:if test="${menu.menu_status == 0}"> --%>
<!--                     	<td>Inactive</td> -->
<%--                     </c:if> --%>  
*/