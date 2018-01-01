package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class DealsPage extends TestBase{

	
	@FindBy(xpath="//td[contains(text(),'Deals')]")
	WebElement dealText;
	
	@FindBy(xpath="//input[@value='New Deal' and @type='button']")
	WebElement  NewDealBtn;
	
	
	public DealsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyDealText() {
		return dealText.isDisplayed();
	}
	
	public NewDealPage clickOnNewDealLink() {
		
		NewDealBtn.click();
		return new NewDealPage();
		
	}
	
	public void deleteDeal(String name) {
		
		
		driver.findElement(By.xpath("//td[contains(@class,'datalistrow')]"
				+ "//a[contains(text(),'"+name+"')]//parent::td//"
				+ "following::td[contains(@class,'datalistrow')]//a//i[@title='Delete']")).click();
	}
	
	
}
