package com.bank.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbms.AccountInfo;
import com.dbms.AutoGenerate;
import com.dbms.BankLogic;
import com.test.CustomException;


public class AddClient extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    BankLogic logicCall=new BankLogic(true);
    AutoGenerate autoCall=new AutoGenerate();
    
    
    public AddClient() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		String client=request.getParameter("Details");
		String id=request.getParameter("id");
		String customerName=request.getParameter("custName");
		String dateOfBirth=request.getParameter("dob");
		String address=request.getParameter("address");
		long customerId=autoCall.addNewCustomerId();
		
		try {
			logicCall.writeDbInfo();
		} catch (CustomException e) {
			e.printStackTrace();
		}
		if(id==null)
		{
		if(client.equals("customer"))
		{
			String insert="INSERT INTO CustomerInfo VALUES(?,?,?,?)";
			
			try {
				
				logicCall.connect.insertCustInfo(insert, customerName, dateOfBirth, address, customerId);
				
			} catch (CustomException e) {
				e.printStackTrace();
			}
			RequestDispatcher requ=request.getRequestDispatcher("AddCustomer.jsp");
			requ.forward(request, response);
		}
		 if(client.equals("account"))
			{
				AccountInfo accCall=new AccountInfo();
				long accountNo=autoCall.addNewAccountNo();
				double balance=0;
				try {
					balance = autoCall.setMinBalance();
				} catch (CustomException e) {
					e.printStackTrace();
				}
				long custId=Long.parseLong(request.getParameter("customerId"));
				boolean status=accCall.isStatus();
				String insert="INSERT INTO AccountInfo VALUES(?,?,?,?)";
				try {
					logicCall.connect.insertAccInfo(insert, accountNo, balance, custId, status);
				} catch (CustomException e) {
					e.printStackTrace();
				}
				RequestDispatcher requ=request.getRequestDispatcher("AddAccount.jsp");
				requ.forward(request, response);
			}	
		}
		else  {
			
			try {
				long custId=Long.parseLong(id);
				logicCall.connect.updateCustomerInfo(customerName, dateOfBirth, address, custId);
				
				RequestDispatcher requ=request.getRequestDispatcher("AddCustomer.jsp");
				requ.forward(request, response);
			} catch (CustomException e) {
				e.printStackTrace();
			}
		}
		
	}

}
