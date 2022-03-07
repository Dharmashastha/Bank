package com.bank.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbms.BankLogic;
import com.test.CustomException;

public class Deactivated extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public Deactivated() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		BankLogic logicCall=(BankLogic) request.getServletContext().getAttribute("logicCall");
		
		String[] accountNo=request.getParameterValues("accountNo");
		for(String no:accountNo)
		{
			long accNo=Long.parseLong(no);
			try {
				logicCall.connect.updateStatus(accNo);
			} catch (CustomException e) {
				e.printStackTrace();
			}
		}
		RequestDispatcher req=request.getRequestDispatcher("AdminOptions.jsp");
		req.forward(request, response);
	}

}
