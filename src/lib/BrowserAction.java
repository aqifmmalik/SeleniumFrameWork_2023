package lib;

import org.openqa.selenium.WebDriver;

public class BrowserAction {
	
	public static String OpenApplication ( WebDriver driver, String TestData)
	{
		try {
			
			driver.manage().window().maximize();
			driver.get(TestData);
			
			
			return "Pass";
		} catch (Exception e) {
			 
			 
			return e.getMessage();
		}		
	  }
	
	
	public static String CloseBrowser ( WebDriver driver, String TestData)
	{
		try {
			 
			driver.close();
			
			return "Pass";
		} catch (Exception e) {
			 
			 
			return e.getMessage();
		}		
	  }
	}

 
