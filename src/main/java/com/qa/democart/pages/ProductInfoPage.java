package com.qa.democart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.democart.utils.ElementUtil;

public class ProductInfoPage {

	private WebDriver driver;
	private ElementUtil elementUtil;
	private Map<String, String> productInfoMap;

	private By productNameHeader = By.cssSelector("div#content h1");
	private By totalImages = By.cssSelector("ul.thumbnails img");
	private By productDetails = By.cssSelector("div#content ul.list-unstyled:nth-of-type(1) li");
	private By priceDetails = By.cssSelector("div#content ul.list-unstyled:nth-of-type(2) li");
	private By quantity = By.id("input-quantity");
	private By addToCartButton = By.id("button-cart");

	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		elementUtil =  new ElementUtil(driver);	
	}

	public String getProductHeaderName() {
		return elementUtil.doGetText(productNameHeader);
	}

	public int getProductImagesCount() {
		return elementUtil.getElements(totalImages).size();
	}

	public Map<String, String> getProductDetails() {
		productInfoMap = new HashMap<String, String>();
		productInfoMap.put("ProductName", getProductHeaderName());
		List<WebElement> metaProductList = elementUtil.getElements(productDetails);
		System.out.println("Product Details are: " + metaProductList.size());

		for (WebElement e : metaProductList) {
			String meta[] = e.getText().split(":");
			String metaKey = meta[0].trim();
			String metaValue = meta[1].trim();
			productInfoMap.put(metaKey, metaValue);
		}		
		List<WebElement> metaPriceList = elementUtil.getElements(priceDetails);
		System.out.println("Price Details are: " + metaPriceList.size());
		String price = metaPriceList.get(0).getText().trim();
		String exTaxPrice = metaPriceList.get(1).getText().trim();
		productInfoMap.put("Price", price);
		productInfoMap.put("ExTaxPrice", exTaxPrice);	
		return productInfoMap;
	}
}
