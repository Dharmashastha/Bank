package com.bank.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbms.BankLogic;
import com.test.CustomException;

public class Amount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public Amount() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		BankLogic logicCall=(BankLogic) request.getServletContext().getAttribute("logicCall");
		long customerId = 0;
		try {
			logicCall.writeDbInfo();
			logicCall.readDbInfo();
		}
		catch (CustomException e) {
			e.printStackTrace();
		}
		
		long accountNo=Long.parseLong(request.getParameter("accNo"));
		try {
			customerId = logicCall.connect.getCustomerId(accountNo);
		} catch (CustomException e1) {
			e1.printStackTrace();
		}
		boolean check=Boolean.parseBoolean(request.getParameter("yesno"));
		double amount=Double.parseDouble(request.getParameter("amount"));
	
		try {
		if(check)
		{
			logicCall.dbDeposit(customerId, accountNo, amount);
			RequestDispatcher req=request.getRequestDispatcher("Amount.jsp");
			req.forward(request, response);
		}
		else
		{
			logicCall.dbWithdraw(customerId, accountNo, amount);
			RequestDispatcher req=request.getRequestDispatcher("Amount.jsp");
			req.forward(request, response);
		}
		} catch (CustomException e) {
			e.printStackTrace();
		}	
	}

}
