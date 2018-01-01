package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class NewDealPage extends TestBase{

	@FindBy(xpath="//legend[contains(text(),'Deal')]")
	WebElement DealText;
	
	@FindBy(xpath="//input[@id='title']")
	WebElement Title;
	
	@FindBy(name="client_lookup")
	WebElement companyName;
	
	@FindBy(name="contact_lookup")
	WebElement contactPrimary;
	
	@FindBy(id="amount")
	WebElement Amount;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	
	public NewDealPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyDealLegendText()
	{
		return DealText.isDisplayed();
	}
	
	
	public void createNewDeal(String title,String companyname,String contact,String amount) {
		Title.sendKeys(title);
		companyName.sendKeys(companyname);
		contactPrimary.sendKeys(contact);
		Amount.sendKeys(amount);
		saveBtn.click();
	}
	
	
	
}
