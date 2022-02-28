package com.dbms;

import com.test.CustomException;
import com.test.HelperUtil;

public class AutoGenerate 
{
	static public long customerId=100000;
	static public long accountNo=20000;

public long addNewCustomerId()
{	
return ++customerId;		
}

public long addNewAccountNo()
{
return ++accountNo;	
}

public double setMinBalance() throws CustomException
{
	AccountInfo account= new AccountInfo();
	HelperUtil.nullCheckFile(account);
	account.setBalance(1000.00);
return 	account.getBalance();
}
}
