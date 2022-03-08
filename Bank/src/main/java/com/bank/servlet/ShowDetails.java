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


public class ShowDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowDetails() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		BankLogic logicCall=(BankLogic) request.getServletContext().getAttribute("logicCall");
		//System.out.println("logicCall:"+logicCall);
		String page=request.getParameter("page");
		HttpSession session=request.getSession();
		
				
	
		try {
			logicCall.writeDbInfo();
			logicCall.readDbInfo();
		}
		catch (CustomException e) {
			e.printStackTrace();
		}
		request.setAttribute("cusMap",logicCall.customerMap);
		request.setAttribute("accMap", logicCall.accountMap);
			if(page.equals("CustomerDetails"))
			{
				
				RequestDispatcher req=request.getRequestDispatcher("CustomerDetails.jsp");
				req.forward(request, response);
			}
			else if(page.equals("AccountDetails"))
			{
				RequestDispatcher req=request.getRequestDispatcher("AccountDetails.jsp");
				req.forward(request, response);
			}
			else if(page.equals("Deposit/WithDraw"))
			{
				RequestDispatcher req=request.getRequestDispatcher("Amount.jsp");
				req.forward(request, response);
			}
			else if(page.equals("TransferAmount"))
			{
				RequestDispatcher req=request.getRequestDispatcher("TransfertoAccount.jsp");
				req.forward(request, response);
			}
			else if(page.equals("LogOut"))
			{
				/*if(session.getAttribute("userId") != null && session.getAttribute("password") != null && session != null)
				{*/
				session.invalidate();
				/* } */
				
				RequestDispatcher req=request.getRequestDispatcher("BankLogin.jsp");
				req.forward(request, response);
			}
			
	}

}
