package com.bank.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbms.BankLogic;
import com.test.CustomException;


public class AddClient extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    BankLogic logicCall=new BankLogic(true);
    
    public AddClient() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		String client=request.getParameter("Details");

		if(client.equals("customer"))
		{
			String customerName=request.getParameter("custName");
			String dateOfBirth=request.getParameter("dob");
			String address=request.getParameter("address");
			long customerId=logicCall.connect.addNewCustomerId();
			String insert="INSERT INTO CustomerInfo VALUES(?,?,?,?)";
			try {
				logicCall.connect.insertCustInfo(insert, customerName, dateOfBirth, address, customerId);
			} catch (CustomException e) {
				e.printStackTrace();
			}
		}
		if(client.equals("account"))
		{
			long accountNo=logicCall.connect.addNewAccountNo();
			double balance=Double.parseDouble(request.getParameter("balance"));
			long customerId=Long.parseLong(request.getParameter("customerId"));
			boolean status=Boolean.parseBoolean(request.getParameter("yesno"));
			String insert="INSERT INTO AccountInfo VALUES(?,?,?,?)";
			try {
				logicCall.connect.insertAccInfo(insert, accountNo, balance, customerId, status);
			} catch (CustomException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
