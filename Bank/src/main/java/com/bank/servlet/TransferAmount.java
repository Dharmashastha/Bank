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
import com.test.HelperUtil;

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
		
		
			String fromAcc=request.getParameter("fromacc");
			String toAcc=request.getParameter("toacc");
			String amoun=request.getParameter("amount");
		
			HelperUtil.checkString(fromAcc);
			HelperUtil.checkString(toAcc);
			HelperUtil.checkString(amoun);
		
			long fromCustomer = 0;
			long toCustomer = 0;
			long fromAccount=Long.parseLong(fromAcc);
			long toAccount=Long.parseLong(toAcc);
			double amount=Double.parseDouble(amoun);
			
			fromCustomer = logicCall.connect.getCustomerId(fromAccount);
			toCustomer=logicCall.connect.getCustomerId(toAccount);
			
			logicCall.dbWithdraw(fromCustomer, fromAccount, amount);
			logicCall.dbDeposit(toCustomer, toAccount, amount);
			}
			catch (CustomException e) {
				e.printStackTrace();
			}
			finally {
				RequestDispatcher req=request.getRequestDispatcher("TransfertoAccount.jsp");
				req.forward(request, response);
			}
		}
		else if(page.equals("Submit"))
		{
			try {
				logicCall.writeDbInfo();
				logicCall.readDbInfo();
			
				String fromAcc=request.getParameter("fromAccNo");
				String toAcc=request.getParameter("toAccNo");
				String amoun=request.getParameter("Amount");
			
				HelperUtil.checkString(fromAcc);
				HelperUtil.checkString(toAcc);
				HelperUtil.checkString(amoun);
				
				long fromCustomer = 0;
				long toCustomer = 0;
				long fromAccount=Long.parseLong(fromAcc);
				long toAccount=Long.parseLong(toAcc);
				double amount=Double.parseDouble(amoun);
			
			
				fromCustomer = logicCall.connect.getCustomerId(fromAccount);
				toCustomer=logicCall.connect.getCustomerId(toAccount);
				
				logicCall.dbWithdraw(fromCustomer, fromAccount, amount);
				logicCall.dbDeposit(toCustomer, toAccount, amount);
				}
				catch (CustomException e) {
					e.printStackTrace();
				}
				finally {
					RequestDispatcher req=request.getRequestDispatcher("TransferAccount.jsp");
					req.forward(request, response);
				}	
			}
		}			
	}
}	
