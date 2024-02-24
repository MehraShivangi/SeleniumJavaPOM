package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.democart.listeners.AllureListener;
import com.qa.democart.pages.AccountsPage;
import com.qa.democart.utils.ApplicationError;
import com.qa.democart.utils.Constants;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;



@Epic("EPIC 100: Design Login page for open cart application....")
@Story("US 101: Login page with different features.....")
@Listeners(AllureListener.class)
public class LoginPageTest extends BaseTest{
	
	@Description("This is Login Page Title Test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("Login page title is:" + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE, ApplicationError.TITLE_ERROR_MESSG);
		
	}
	
	@Description("This is Login Page Header Test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 2)
	public void loginPageHeaderTest() {
		String header = loginPage.getPageHeaderText();
		System.out.println("Page Header is:" + header);
		Assert.assertEquals(header, Constants.PAGE_HEADER, ApplicationError.HEADER_ERROR_MESSG);
	}
	
	@Description("Forgot Password Link Test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 3)
	public void forgotPasswordLinkTest() {
		Assert.assertTrue(loginPage.isForgotPassLinkExist(), ApplicationError.LINK_ERROR_MESSG);
	}
	
	@Description("Login with correct username and password test")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = 4)
	public void loginTest() {
		//AccountsPage accPage = loginPage.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
		/AccountsPage accPage = loginPage.doLogin(System.getProperty("username"), System.getProperty("password"));
		Assert.assertTrue(accPage.isLogoutLinkExist());
	}
	
	@Test()
	public void newCustomerTest() {
		Assert.assertTrue(loginPage.isNewCustomerTextExist(), ApplicationError.TEXT_ERROR_MESSG);
	}
	
	@Test()
	public void rightSideLinkTest() {
		loginPage.rightSideLinkList();
	}

	@Test()
	public void upperLinkListTest() {
		loginPage.upperLinkList();
	}
}
