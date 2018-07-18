package com.cg.wallet.test;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;

import org.junit.Before;

import org.junit.Test;

import com.cg.wallet.beans.Account;

import com.cg.wallet.exception.WalletException;

import com.cg.wallet.service.IWalletService;

import com.cg.wallet.service.WalletServiceImpl;

public class WalletTest {

	private IWalletService service;

	@Before
	public void init() {

		service = new WalletServiceImpl();

	}

	@Test
	public void testCreateAccountForMobile() {

		Account ac = new Account();

		ac.setMobileNo("1114");

		ac.setName("Jones");

		ac.setEmail("jones@gmail.com");

		ac.setBalance(200.0);

		try {

			service.createAccount(ac);

		} catch (WalletException e) {

			Assert.assertEquals("Mobile number should contain 10 digits",
					e.getMessage());

		}

	}

	@Test
	public void testCreateAccountForName() {

		Account ac = new Account();

		ac.setMobileNo("1234567890");

		ac.setName("Sean_34");

		ac.setEmail("sean@gmail.com");

		ac.setBalance(500.0);

		try {

			service.createAccount(ac);

		} catch (WalletException e) {

			Assert.assertEquals(
					"Name should start with capital letter and should contain only alphabets",
					e.getMessage());

		}

	}

	@Test
	public void testCreateAccountForNameIsEmpty() {

		Account ac = new Account();

		ac.setMobileNo("1234567890");

		ac.setName("");

		ac.setEmail("janu@gmail.com");

		ac.setBalance(200.0);

		try {

			service.createAccount(ac);

		} catch (WalletException e) {

			Assert.assertEquals("Name cannot be empty", e.getMessage());

		}

	}

	@Test
	public void testCreateAccountForEmailId() {

		Account ac = new Account();

		ac.setMobileNo("1234567890");

		ac.setName("MarkAnthony");

		ac.setEmail("anthony@@23gmail.com");

		ac.setBalance(200.0);

		try {

			service.createAccount(ac);

		} catch (WalletException e) {

			Assert.assertEquals("Enter valid emailid", e.getMessage());

		}

	}

	@Test
	public void testCreateAccount() {

		Account ac = new Account();

		ac.setMobileNo("1234567890");

		ac.setName("Srija B");

		ac.setEmail("srija@gmail.com");

		ac.setBalance(200.0);

		try {

			String s = service.createAccount(ac);

			Assert.assertNotNull(s);

		} catch (WalletException e) {

			// System.out.println(e.getMessage());

		}

	}

	@Test
	public void testShowBalanceForMobileNo() {

		/*
		 * Account ac=new Account();
		 * 
		 * ac.setMobileNo("95059345");
		 */

		try {

			service.showBalance("95059");

		} catch (WalletException e) {

			// TODO Auto-generated catch block

			Assert.assertEquals("Mobile number should contain 10 digits",
					e.getMessage());

		}

	}

	@Test
	public void testShowBalanceForMobileNoDoesNotExist() {

		/*
		 * Account ac=new Account();
		 * 
		 * ac.setMobileNo("95059");
		 */

		try {

			service.showBalance("5641230505");

		} catch (WalletException e) {

			// TODO Auto-generated catch block

			Assert.assertEquals("The mobile number does not exist",
					e.getMessage());

		}

	}

	@Test
	public void testShowBalanceForName() {

		Account ac = new Account();

		ac.setMobileNo("9671129531");

		try {

			service.showBalance(ac.getMobileNo());

			assertEquals("Srija B", ac.getName());

		} catch (WalletException e) {

			// TODO Auto-generated catch block

			Assert.assertEquals("The mobile number does not exist",
					e.getMessage());

		}

	}

	@Test
	public void testDepositForMobileNo() {

		Account ac = new Account();

		ac.setMobileNo("900059345");

		try {

			service.deposit(ac.getMobileNo(), 230);

		} catch (WalletException e) {

			// TODO Auto-generated catch block

			Assert.assertEquals("Mobile number should contain 10 digits",
					e.getMessage());

		}

	}

	@Test
	public void testDepositForMobileNoDoesNotExist() {

		Account ac = new Account();

		ac.setMobileNo("9671129062");

		try {

			service.deposit(ac.getMobileNo(), 230);

		} catch (WalletException e) {

			// TODO Auto-generated catch block

			Assert.assertEquals("The mobile number does not exist",
					e.getMessage());

		}

	}

