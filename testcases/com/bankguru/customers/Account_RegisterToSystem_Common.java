package com.bankguru.customers;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.AbstractTest;
import pageObjects.DeleteCustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObjects;
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageObjects;

public class Account_RegisterToSystem_Common extends AbstractTest{
	public static  String USER_ID;
	public static  String PASSWORD;
	WebDriver driver;
	private String email, loginPageUrl;
	LoginPageObjects loginPage;
	RegisterPageObjects registerPage;
	HomePageObject homePage;
	NewCustomerPageObject newCustomerPage;
	DeleteCustomerPageObject deleteCustomerPage;

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
		driver = openMultiBrowser(browserName);
		email = "tranhuyentb89" + ramdomNumber() + "@gmail.com";
		loginPage = new LoginPageObjects(driver);

		log.info("Register - Step 01: Verify Login form displayed");
		verifyTrue(loginPage.isLoginFormDisplayed());

		log.info("Register - Step 02: Get URL of Login form");
		loginPageUrl = loginPage.getLoginPageUrl();

		log.info("Register - Step 03: Click to here link");
		registerPage = loginPage.clickToHereLink("here");

//		log.info("Register - Step 04: Verify Register page is displayed");
//		verifyTrue(registerPage.isRegisterPageDisplayed());

		log.info("Register - Step 05: Input email and click to Login button");
		registerPage.inputToEmailTextbox(email);
		registerPage.clickToLoginButton();

		log.info("Register - Step 06: Get username and password");
		USER_ID = registerPage.getUserIDInfo();
		PASSWORD = registerPage.getPasswordInfo();
		driver.quit();

	}

//	@AfterTest
//	public void afterClass() {
//		driver.quit();
//	}

	public int ramdomNumber() {
		Random radom = new Random();
		int number = radom.nextInt(9999999);
		return number;
	}

	
}
