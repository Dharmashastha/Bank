package com.bank.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		HttpSession session=request.getSession();
		
		if(session.getAttribute("userId")==null)
		{
			RequestDispatcher req=request.getRequestDispatcher("BankLogin.jsp");
			req.forward(request, response);	
		}
		else
		{	
		String page=request.getParameter("page");
		BankLogic logicCall=(BankLogic) request.getServletContext().getAttribute("logicCall");

		
		if(page.equals("submit"))
		{	
		try {
			logicCall.writeDbInfo();
			logicCall.readDbInfo();
		}
		catch (CustomException e) {
			e.printStackTrace();
		}
		long fromAccount=Long.parseLong(request.getParameter("fromacc"));
		long fromCustomer = 0;
		long toCustomer = 0;
		long toAccount=Long.parseLong(request.getParameter("toacc"));
		
		double amount=Double.parseDouble(request.getParameter("amount"));
		try {
			fromCustomer = logicCall.connect.getCustomerId(fromAccount);
			toCustomer=logicCall.connect.getCustomerId(toAccount);
		} catch (CustomException e1) {
			e1.printStackTrace();
		}
		try {
			logicCall.dbWithdraw(fromCustomer, fromAccount, amount);
			logicCall.dbDeposit(toCustomer, toAccount, amount);
		} catch (CustomException e) {
			e.printStackTrace();
		}
		RequestDispatcher req=request.getRequestDispatcher("TransfertoAccount.jsp");
		req.forward(request, response);
		}
		else if(page.equals("Submit"))
		{
			
			try {
				logicCall.writeDbInfo();
				logicCall.readDbInfo();
			}
			catch (CustomException e) {
				e.printStackTrace();
			}
			long fromAccount=Long.parseLong(request.getParameter("fromAccNo"));
			long fromCustomer = 0;
			long toCustomer = 0;
			long toAccount=Long.parseLong(request.getParameter("toAccNo"));
			
			double amount=Double.parseDouble(request.getParameter("Amount"));
			try {
				fromCustomer = logicCall.connect.getCustomerId(fromAccount);
				toCustomer=logicCall.connect.getCustomerId(toAccount);
			} catch (CustomException e1) {
				e1.printStackTrace();
			}
			try {
				logicCall.dbWithdraw(fromCustomer, fromAccount, amount);
				logicCall.dbDeposit(toCustomer, toAccount, amount);
			} catch (CustomException e) {
				e.printStackTrace();
			}
			RequestDispatcher req=request.getRequestDispatcher("TransferAccount.jsp");
			req.forward(request, response);
			}	
		}
	}
			
	}
