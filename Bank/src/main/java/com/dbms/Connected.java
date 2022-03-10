package com.dbms;

import java.util.Map;

import com.test.CustomException;

public interface Connected 
{
	public Map<Long,CustomerInfo> writeCustomerFile
	(Map<Long,CustomerInfo> custMap,Map<Long,Map<Long,AccountInfo>> accMap) throws CustomException;
	public Map<Long,Map<Long,AccountInfo>> writeAccountFile
	(Map<Long,CustomerInfo> custMap,Map<Long,Map<Long,AccountInfo>> accMap) throws CustomException;
	public Map<Long,CustomerInfo> getCustomerFile() throws CustomException;
	public Map<Long, Map<Long, AccountInfo>> getAccountFile() throws CustomException;
	public long getCustomerIdFile() throws CustomException;
	public long getAccountNoFile() throws CustomException;
	public void createNewTableQuery(String newTable) throws CustomException;
	public void insertCustInfo(String insert,String custName,String dob,String address,long customerId) throws CustomException;
	public void insertAccInfo(String insert,long accountNo,double balance,long customerId,boolean status) throws CustomException;
	public void updateCustomerId(long customerId,long accountNo) throws CustomException;
	public void updatePrepared(double balance,long accountNo) throws CustomException;
	public void updateCustomerInfo(String customerName,String dob,String address,long customerId) throws CustomException;
	public void updateStatus(long accountNo) throws CustomException;
	public void updateStatusActive(long accountNo) throws CustomException; 
	public Map<Long,CustomerInfo> getCustomerDb() throws CustomException;
	public Map<Long,Map<Long, AccountInfo>> getAccountDb() throws CustomException;
	public int getRoleId(String userId,String password) throws CustomException;
	public long getCustomerId(long accountNo) throws CustomException;
	public long getCustomer(String userId) throws CustomException;
}