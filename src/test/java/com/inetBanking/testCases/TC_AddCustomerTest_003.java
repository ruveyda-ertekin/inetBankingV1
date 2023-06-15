package com.inetBanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {

		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name provided");
		lp.setPassword(password);
		logger.info("Password provided");
		lp.clickSubmit();

		Thread.sleep(3000);

		AddCustomerPage addCustomer = new AddCustomerPage(driver);
		
		addCustomer.clickAddNewCustomer();
		
		logger.info("providing customer details....");
		
		addCustomer.customerName("Harry");
		addCustomer.chooseRdGender("male");
		addCustomer.customerdob("01", "01", "1990");

		Thread.sleep(3000);

		addCustomer.customerAddress("USA");
		addCustomer.customerCity("Chicago");
		addCustomer.customerState("Illinous");
		addCustomer.customerPIN("123456");
		addCustomer.customerMobileNumber("1234567898");

		String email = randomString() + "@gmail.com";
		addCustomer.customerEmail(email);

		addCustomer.customerPassword("1234");
		addCustomer.customerSubmitBttn();

		Thread.sleep(3000);

		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");

		if (res == true) {

			Assert.assertTrue(true);
			logger.info("test case passed....");
		} else {
			logger.info("test case failed....");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
			

		}
	}

	public String randomString() {

		String generatedString = RandomStringUtils.randomAlphabetic(8);
		return generatedString;

	}

	public static String randomNumber() {

		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);

	}

}
