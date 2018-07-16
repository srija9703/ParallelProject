package com.cg.db;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

import com.cg.bean.Account;



public class AccountDb {
	private static HashMap<String, Account> AccountEntry= new HashMap<String, Account>();
	public static HashMap<String, Account> getAccountEntry() {
		return AccountEntry;
	}
	
	static {

		AccountEntry.put("9989336633", new Account("9989336633", "Dharma", "dharma@cg.com", 200,LocalDateTime.now()));
		AccountEntry.put("9246110777", new Account("9246110777", "BGK", "bgk@cg.com", 200,LocalDateTime.now()));
		AccountEntry.put("9030345146", new Account("9030345146", "Rahul", "rahul@cg.com", 200,LocalDateTime.now()));
		AccountEntry.put("7893536669", new Account("7893536669", "Abhinay", "abhinay@cg.com", 200,LocalDateTime.now()));
		

}

}
