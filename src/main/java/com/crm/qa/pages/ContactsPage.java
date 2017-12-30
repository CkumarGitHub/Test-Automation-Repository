package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	@CacheLookup
	WebElement contactsLabel;
	
	@FindBy(name="first_name")
	WebElement firstname;
	
	@FindBy(name="surname")
	WebElement lastname;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	//a[contains(text(),'Radhe Krishna')]//parent::td[contains(@class,'datalistrow')]//preceding-sibling::td[contains(@class,'datalistrow')]
	
	//constructor to initialize Page Objects/elements
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void selectContact(String contactName) {
		
		driver.findElement(By.xpath("//a[contains(text(),'"+contactName+"')]//parent::td[contains(@class,'datalistrow')]"
				+ "//preceding-sibling::td[contains(@class,'datalistrow')]")).click();
		
	}
	
	public void createNewContact(String title,String fname,String lname,String companyName) {
		
		Select select=new  Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		company.sendKeys(companyName);
		saveBtn.click();
		
		
	}
	
	
	
	
}
