package com.cg.Dao;

import java.util.HashMap;

import com.cg.Exception.PaymentException;
import com.cg.bean.Account;
import com.cg.db.AccountDb;

public class WalletDaoImpl implements IWalletDao {
	private static HashMap<String, Account> AccountMap= AccountDb.getAccountEntry();


	@Override
	public String CreateAccount(Account account) throws PaymentException {
//		// TODO Auto-generated method stub
		if(AccountMap.containsKey(account.getPhoneNumber()))
		{
			throw new PaymentException(" Account with mobile number"+ account.getPhoneNumber()+" already exists");
		}
		AccountMap.put(account.getPhoneNumber(), account);
		return account.getPhoneNumber();
	}

	@Override
	public double ShowBalance(String mobileNo) throws PaymentException {
		// TODO Auto-generated method stub
		Account acc=AccountMap.get(mobileNo);
		if(acc==null){
			throw new PaymentException("Account with mobile number "+mobileNo+" does not exist");
				
			
		}
		return acc.getBalance();
		
		
	}

	@Override
	public Account deposit(String mobileNo, double deposit) throws PaymentException {
		Account acc=AccountMap.get(mobileNo);
		if(acc==null)
		{
			throw new PaymentException("Account with mobile number "+mobileNo+" does not exist");
		}
		return acc;
	}

	@Override
	public Account withdraw(String mobileNo, double withdraw) throws PaymentException {
		Account acc=AccountMap.get(mobileNo);
		if(acc==null)
		{
			throw new PaymentException("Account with mobile number "+mobileNo+" does not exist");
		}
		return acc;
	}

	@Override
	public Account FundTransfer(String mobileNo1, String mobileNo2,double transferAmt) throws PaymentException
	{
		// TODO Auto-generated method stub
		IWalletDao dao=new WalletDaoImpl();
		Account acc1=AccountMap.get(mobileNo1);
		Account acc2=AccountMap.get(mobileNo2);
		//double d;
		if(acc1==null){
			throw new PaymentException("account with source mobile does not exist");
		}	if(acc2==null){
			throw new PaymentException("account with destination mobile does not exist");
		}
		if(mobileNo1==mobileNo2){
			throw new PaymentException("transfer should be done to another account");
		}
		Account ac1=dao.withdraw(mobileNo1,transferAmt);
		Account ac2=dao.deposit(mobileNo2,transferAmt);
		return ac2 ;
		
	}

	@Override
	public Account printDetails(String mobile) throws PaymentException {
		Account acc=AccountMap.get(mobile);
		if(acc==null){
			throw new PaymentException("account with mobile does not exist");
		}
		return acc;
	}

	
		
		
	}


