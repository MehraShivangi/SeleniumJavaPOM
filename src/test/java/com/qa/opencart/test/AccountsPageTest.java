package com.qa.opencart.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.democart.utils.Constants;
import com.qa.democart.utils.ExcelUtil;

public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void accPageSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void accPageTitleTest() {
		String title = accPage.getAccountPageTitle();
		System.out.println("Account Page Title is: " + title);
		AssertJUnit.assertEquals(title, Constants.ACCOUNTS_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void accPageHeaderTest() {
		String header = accPage.getAccountPageHeader();
		System.out.println("Account Page Header is: " + header);
		AssertJUnit.assertEquals(header, Constants.PAGE_HEADER);
	}

	@Test(priority = 3)
	public void accountSectionListTest() {
		List<String> actAccSecList = accPage.getAccountSectionList();
		System.out.println("Actual Account Section List is:" + actAccSecList);
		AssertJUnit.assertEquals(actAccSecList, Constants.EXPECTED_ACC_SEC_LIST);
	}

	@Test(priority = 4)
	public void IsDoLogoutExistTest() {
		AssertJUnit.assertTrue(accPage.isLogoutLinkExist());

	}

	@DataProvider
	public Object[][] getSearchData() {
		//return ExcelUtil.getTestData(Constants.PRODUCT_SHEET_NAME);
		return new Object[][] { { "MacBook Air" }, { "MacBook Pro" }, { "Apple" } };
	}

	@Test(priority = 5, dataProvider = "getSearchData")
	public void doSearchTest(String productName) {
		resultPage = accPage.doSearch(productName);
		String resultHeader = resultPage.getSearchResultNameHeader();
		System.out.println("Result Page Header is: " + resultHeader);
		AssertJUnit.assertTrue(resultHeader.contains(productName));
	}

	@DataProvider
	public Object[][] getProductSelectData() {
		return new Object[][] { { "MacBook", "MacBook Air" }, { "MacBook", "MacBook Pro" },
				{ "Apple", "Apple Cinema 30\"" } };
	}

	@Test(priority = 6 , dataProvider = "getProductSelectData")
	public void selectProductTest(String productName , String mainProductName) {
		resultPage = accPage.doSearch(productName);
		productInfoPage = resultPage.selectProductName(mainProductName);
		String header = productInfoPage.getProductHeaderName();
		System.out.println("Product Name is: " + header);
		AssertJUnit.assertEquals(header, mainProductName);

	}
}
