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
       
	BankLogic logicCall=new BankLogic(true);
	
    public ShowDetails() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		try {
			logicCall.writeDbInfo();
		} catch (CustomException e) {
			e.printStackTrace();
		}
			try {
				logicCall.readDbInfo();
			} catch (CustomException e) {
				e.printStackTrace();
			}
			request.setAttribute("cusMap", logicCall.customerMap);	
			request.setAttribute("accMap", logicCall.accountMap);
			RequestDispatcher requ=request.getRequestDispatcher("AccountDetails.jsp");
			requ.forward(request, response);
	}

}
