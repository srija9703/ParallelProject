package com.cg.wallet.db;

import java.time.LocalDate;

import java.time.LocalDateTime;

import java.time.Month;

import java.util.HashMap;







import com.cg.wallet.beans.Account;



public class WalletDb {

private static HashMap<String,Account> walletDb=new HashMap<String,Account>();

public static HashMap<String, Account> getWalletMap() {

return walletDb;

}

Account obj=new Account();

static{

	

walletDb.put("9671129062",new Account("9671129062","Srija","srija@gmail.com",2000.0,LocalDateTime.now()));

walletDb.put("9948716777",new Account("9948716777","Naresh","naresh@gmail.com",1000.0,LocalDateTime.now()));

walletDb.put("9848468242",new Account("9848468242","Hemanya","hema@gmail.com",1500.0,LocalDateTime.now()));

walletDb.put("9701978539",new Account("9701978539","Mark","mark@gmail.com",2000.0,LocalDateTime.now()));

}

}