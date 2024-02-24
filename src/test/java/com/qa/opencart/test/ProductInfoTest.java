package com.qa.opencart.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductInfoTest extends BaseTest{
	
	@BeforeClass
	public void accPageSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void getProductImageCountTest() {
		resultPage = accPage.doSearch("iMac");
		productInfoPage = resultPage.selectProductName("iMac");
		Assert.assertEquals(productInfoPage.getProductImagesCount(), 3);
	}
	
	@Test
	public void getProductInfo() {
		resultPage = accPage.doSearch("MacBook");
		productInfoPage = resultPage.selectProductName("MacBook Pro");
		Map<String, String> actualProductInfo = productInfoPage.getProductDetails();
		
		softAssert.assertEquals(actualProductInfo.get("ProductName"), "MacBook Pro");
		softAssert.assertEquals(actualProductInfo.get("Brand"), "Apple");
		softAssert.assertEquals(actualProductInfo.get("Product Code"), "Product 18");
		softAssert.assertEquals(actualProductInfo.get("Price"), "$2,000.00");
		softAssert.assertAll();
	}

}
