package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//td[contains(text(),'User: Chandan kumar')]")
	WebElement userNameLabel;
		
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath="//a[@title='New Contact']")
	WebElement newContactLink;
	
	@FindBy(xpath="//a[contains(text(),'New Deal')]")
	WebElement newDealLink;
	
	//constructor to initialize the elements
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public boolean verifyUserLabel() {
		
		return userNameLabel.isDisplayed();
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactlink() {
		
		Actions action=new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		
	}
	
	public NewDealPage clickOnNewDealLink() {
		
		Actions action=new Actions(driver);
		action.moveToElement(dealsLink).build().perform();
		newDealLink.click();
		return new NewDealPage();
		
	}
	
	
	
	
}
