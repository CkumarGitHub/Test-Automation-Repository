package com.crm.qa.util;

import java.io.File;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.crm.qa.base.TestBase;


public class TestUtil extends TestBase{

	public static long PAGE_LOAD_TIMEOUT=30;
	public static long IMPLICIT_WAIT=20;
	static Xls_Reader reader;
	
	public void switchToFrame() {
		
		driver.switchTo().frame("mainpanel");
	}
	
	public static ArrayList<Object[]> getDataFromExcel() {
		
		ArrayList<Object[]> testData=new ArrayList<Object[]>();
		
		try {
			reader= new Xls_Reader("C:\\Users\\CK\\eclipse-workspace\\FreeCRMTest\\"
					+ "src\\main\\java\\com\\crm\\qa\\testdata\\FreeCrmTestData.xlsx");
				
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		int rowCount=reader.getRowCount("ContactData");
		
		for(int rowNum=2;rowNum<=rowCount;rowNum++)
		{
			String title=reader.getCellData("ContactData", "title", rowNum);
			String fname=reader.getCellData("ContactData", "firstname", rowNum);
			String lname=reader.getCellData("ContactData", "lastname", rowNum);
			String companyname=reader.getCellData("ContactData", "company", rowNum);
			
			Object[] obj= {title,fname,lname,companyname};
			testData.add(obj);
		}
		
		return testData;
		
	}
	
	public static void takeScreenshotAtEndOfTest() throws Exception {
		
		File filescr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String CurrentDir= System.getProperty("user.dir");
		
		FileUtils.copyFile(filescr, new File(CurrentDir + "/Screenshots/" + System.currentTimeMillis() + ".png"));
		
	}
	
	
	
	
	
	
	
}