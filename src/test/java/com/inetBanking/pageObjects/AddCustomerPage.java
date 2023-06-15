package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver ldriver;

	public AddCustomerPage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(how = How.XPATH, using = "//a[normalize-space()='New Customer']")
	@CacheLookup
	WebElement lnkAddNewCustomer;

	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement txtCustomerName;

	@FindBy(how = How.NAME, using = "rad1")
	@CacheLookup
	WebElement rdGender;

	@FindBy(how = How.ID_OR_NAME, using = "dob")
	@CacheLookup
	WebElement txtdob;

	@FindBy(how = How.NAME, using = "addr")
	@CacheLookup
	WebElement txtAddress;

	@FindBy(how = How.NAME, using = "city")
	@CacheLookup
	WebElement txtCity;

	@FindBy(how = How.NAME, using = "state")
	@CacheLookup
	WebElement txtState;

	@FindBy(how = How.NAME, using = "pinno")
	@CacheLookup
	WebElement txtPIN;

	@FindBy(how = How.NAME, using = "telephoneno")
	@CacheLookup
	WebElement txtMobileNumber;

	@FindBy(how = How.NAME, using = "emailid")
	@CacheLookup
	WebElement txtEmail;

	@FindBy(how = How.NAME, using = "password")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(how = How.NAME, using = "sub")
	@CacheLookup
	WebElement clickSubmitBttn;

	public void clickAddNewCustomer() {
		lnkAddNewCustomer.click();

	}

	public void customerName(String cname) {
		txtCustomerName.sendKeys(cname);

	}

	public void chooseRdGender(String cender) {
		rdGender.click();
	}

	public void customerdob(String mm, String dd, String yy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}

	public void customerAddress(String cAddress) {
		txtAddress.sendKeys(cAddress);

	}

	public void customerCity(String cCity) {
		txtCity.sendKeys(cCity);

	}

	public void customerState(String cState) {
		txtState.sendKeys(cState);

	}

	public void customerPIN(String cPIN) {
		txtPIN.sendKeys(String.valueOf(cPIN));
	}

	public void customerMobileNumber(String cMobileNumber) {
		txtMobileNumber.sendKeys(cMobileNumber);

	}

	public void customerEmail(String cEmail) {
		txtEmail.sendKeys(cEmail);

	}

	public void customerPassword(String cPassword) {
		txtPassword.sendKeys(cPassword);

	}

	public void customerSubmitBttn() {
		clickSubmitBttn.click();

	}

}
