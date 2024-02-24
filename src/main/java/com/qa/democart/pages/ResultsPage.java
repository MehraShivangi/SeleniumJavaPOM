package com.qa.democart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.democart.utils.ElementUtil;

public class ResultsPage {
	
	private WebDriver driver;
	private ElementUtil elementUtil;
		
		private By searchResultNameHeader = By.cssSelector("div#content h1");
		private By productList = By.cssSelector("div.caption a");
		
		
		public ResultsPage(WebDriver driver) {
			this.driver = driver;
			elementUtil = new ElementUtil(driver);
		}

		public String getSearchResultNameHeader() {
			return elementUtil.doGetText(searchResultNameHeader);
			
		}
		
		public int getProductListCount() {
			return elementUtil.getElements(productList).size();
		}

		public ProductInfoPage selectProductName(String productName) {
			List<WebElement> searchList = elementUtil.getElements(productList);
			for(WebElement e : searchList) {
				if(e.getText().trim().equals(productName)) {
					e.click();
					break;
				}
			}
			return new ProductInfoPage(driver);
		}
	
}
