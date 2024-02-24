package com.qa.democart.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.democart.utils.Constants;
import com.qa.democart.utils.ElementUtil;

public class AccountsPage {
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	private By accSectionHeader = By.cssSelector("div#content h2");
	private By accPageHeader = By.xpath("//div[@class='col-sm-4']//img[@title='naveenopencart']");
	private By logout = By.linkText("Logout");
	private By searchField =  By.name("search");
	private By searchButton = By.cssSelector("div#search button");
	
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil =  new ElementUtil(driver);	
	}
	
	public String getAccountPageTitle() {
		return elementUtil.waitForTitleIs(Constants.ACCOUNTS_PAGE_TITLE, 5);
	}
	
	public String getAccountPageURL() {
		return elementUtil.waitForUrlContains(Constants.ACCOUNTS_PAGE_URL_FRACTION, 5);
	}
	
	public String getAccountPageHeader() {
		return elementUtil.doGetText(accPageHeader);
	}
	
	public List<String> getAccountSectionList() {
		List<String> accSecValueList = new ArrayList<String>();
		List<WebElement> accSectionHeaderList = elementUtil.getElements(accSectionHeader);
		for(WebElement e : accSectionHeaderList) {
			accSecValueList.add(e.getText());	
		}
		
		//Collections.sort(accSecValueList);
		return accSecValueList;
	}
	
	public boolean isLogoutLinkExist() {
		return elementUtil.doIsDisplayed(logout);
	}
	
	public ResultsPage doSearch(String productName) {
		System.out.println("Product Name is: " + productName);
		elementUtil.doSendKeys(searchField, productName);
		elementUtil.doClick(searchButton);
		return new ResultsPage(driver);
	}
}
