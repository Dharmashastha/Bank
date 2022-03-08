package com.bank.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbms.BankLogic;
import com.test.CustomException;

public class CustomerOptions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CustomerOptions() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		BankLogic logicCall=(BankLogic) request.getServletContext().getAttribute("logicCall");
		try {
			logicCall.writeDbInfo();
			logicCall.readDbInfo();
		}
		catch (CustomException e) {
			e.printStackTrace();
		}
		request.setAttribute("accMap", logicCall.accountMap);
		
		String page=request.getParameter("page");
		
		if(page.equals("TransferAmount"))
		{
			RequestDispatcher req=request.getRequestDispatcher("TransferAccount.jsp");
			req.forward(request, response);
		}
	}

}
