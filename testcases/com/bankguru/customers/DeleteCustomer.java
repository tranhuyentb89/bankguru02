package com.bankguru.customers;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageFactoryManage;
import pageObjects.DeleteCustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObjects;
import pageObjects.NewCustomerPageObject;

public class DeleteCustomer extends AbstractTest{
	WebDriver driver;
	NewCustomerPageObject newCustomerPage;
	LoginPageObjects loginPage;
	DeleteCustomerPageObject deleteCustomerPage;
	HomePageObject homePage;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);
		loginPage = PageFactoryManage.getLoginPage(driver);
		loginPage.inputToUserIDTextbox(Account_RegisterToSystem_Common.USER_ID);
		loginPage.inputToPasswordTextbox(Account_RegisterToSystem_Common.PASSWORD);
		log.info("Login - Step 04: Click to login button");
		homePage = loginPage.clickToLoginButton();
		deleteCustomerPage = (DeleteCustomerPageObject) homePage.openMultiplePage(driver, "Delete Customer");

	}
	
//	@Test
//	public void TC_01_InputEmptyToCustomerID() {
//		deleteCustomerPage.pressTab(driver, "cusid");
//		verifyTrue(deleteCustomerPage.isEmptyMessageDisplayed());
//	}
//	
//	@Test
//	public void TC_02_InputCharIntoCustomerID() {
//		deleteCustomerPage.inputCharToCustomerID("Abc123");
//		verifyTrue(deleteCustomerPage.isCharErrorDisplayed());
//	}
	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}
