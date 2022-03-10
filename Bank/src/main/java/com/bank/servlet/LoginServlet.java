package com.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dbms.AccountInfo;
import com.dbms.AutoGenerate;
import com.dbms.BankLogic;
import com.test.CustomException;
import com.test.HelperUtil;


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
		HttpSession session=request.getSession();
		
		String userId=(request.getParameter("UserId"));
		String password=request.getParameter("Password");
		try {
			HelperUtil.checkString(userId);
			HelperUtil.checkString(password);
		
		
			session.setAttribute("userId", userId);
			session.setAttribute("password", password);
		
			logicCall.writeDbInfo();
			logicCall.readDbInfo();
		
			request.setAttribute("cusMap",logicCall.customerMap);
			request.setAttribute("accMap", logicCall.accountMap);		
		
		int roleId = 0;
		long customerId = 0;
			roleId=logicCall.connect.getRoleId(userId, password);
			customerId = logicCall.connect.getCustomer(userId);
		
			session.setAttribute("customerId", customerId);
		
		if(roleId == 1)
		{
			
			/*
			 * RequestDispatcher req=request.getRequestDispatcher("CustomerOptions.jsp");
			 * req.forward(request, response);
			 */
			long id=(long) session.getAttribute("customerId");
			Map<Long,AccountInfo> accountMap=logicCall.accountMap.get(id);
			request.setAttribute("accountMap", accountMap);
			RequestDispatcher requ=request.getRequestDispatcher("CustomerAccountDetails.jsp");
			requ.forward(request, response);
		}
		else if(roleId == 2)
		{
			/*
			 * RequestDispatcher req=request.getRequestDispatcher("AdminOptions.jsp");
			 * req.forward(request, response);
			 */
			
			RequestDispatcher requ=request.getRequestDispatcher("CustomerDetails.jsp");
			requ.forward(request, response);
		}
		else
		{
			out.print("UserId And Password Invalid");
		}
		
		}
		catch (CustomException e) {
			e.printStackTrace();
			RequestDispatcher req=request.getRequestDispatcher("BankLogin.jsp");
			req.forward(request, response);
		}	

	}
}
