package com.bank.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dbms.AccountInfo;
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
		
		HttpSession session=request.getSession();
		
		if(session.getAttribute("userId")==null)
		{
			RequestDispatcher req=request.getRequestDispatcher("BankLogin.jsp");
			req.forward(request, response);	
		}
		else
		{
		BankLogic logicCall=(BankLogic) request.getServletContext().getAttribute("logicCall");
		try {
			logicCall.writeDbInfo();
			logicCall.readDbInfo();
		}
		catch (CustomException e) {
			e.printStackTrace();
		}
		
		
		long id=(long) session.getAttribute("customerId");
		Map<Long,AccountInfo> accountMap=logicCall.accountMap.get(id);
		request.setAttribute("accMap", logicCall.accountMap);
		request.setAttribute("accountMap", accountMap);
		
		String page=request.getParameter("page");
		
		if(page.equals("TransferAmount"))
		{
			RequestDispatcher req=request.getRequestDispatcher("TransferAccount.jsp");
			req.forward(request, response);
		}
		else if(page.equals("AccountDetails"))
		{
			RequestDispatcher req=request.getRequestDispatcher("CustomerAccountDetails.jsp");
			req.forward(request, response);
		}
		else if(page.equals("LogOut"))
		{
			session.invalidate();
			RequestDispatcher req=request.getRequestDispatcher("BankLogin.jsp");
			req.forward(request, response);
		}
		
		}
	}

}
