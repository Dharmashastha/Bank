package com.bank.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		
		
		boolean check=false;
		
		String id=request.getParameter("Username");
		String password=request.getParameter("Password");
		
		if(id.equals("1")&&password.equals("24"))
		{
			check=true;
		}
		if(check)
		{
			RequestDispatcher requ=request.getRequestDispatcher("AdminOptions.jsp");
			requ.forward(request, response);
		}
		else
		{
			RequestDispatcher requ=request.getRequestDispatcher("CustomerOptions.jsp");
			requ.forward(request, response);
		}
		
	}

}
