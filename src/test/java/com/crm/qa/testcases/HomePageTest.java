package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	
	//HomePageTest Constructor
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage=new LoginPage();
		testUtil=new TestUtil();
		homePage=new HomePage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle=homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO","HomePage Title is not matched");
	}
	
	@Test(priority=2)
	public void verifyUserLabelTest() {
		Assert.assertTrue(homePage.verifyUserLabel());
	}
	
	
	@Test(priority=3)
	public void verifyContactsLinkTest() {
		homePage.clickOnContactsLink();
	}
	
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	
	
	
	
	
	
	
	
}
