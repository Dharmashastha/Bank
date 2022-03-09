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

public class ActiveAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ActiveAccount() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

		
		HttpSession session=request.getSession();
		
		if(session.getAttribute("userId")==null)
		{
			RequestDispatcher req=request.getRequestDispatcher("BankLogin.jsp");
			req.forward(request, response);	
		}
		else
		{
		BankLogic logicCall = (BankLogic) request.getServletContext().getAttribute("logicCall");
		
		String[] accountNo=request.getParameterValues("accountno");
			for(String no:accountNo) 
			{
					long accNo=Long.parseLong(no);
			try {
					logicCall.connect.updateStatusActive(accNo); 
					logicCall.writeDbInfo();
					logicCall.readDbInfo();
				
					request.setAttribute("cusMap",logicCall.customerMap);
					request.setAttribute("accMap", logicCall.accountMap);
				} 
			catch (CustomException e) {
					e.printStackTrace();
				}
			}
			RequestDispatcher req = request.getRequestDispatcher("ActiveAccount.jsp");
			req.forward(request, response);
			}
	}

}
