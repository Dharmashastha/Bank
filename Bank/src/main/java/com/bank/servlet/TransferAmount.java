package com.bank.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbms.BankLogic;
import com.test.CustomException;

public class TransferAmount extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
		
	
    public TransferAmount() {
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
		long fromCustomer=Long.parseLong(request.getParameter("fromcust"));
		long fromAccount=Long.parseLong(request.getParameter("fromacc"));
		long toCustomer=Long.parseLong(request.getParameter("tocust"));
		long toAccount=Long.parseLong(request.getParameter("toacc"));
		double amount=Double.parseDouble(request.getParameter("amount"));
		
		try {
			logicCall.dbWithdraw(fromCustomer, fromAccount, amount);
			logicCall.dbDeposit(toCustomer, toAccount, amount);
		} catch (CustomException e) {
			e.printStackTrace();
		}
		RequestDispatcher req=request.getRequestDispatcher("TransfertoAccount.jsp");
		req.forward(request, response);
		
	}

}
