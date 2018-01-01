package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewDealPage;
import com.crm.qa.util.TestUtil;



public class DealsPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	DealsPage dealPage;
	TestUtil testutil;
	NewDealPage newDealPage;
	
	public DealsPageTest() {
		
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		
		initialization();
		loginpage=new LoginPage();
		homepage=new HomePage();
		dealPage=new DealsPage();
		testutil=new TestUtil();
		newDealPage=new NewDealPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchToFrame();
		dealPage=homepage.clickOnDealsLink();
	}
	
	@Test(priority=1,enabled=false)
	public void verifyDealsTextTest() {
		
		Assert.assertTrue(dealPage.verifyDealText());
		
		
	}
	
	@Test(priority=2,enabled=false)
	public void clickOnNewDealTest() {
		
		NewDealPage newDealPage=dealPage.clickOnNewDealLink();
		Assert.assertTrue(newDealPage.verifyDealLegendText());
	}
	
	@Test(priority=3,enabled=true)
	public void verifyDeleteDeal() {
		 dealPage.deleteDeal("Mrs.");
		 driver.switchTo().alert().accept();
		 
	 }
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.close();
		
		
	}
	
	
	
}
