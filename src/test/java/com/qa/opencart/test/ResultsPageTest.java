package com.qa.opencart.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.democart.utils.ElementUtil;

public class ResultsPageTest {
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	private By searchResultNameHeader = By.cssSelector("div#content h1");
	
	public ResultsPageTest(WebDriver driver) {
		this.driver = driver;
		elementUtil =  new ElementUtil(driver);
	}
	
	public String getSearchResultNameHeader() {
		return elementUtil.doGetText(searchResultNameHeader);
		
	}

}
