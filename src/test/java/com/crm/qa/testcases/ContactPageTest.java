package com.crm.qa.testcases;



import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;



public class ContactPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public ContactPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		testUtil=new TestUtil();
		loginPage=new LoginPage();
		contactsPage=new ContactsPage();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage=homePage.clickOnContactsLink();
	}
	
	@Test(priority=1,enabled=false)
	public void verifyContactsLabelTest() {
		Assert.assertTrue(contactsPage.verifyContactsLabel());
		
	}
	
	@Test(priority=2,enabled=false)
	public void selectSingleContact() {
		contactsPage.selectContact("Kanchan Kumar");
	}
	
	@Test(priority=3,enabled=false)
	public void selectMultipleContact() {
		contactsPage.selectContact("Radhe Krishna");
		contactsPage.selectContact("Krishna Radhe");
	}
		
	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testdata=TestUtil.getContactDataFromExcel("ContactData");
		
		return testdata.iterator();
		
	}
	
	
	
	
	@Test(dataProvider="getTestData")
	public void validateCreateNewContact(String title,String fname,String lname,String company) {
		
		homePage.clickOnNewContactlink();
		contactsPage.createNewContact(title, fname, lname, company);
		
		
	}
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.close();
	}
	
	
	
	
	
	
	
}
