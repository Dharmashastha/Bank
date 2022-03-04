package com.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbms.AutoGenerate;
import com.dbms.BankLogic;
import com.test.CustomException;


public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	
	
    public LoginServlet() {
        super();
    }
    
public void init(ServletConfig config)
{
	BankLogic logicCall=new BankLogic(true);
    AutoGenerate autoCall=new AutoGenerate();
	try {
		super.init(config);
		config.getServletContext().setAttribute("logicCall", logicCall);
		config.getServletContext().setAttribute("autoCall", autoCall);
	} catch (ServletException e) {
		e.printStackTrace();
	}
	config.getServletContext();
}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		
		BankLogic logicCall=(BankLogic) request.getServletContext().getAttribute("logicCall");
		PrintWriter out=response.getWriter();
	
		
		String userId=(request.getParameter("UserId"));
		String password=request.getParameter("Password");
		int roleId = 0;
		try {
			roleId=logicCall.connect.getRoleId(userId, password);
		} catch (CustomException e) {
			e.printStackTrace();
		}
		
		
		if(roleId == 1)
		{
			RequestDispatcher requ=request.getRequestDispatcher("CustomerOptions.jsp");
			requ.forward(request, response);
		}
		else if(roleId == 2)
		{
			RequestDispatcher requ=request.getRequestDispatcher("AdminOptions.jsp");
			requ.forward(request, response);
		}
		else
		{
			out.print("UserId And Password Invalid");
		}
		
	}

}
