package lib;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProjectFunctions {
	
	
	public static String ServiceNow  (WebDriver driver,String LocatorType , String LocatorName)
	{
	
	try 
		{
			if (LocatorType.equalsIgnoreCase("ID"))
				
			{
				 
				//WebDriverWait wait = new WebDriverWait(driver,30);
			//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LocatorName)));
				
				driver.findElement(By.id(LocatorName)).clear();
				driver.findElement(By.id(LocatorName)).click();
			//	driver.findElement(By.id(LocatorName)).sendKeys(TestData);
			 	 
			}
			else if (LocatorType.equalsIgnoreCase("Xpath"))
			
			{
				
				
				 System.out.print(" ********************************* I am @ servicenow function Click + Dropdown");
				 //driver.findElement(By.id(LocatorName)).clear();
				 Thread.sleep(5000);
				 driver.findElement(By.xpath(LocatorName)).sendKeys(Keys.ARROW_DOWN);
				 Thread.sleep(5000);
				 driver.findElement(By.xpath(LocatorName)).sendKeys(Keys.ARROW_DOWN);
				 Thread.sleep(5000);
				 driver.findElement(By.xpath(LocatorName)).sendKeys(Keys.ENTER);
				 
			}
			
			else if (LocatorType.equalsIgnoreCase("css"))
				
			{
			//	WebDriverWait wait = new WebDriverWait(driver,30);
			//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LocatorName)));

				driver.findElement(By.xpath(LocatorName)).clear();
				driver.findElement(By.xpath(LocatorName)).click();
				//driver.findElement(By.xpath(LocatorName)).sendKeys(TestData);
				 
			}
			
			
			return "Pass";
			
			
		} 
		
		catch (Exception e) {
			 return e.getMessage();
			 
		}
	}

}
