package com.web.controllers;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = {"/index.do","/index.php"})
public class FilterPassword extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;





	public FilterPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//System.out.println("Filter");
		
		HttpServletRequest req=(HttpServletRequest)request;
		String pw=req.getParameter("password");
		if(pw!=null){
			{
				if(!pw.matches("[a-zA-Z].+@\\w+\\.\\w{2,3}"))
				{
					req.setAttribute("msgerreur","Erreur dans l email");
					req.getRequestDispatcher("/WEB-INF/index.jsp").include(req, response);
				}
				else 
				{
					chain.doFilter(request, response);
				}
				
			}
		}else 
		{
			chain.doFilter(request, response);

		}
		}
		
		
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Filter");
	}

}
