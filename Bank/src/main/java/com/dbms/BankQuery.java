package com.dbms;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;


import com.test.CustomException;
import com.test.InputCenter;

public class BankQuery implements Connected
{

	InputCenter inputCall= new InputCenter(); 
	Storage storeCall=new Storage();

public void createNewTableQuery(String newTable) throws CustomException
	{
		//newTable = "CREATE TABLE CustomerInfo(customerName VARCHAR(30),dob VARCHAR(30),address VARCHAR(30),customerId INT);";
		try(Statement state=ConnectionUtlity.getConnection().createStatement();)
		{
			if(state.execute(newTable))
			{
				System.out.println("Table Created.");
			}			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

/*public void insertValuesQuery() throws CustomException
	{
		
		//String  insertValue= "INSERT INTO Employee VALUES(105,'DHARMA');";
		try(Statement state=ConnectionUtlity.getConnection().createStatement();)
		{
		
			//state.executeUpdate(insertValue);
			//System.out.println("One Row Created.");
			System.out.println("Enter the Insert value Length:");
			int length=inputCall.getInt();
			//inputCall.getString();
			String[] insertArray=new String[length];
			for(int i=0; i <length;i++)
			{
				System.out.println("Enter the Insert Query:");
				insertArray[i]=inputCall.getString();
				state.executeUpdate(insertArray[i]);
			}
			System.out.println(length +" Row Created.");	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

public void updateQuery() throws CustomException 
	{
		String  update= "UPDATE Employee SET EmployeeName='DHARMASHASTHA S' WHERE EmployeeId=106";
		try(Statement state=ConnectionUtlity.getConnection().createStatement();)
		{
			
			int check=state.executeUpdate(update);
			if(check != 0)
			{
				System.out.println(check+" Row Updated.");
			}
			else
			{
				System.out.println("No data");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

public void deleteQuery() throws CustomException
	{
		String  delete= "DELETE FROM Employee WHERE EmployeeId=106";
		try(Statement state=ConnectionUtlity.getConnection().createStatement();)
		{
			
			int check=state.executeUpdate(delete);
			if(check != 0)
			{
				System.out.println(check+" Row Deleted.");
			}
			else
			{
				System.out.println("No data");
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

public void selectQuery() throws CustomException
	{
		String  select= "SELECT EmployeeId FROM Employee WHERE EmployeeName='dharma'";
		try(Statement state=ConnectionUtlity.getConnection().createStatement();
				ResultSet rs= state.executeQuery(select);)
		{
			if(rs.next())
			{
				System.out.println(rs.getInt(1));
				//System.out.println(rs.getString(2));
				System.out.println("Rows in set.");
			}
			else
			{
				System.out.println("No Data");
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/

public void insertCustInfo(String insert,String custName,String dob,String address,long customerId) throws CustomException
	{
		//String insert="INSERT INTO Employee VALUES(?,?)";
		try(PreparedStatement state=ConnectionUtlity.getConnection().prepareStatement(insert);)
			{			
				int length = 1;
				
				
					state.setString(1, custName);
					state.setString(2, dob);
					state.setString(3, address);
					state.setLong(4, customerId);
					state.executeUpdate();
					
				
				System.out.println(length +" Row Created.");	
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

public void insertAccInfo(String insert,long accountNo,double balance,long customerId,boolean status) throws CustomException
{
	//String insert="INSERT INTO Employee VALUES(?,?)";
	try(PreparedStatement state=ConnectionUtlity.getConnection().prepareStatement(insert);)
		{			
			int length = 1;
			
			
					state.setLong(1, accountNo);
					state.setDouble(2, balance);
					state.setLong(3, customerId);
					state.setBoolean(4, status);
				
					state.executeUpdate();
							
			System.out.println(length +" Row Created.");	
		} catch (SQLException e) {
			e.printStackTrace();
		}
}

public void updatePrepared(double balance,long accountNo) throws CustomException 
	{
		String update="UPDATE AccountInfo SET balance=? WHERE AccountNo=?";
		//String update= "UPDATE Employee SET EmployeeName=? WHERE EmployeeId=?";
		try(PreparedStatement state=ConnectionUtlity.getConnection().prepareStatement(update);)
		{
			state.setDouble(1,balance);
			state.setLong(2,accountNo);
			int check=state.executeUpdate();
			if(check != 0)
			{
				System.out.println(check+" Row Updated.");
			}
			else
			{
				System.out.println("No data");
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

public void updateStatus(long accountNo) throws CustomException 
{
	String update="UPDATE AccountInfo SET status=? WHERE AccountNo=?";
	//String update= "UPDATE Employee SET EmployeeName=? WHERE EmployeeId=?";
	try(PreparedStatement state=ConnectionUtlity.getConnection().prepareStatement(update);)
	{
		state.setBoolean(1,false);
		state.setLong(2,accountNo);
		int check=state.executeUpdate();
		if(check != 0)
		{
			System.out.println(check+" Row Updated.");
		}
		else
		{
			System.out.println("No data");
		}	
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

public void updateStatusActive(long accountNo) throws CustomException 
{
	String update="UPDATE AccountInfo SET status=? WHERE AccountNo=?";
	//String update= "UPDATE Employee SET EmployeeName=? WHERE EmployeeId=?";
	try(PreparedStatement state=ConnectionUtlity.getConnection().prepareStatement(update);)
	{
		state.setBoolean(1,true);
		state.setLong(2,accountNo);
		int check=state.executeUpdate();
		if(check != 0)
		{
			System.out.println(check+" Row Updated.");
		}
		else
		{
			System.out.println("No data");
		}	
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

public void updateCustomerInfo(String customerName,String dob,String address,long customerId) throws CustomException 
{
	String update="UPDATE CustomerInfo SET customerName=?,dob=?,address=? WHERE customerId=?";
	//String update= "UPDATE Employee SET EmployeeName=? WHERE EmployeeId=?";
	try(PreparedStatement state=ConnectionUtlity.getConnection().prepareStatement(update);)
	{
		state.setString(1,customerName);
		state.setString(2,dob);
		state.setString(3,address);
		state.setLong(4,customerId);
		
		int check=state.executeUpdate();
		if(check != 0)
		{
			System.out.println(check+" Row Updated.");
		}
		else
		{
			System.out.println("No data");
		}	
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
	
/*public void deletePrepared() throws CustomException 
	{
		String  delete= "DELETE FROM Employee WHERE EmployeeId=?";
		System.out.println("Enter the EmployeeId:");
		int id=inputCall.getInt();
		try(PreparedStatement state=ConnectionUtlity.getConnection().prepareStatement(delete);)
		{
			state.setInt(1, id);
			int check=state.executeUpdate();
			if(check != 0)
			{
				System.out.println(check+" Row Deleted.");
			}
			else
			{
				System.out.println("No data");
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

public void selectPrepared() throws CustomException
	{
		String  select= "SELECT *FROM Employee";
		try(PreparedStatement state=ConnectionUtlity.getConnection().prepareStatement(select);
				ResultSet rs= state.executeQuery();)
		{
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2));
			}
			System.out.println("Rows in set.");	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/

public Map<Long,CustomerInfo> getCustomerDb() throws CustomException
{
	Map<Long,CustomerInfo> custMap=new HashMap<>();
	
	String customer = "select *from CustomerInfo;";
	
	try(PreparedStatement state=ConnectionUtlity.getConnection().prepareStatement(customer);)
	{
		try(ResultSet rs= state.executeQuery();)
		{
			while(rs.next())
			{
			CustomerInfo custCall=new CustomerInfo();
		//	System.out.println(rs.getString(rs.getString("customerName")+" "+rs.getString("dob")+" "+rs.getString("address")+" "+rs.getLong("customerId")));
			String custName=rs.getString(1);
			String dob=rs.getString(2);
			String address=rs.getString(3);
			long custId=rs.getLong(4);
			custCall.setCustomerName(custName);
			custCall.setDob(dob);
			custCall.setAddress(address);
			custCall.setCustomerId(custId);
			custMap.put(custId, custCall);
			AutoGenerate.customerId=custId;
			}
		}	
	}
		catch (SQLException e) {
		e.printStackTrace();
	}
return custMap;	
}


public Map<Long,Map<Long, AccountInfo>> getAccountDb() throws CustomException
{

	String account = "select *from AccountInfo;";
	
	Map<Long, Map<Long, AccountInfo>> accMap=new HashMap<>();
	
	Map<Long,AccountInfo> tempMap;
	
	try(PreparedStatement stateAcc=ConnectionUtlity.getConnection().prepareStatement(account);)
	{
		try(ResultSet rs= stateAcc.executeQuery();)
		{
			while(rs.next())
			{
			AccountInfo accCall=new AccountInfo();
			long accNo=rs.getLong(1);
			double balance=rs.getDouble(2);
			long custId=rs.getLong(3);
			boolean status=rs.getBoolean(4);	
			accCall.setAccountNo(accNo);
			accCall.setBalance(balance);
			accCall.setCustomerId(custId);
			accCall.setStatus(status);
			tempMap=accMap.get(custId);
			AutoGenerate.accountNo=accNo;
			
			if(tempMap == null)
			{
				tempMap=new HashMap<>();
				accMap.put(custId, tempMap);
			}
			tempMap.put(accNo, accCall);
			}
			
		}	
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
return accMap;		
}

public int getRoleId(String userId,String password) throws CustomException
{
	
	String role="SELECT RoleId FROM Login WHERE UserId=? AND Password=?";
	int roleId = 0;
	try(PreparedStatement state=ConnectionUtlity.getConnection().prepareStatement(role);)
	{
		state.setString(1, userId);
		state.setString(2, password);		
		try(ResultSet rs= state.executeQuery();)
		{
			while(rs.next())
			{
				roleId=rs.getInt(1);
			}
		}	
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
return roleId;
}

public long getCustomerId(long accountNo) throws CustomException
{
	
	String customer="SELECT customerId FROM AccountInfo WHERE AccountNo=?";
	long customerId = 0;
	try(PreparedStatement state=ConnectionUtlity.getConnection().prepareStatement(customer);)
	{
		state.setLong(1, accountNo);		
		try(ResultSet rs= state.executeQuery();)
		{
			while(rs.next())
			{
				customerId=rs.getLong(1);
			}
		}	
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
return customerId;
}
@Override
public Map<Long, CustomerInfo> writeCustomerFile(Map<Long, CustomerInfo> custMap,
		Map<Long, Map<Long, AccountInfo>> accMap) throws CustomException {
	return null;
}

@Override
public Map<Long, Map<Long, AccountInfo>> writeAccountFile(Map<Long, CustomerInfo> custMap,
		Map<Long, Map<Long, AccountInfo>> accMap) throws CustomException {
	return null;
}

@Override
public Map<Long, CustomerInfo> getCustomerFile() throws CustomException {
	return null;
}

@Override
public Map<Long, Map<Long, AccountInfo>> getAccountFile() throws CustomException {
	return null;
}

@Override
public long getCustomerIdFile() throws CustomException {
	return 0;
}

@Override
public long getAccountNoFile() throws CustomException {
	return 0;
}
}
