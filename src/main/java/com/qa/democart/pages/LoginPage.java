package com.qa.democart.pages;

import java.time.Duration;
import io.qameta.allure.Step;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.democart.utils.Constants;
import com.qa.democart.utils.ElementUtil;

public class LoginPage {
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	// private By locators
	
	
	private By emailId = By.xpath("//input[@id='input-email']");
	private By password = By.xpath("//input[@id='input-password']");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPassLink = By.xpath("//div[@class='form-group']//a[text()='Forgotten Password']");
	private By loginPageHeader = By.xpath("//div[@class='col-sm-4']//img[@title='naveenopencart']");
	private By newCustomer = By.xpath("//div[@class='well']//h2[text()='New Customer']");
	private By rightSideLinks = By.xpath("//div[@class='list-group']/a");
	private By upperLinks = By.xpath("//div[@class='collapse navbar-collapse navbar-ex1-collapse']/ul/li/a");
	private By registrationLink = By.linkText("Register");
	
	// constructor
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	// page actions/page methods(functionality or behavior of the page and strictly no assertions
	
	@Step("getting login page title")
	public String getLoginPageTitle() {
		return elementUtil.waitForTitleIs(Constants.LOGIN_PAGE_TITLE, 5);
	}
	
	@Step("getting login page header")
	public String getPageHeaderText() {
		return elementUtil.doGetText(loginPageHeader); 
	}
	
	@Step("Forgot password link presence")
	public boolean isForgotPassLinkExist() {
		return elementUtil.doIsDisplayed(forgotPassLink);
	}
	
	@Step("Checking login with userName{0} and pwd{1}")
	public AccountsPage doLogin(String userName , String pwd) {
		elementUtil.doSendKeys(emailId, userName);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginBtn);
		return new AccountsPage(driver);
	}
	
	public boolean isNewCustomerTextExist() {
		return driver.findElement(newCustomer).isDisplayed();
	}
	
	public void rightSideLinkList() {
		List<WebElement> totalLinks = driver.findElements(rightSideLinks);
		System.out.println("total right side links: " + totalLinks.size());
		int i = 1;
		for(WebElement e : totalLinks) {
			String text = e.getText();
			if(!text.isEmpty()) {
				System.out.println(i+":"+text);
			}
			i++;
		}
		
	}
	
	public void upperLinkList() {
		List<WebElement> topLinks = driver.findElements(upperLinks);
		System.out.println("total upper links: " + topLinks.size());
		int j = 1;
		for(WebElement e :topLinks) {
			String topLinkText = e.getText();
			if(!topLinkText.isEmpty()) {
				System.out.println(j+":"+topLinkText);
			}
			j++;
		}
	}
	
	@Step("Navigate to registration page")
	public RegistrationPage navigateToRegistrationPage() {
		elementUtil.doClick(registrationLink);
		return new RegistrationPage(driver);
	}

}
