package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventlistner;
	
	
	//creating TestBase class Constructor for loading the properties
	public TestBase() {
		
		
		try {
			prop=new Properties();
			FileInputStream fis=new FileInputStream("C:\\Users\\CK\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\"
					+ "qa\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
				
	}
	
	//creating one initialization method for lading the browser and setting up basic details
	public void initialization() {
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty(prop.getProperty("chromedriver"), prop.getProperty("chromedriverpath"));
			driver=new ChromeDriver();
			
		}
				
		e_driver=new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventlistner=new WebEventListener();
		e_driver.register(eventlistner);
		driver=e_driver;
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();	
		
		driver.get(prop.getProperty("url"));
		
		
		
	}
	
	

}
