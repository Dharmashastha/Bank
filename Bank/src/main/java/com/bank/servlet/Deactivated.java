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
		
		HttpSession session=request.getSession();
		
		if(session.getAttribute("userId")==null)
		{
			RequestDispatcher req=request.getRequestDispatcher("BankLogin.jsp");
			req.forward(request, response);	
		}
		else
		{	
		BankLogic logicCall=(BankLogic) request.getServletContext().getAttribute("logicCall");
		
		String page=request.getParameter("page");
		
		request.setAttribute("accMap", logicCall.accountMap);
		
		if(page.equals("deactivated"))
		{
			String message = null;
		try {	
			String[] accountNo=request.getParameterValues("accountNo");
		
			HelperUtil.checkStringArray(accountNo);
		
		for(String no:accountNo)
		{
				HelperUtil.checkString(no);
				long accNo=Long.parseLong(no);
				logicCall.connect.updateStatus(accNo);
				
		}		
				logicCall.writeDbInfo();
				logicCall.readDbInfo();
				request.setAttribute("accMap", logicCall.accountMap);
				message="Deactivated Successful";				
		}
		catch (CustomException e) {
			message="Deactivated Failed";
				e.printStackTrace();
		}
		finally {
				request.setAttribute("deactivated", message);
				RequestDispatcher req=request.getRequestDispatcher("AccountDetails.jsp");
				req.forward(request, response);
		}
		}
		else if(page.equals("deactivatedaccountdetails"))
		{
		try {
				logicCall.writeDbInfo();
				logicCall.readDbInfo();
				request.setAttribute("accMap", logicCall.accountMap);
		}
		catch (CustomException e) {
			e.printStackTrace();
		}
		finally {
				RequestDispatcher req=request.getRequestDispatcher("ActiveAccount.jsp");
				req.forward(request, response);
		}
		}
	}
		
  }

}	
