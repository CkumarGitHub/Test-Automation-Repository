package com.crm.qa.testcases;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewDealPage;
import com.crm.qa.util.TestUtil;

public class NewDealPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	DealsPage dealPage;
	TestUtil testutil;
	NewDealPage newDealPage;
	
	public NewDealPageTest() {
		
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
	
	@DataProvider
	public Iterator<Object[]> getDealTestData() {
		
		ArrayList<Object[]> dealtestdata=TestUtil.getDealDataFromExcel("DealsData");
		return dealtestdata.iterator();
		
	}
	
	@Test(dataProvider="getDealTestData")
	public  void validateCreateNewDeal(String ttl,String compname,String contact,String amount) {
		
		newDealPage=dealPage.clickOnNewDealLink();
		newDealPage.createNewDeal(ttl, compname, contact, amount);
		
	}
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.close();
		
		
	}
	
	
	
}