	@Test
	public void testDepositForDepositAmt1() {

		Account ac = new Account();

		ac.setMobileNo("9671129062");

		try {

			service.deposit(ac.getMobileNo(), -230);

		} catch (WalletException e) {

			// TODO Auto-generated catch block

			Assert.assertEquals("Deposit amount must be greater than zero",
					e.getMessage());

		}

	}

	@Test
	public void testDeposit() {

		Account ac = new Account();

		ac.setMobileNo("9671129062");

		try {

			Account ac1 = service.deposit(ac.getMobileNo(), 230);

			assertNotNull(ac1);

		} catch (WalletException e) {

			System.out.println(e.getMessage());

		}

	}

	@Test
	public void testWithDrawForMobileNo() {

		Account ac = new Account();

		ac.setMobileNo("99889345");

		try {

			service.withdraw(ac.getMobileNo(), 230);

		} catch (WalletException e) {

			// TODO Auto-generated catch block

			Assert.assertEquals("Mobile number should contain 10 digits",
					e.getMessage());

		}

	}

	@Test
	public void testWithdrawForMobileNoDoesNotExist() {

		Account ac = new Account();

		ac.setMobileNo("9671129062");

		try {

			service.withdraw(ac.getMobileNo(), 230);

		} catch (WalletException e) {

			// TODO Auto-generated catch block

			Assert.assertEquals("The mobile number does not exist",
					e.getMessage());

		}

	}

	@Test
	public void testWithdrawForAmt() {

		Account ac = new Account();

		ac.setMobileNo("9671129062");

		try {

			service.withdraw(ac.getMobileNo(), -230);

		} catch (WalletException e) {

			// TODO Auto-generated catch block

			Assert.assertEquals(
					"The amount to be withdrawn should be greater than available balance and greater than zero",
					e.getMessage());

		}

	}

	@Test
	public void testFundTransferForMobileNo() {

		Account ac = new Account();

		Account ac2 = new Account();

		ac.setMobileNo("95059345");

		ac2.setMobileNo("1234");

		try {

			service.fundTransfer(ac.getMobileNo(), ac2.getMobileNo(), 230);

		} catch (WalletException e) {

			// TODO Auto-generated catch block

			Assert.assertEquals("Mobile number should contain 10 digits",
					e.getMessage());

		}

	}

	@Test
	public void testFundTransferForMobileNoDoesNotExist() {

		Account ac = new Account();

		Account ac2 = new Account();

		ac.setMobileNo("9671129062");

		ac2.setMobileNo("9505934782");

		try {

			service.fundTransfer(ac.getMobileNo(), ac2.getMobileNo(), 230);

		} catch (WalletException e) {

			// TODO Auto-generated catch block

			Assert.assertEquals("The mobile number does not exist",
					e.getMessage());

		}

	}

	@Test
	public void testFundTransferForAmt() {

		Account ac = new Account();

		Account ac2 = new Account();

		ac.setMobileNo("9671129062");

		ac2.setMobileNo("9848468242");

		try {

			service.fundTransfer(ac.getMobileNo(), ac2.getMobileNo(), -230);

		} catch (WalletException e) {

			// TODO Auto-generated catch block

			Assert.assertEquals(
					"The amount to be withdrawn should be greater than available balance and greater than zero",
					e.getMessage());

		}

	}

	@Test
	public void testFundTransfer() {

		Account ac = new Account();

		Account ac2 = new Account();

		ac.setMobileNo("9671129062");

		ac2.setMobileNo("9848468242");

		try {

			assertTrue(service.fundTransfer(ac.getMobileNo(),
					ac2.getMobileNo(), 230));

		} catch (WalletException e) {

			// TODO Auto-generated catch block

			System.out.println(e.getMessage());

		}

	}

	@Test
	public void testPrinttransactionDetails() {

		Account ac = new Account();

		ac.setMobileNo("9848468242");

		try {

			Account acc = service.printTransactionDetails(ac.getMobileNo());

			assertNotNull(acc);

		} catch (WalletException e) {

			System.out.println(e.getMessage());

		}

	}

}