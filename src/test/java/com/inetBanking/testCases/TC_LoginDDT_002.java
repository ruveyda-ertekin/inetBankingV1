package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException {

		LoginPage lp = new LoginPage(driver);

		lp.setUserName(user);
		logger.info("Username provided");
		lp.setPassword(pwd);
		logger.info("Password provided");
		lp.clickSubmit();
		logger.info("Click submit button");

		Thread.sleep(3000);

		if (isAlertPresent() == true) {
			driver.switchTo().alert().accept(); // close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
			logger.warn("Login failed");

		} else {
			Assert.assertTrue(false);
			logger.info("Login passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept(); // close logout alert
			driver.switchTo().defaultContent();
		}

	}

	public boolean isAlertPresent() { // users defined method created to check is present or not

		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException {

		String path = System.getProperty("user.dir") + "/src/test/java/com/inetBanking/testData/LoginData.xlsx";

		int rowNum = XLUtils.getRowCount(path, "Sheet1");
		int colCount = XLUtils.getCellCount(path, "Sheet1", 1);

		String loginData[][] = new String[rowNum][colCount];

		for (int i = 1; i <= rowNum; i++) {
			for (int j = 0; j < colCount; j++) {
				loginData[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j); // 1 0
			}
		}
		return loginData;

	}

}
