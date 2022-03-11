package com.bank.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dbms.AccountInfo;
import com.dbms.AutoGenerate;
import com.dbms.BankLogic;
import com.test.CustomException;
import com.test.HelperUtil;

public class AddAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddAccount() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		HttpSession session=request.getSession();
		
		BankLogic logicCall=(BankLogic) request.getServletContext().getAttribute("logicCall");
		AutoGenerate autoCall=(AutoGenerate) request.getServletContext().getAttribute("autoCall");
		
		
		String accNo=request.getParameter("accno");	
		
		if(session.getAttribute("userId")==null)
		{
			RequestDispatcher req=request.getRequestDispatcher("BankLogin.jsp");
			req.forward(request, response);	
		}
		else {
			String message= null;
		try {
			String cusId=request.getParameter("customerId");
			HelperUtil.checkString(cusId);
		if(accNo == null || accNo.equals("null"))
		{
				AccountInfo accCall=new AccountInfo();
				long accountNo=autoCall.addNewAccountNo();
				double balance=0;
				balance = autoCall.setMinBalance();
				long custId=Long.parseLong(cusId);
				boolean status=accCall.isStatus();
				String insert="INSERT INTO AccountInfo VALUES(?,?,?,?)";
				logicCall.connect.insertAccInfo(insert, accountNo, balance, custId, status);
				message="New Account Created";		
		}	
		else
		{
				long accountNo=Long.parseLong(accNo);
				long custId=Long.parseLong(cusId);
				logicCall.connect.updateCustomerId(custId,accountNo);
				message="AccountDetails Updated";
				
		}
				request.setAttribute("Account", message);
		}
		catch (CustomException e) {
			if(accNo == null || accNo.equals("null"))
			{
				message="New Account Creation Failed";
				
			}
			else
			{
				message="AccountDetails Update Failed";
			}
			request.setAttribute("Account", message);
		}
		finally {
			
				RequestDispatcher requ=request.getRequestDispatcher("AddAccount.jsp");
				requ.forward(request, response);
		}
	 }
   }
 }

