package com.bank.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		//System.out.println("logicCall"+logicCall);
		String page=request.getParameter("page");
		
		//String accountNo=request.getParameter("accountNo");
		//System.out.println(accountNo);
		try {
			logicCall.writeDbInfo();
			logicCall.readDbInfo();
		}
		catch (CustomException e) {
			e.printStackTrace();
		}
			if(page.equals("CustomerDetails"))
			{
				request.setAttribute("cusMap",logicCall.customerMap);
				RequestDispatcher req=request.getRequestDispatcher("CustomerDetails.jsp");
				req.forward(request, response);
			}
			else if(page.equals("AccountDetails"))
			{
				request.setAttribute("accMap", logicCall.accountMap);
				RequestDispatcher req=request.getRequestDispatcher("AccountDetails.jsp");
				req.forward(request, response);
			}
			else if(page.equals("Deposit"))
			{
				RequestDispatcher req=request.getRequestDispatcher("Amount.jsp");
				req.forward(request, response);
			}
			else if(page.equals("WithDraw"))
			{
				RequestDispatcher req=request.getRequestDispatcher("Amount.jsp");
				req.forward(request, response);
			}
			else if(page.equals("Transfer to Account"))
			{
				RequestDispatcher req=request.getRequestDispatcher("TransfertoAccount.jsp");
				req.forward(request, response);
			}
			
	}

}
