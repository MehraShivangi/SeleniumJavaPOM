package com.qa.opencart.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.democart.pages.AccountsPage;
import com.qa.democart.pages.LoginPage;
import com.qa.democart.pages.ProductInfoPage;
import com.qa.democart.pages.RegistrationPage;
import com.qa.democart.pages.ResultsPage;
import com.qa.opencart.factory.DriverFactory;

public class BaseTest {
	
	WebDriver driver;
	Properties prop;
	DriverFactory df;
	SoftAssert softAssert;
	
	LoginPage loginPage;
	AccountsPage accPage;
	ResultsPage resultPage;
	ProductInfoPage productInfoPage;
	RegistrationPage regPage;
	
	@BeforeTest
	public void setUp() {
		df = new DriverFactory();
		softAssert = new SoftAssert();
		//prop = df.initProperties();
		driver = df.initDriver(prop);
		loginPage = new LoginPage(driver);
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
