package com.bank.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dbms.AutoGenerate;
import com.dbms.BankLogic;
import com.test.CustomException;
import com.test.HelperUtil;


public class AddClient extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
    public AddClient() {
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
		
		String id=request.getParameter("id");
		
		if(session.getAttribute("userId")==null)
		{
			RequestDispatcher req=request.getRequestDispatcher("BankLogin.jsp");
			req.forward(request, response);	
		}
		else {	
		try {
			String customerName=request.getParameter("custName");
			String dateOfBirth=request.getParameter("dob");
			String address=request.getParameter("address");
			long customerId=autoCall.addNewCustomerId();

			HelperUtil.checkString(customerName);
			HelperUtil.checkString(dateOfBirth);
			HelperUtil.checkString(address);		
		
		if(id==null || id.equals("null"))
		{
			String insert="INSERT INTO CustomerInfo VALUES(?,?,?,?)";
			logicCall.connect.insertCustInfo(insert, customerName, dateOfBirth, address, customerId);				
		}	
		else  
		{	
				long custId=Long.parseLong(id);
				logicCall.connect.updateCustomerInfo(customerName, dateOfBirth, address, custId);
		}
		}
		catch (CustomException e) {
				e.printStackTrace();
		}
		finally
		{
			RequestDispatcher requ=request.getRequestDispatcher("AddCustomer.jsp");
			requ.forward(request, response);
		}
	  }	
   }
}