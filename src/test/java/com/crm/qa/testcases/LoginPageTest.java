package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;



public class LoginPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	SoftAssert softassert=new SoftAssert();
	
	Logger log=Logger.getLogger(LoginPageTest.class);
	//Creating LoginPageTest Constructor to call TestBase constructor i.e super Constructor
	
	public LoginPageTest() {
		
		super();
		
	}
	
	@BeforeMethod
	public void setUp() {
		
		log.info("Initializing the Test");
		initialization();
		loginpage= new LoginPage();
		
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		
		String title=loginpage.validateLoginTitle();
		Assert.assertEquals(title, "#1 Free CRM for Any Business: Online Customer Relationship Software");
	}
	
	@Test(priority=2)
	public void freeCRMLogoTest() {
		boolean flag=loginpage.validateCRMLogo();
		softassert.assertTrue(flag, "CRM Logo is missing");
		softassert.assertAll();
	}
	
	@Test(priority=3)
	public void login() throws Exception{
		
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void  tearDown() {
		driver.quit();
	}
	
	
	
	
	
}
