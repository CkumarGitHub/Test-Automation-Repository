package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	
	//Login page WebObject/WebElements----OR:
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//a[@href='https://www.freecrm.com/index.html']")
	WebElement freeCRMLogo;
	
	//Creating Constructor of LoginPage to initialize the  WebElements
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
		
		
	}
	
	//Actions OR Methods
	
	public String validateLoginTitle() {
		
		return driver.getTitle();
	}
	
	public boolean validateCRMLogo() {
		
		return freeCRMLogo.isDisplayed();
	}
	
	public HomePage login(String un,String pwd) throws Exception {
		username.sendKeys(un);
		password.sendKeys(pwd);
//		WebDriverWait wait= new WebDriverWait(driver, 2000);
//		wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		Thread.sleep(2000);
		loginBtn.click();
		
		return new HomePage();
		
	}
	
	
	
	
	
	
	
}
