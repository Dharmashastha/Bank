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
		
		HttpSession session=request.getSession();
		
		if(session.getAttribute("userId")==null)
		{
			RequestDispatcher req=request.getRequestDispatcher("BankLogin.jsp");
			req.forward(request, response);	
		}
		else
		{
		BankLogic logicCall=(BankLogic) request.getServletContext().getAttribute("logicCall");
		long customerId = 0;
		boolean check = false;
		try {
			logicCall.writeDbInfo();
			logicCall.readDbInfo();
		
			String accNo=request.getParameter("accNo");
			String status=request.getParameter("yesno");
			String amoun=request.getParameter("amount");
			HelperUtil.checkString(accNo);
			HelperUtil.checkString(status);
			HelperUtil.checkString(amoun);
		
			long accountNo=Long.parseLong(accNo);	
			check=Boolean.parseBoolean(status);
			double amount=Double.parseDouble(amoun);
			customerId = logicCall.connect.getCustomerId(accountNo);
	
		if(check)
		{
			logicCall.dbDeposit(customerId, accountNo, amount);
			request.setAttribute("Deposit", "Deposit Successful");
		}
		else
		{
			logicCall.dbWithdraw(customerId, accountNo, amount);
			request.setAttribute("Withdraw", "Withdraw Successful");
		}
		}
		catch (CustomException e) {
			
		if(check)
		{
			request.setAttribute("Deposit", e.getMessage());
		}
		else
		{	
			request.setAttribute("Withdraw", e.getMessage());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		}
		finally {
			RequestDispatcher req=request.getRequestDispatcher("Amount.jsp");
			req.forward(request, response);
		}
		}
	}

}
