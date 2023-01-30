package lib;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TypeText {

	public static String Type (WebDriver driver,String LocatorType , String LocatorName , String TestData)
	{
	
	try 
		{
			if (LocatorType.equalsIgnoreCase("ID"))
				
			{
				 
				WebDriverWait wait = new WebDriverWait(driver,30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LocatorName)));
				
				driver.findElement(By.id(LocatorName)).clear();
				driver.findElement(By.id(LocatorName)).click();
				driver.findElement(By.id(LocatorName)).sendKeys(TestData);
			 	 
			}
			else if (LocatorType.equalsIgnoreCase("Xpath"))
			
			{
				WebDriverWait wait = new WebDriverWait(driver,30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LocatorName)));

				driver.findElement(By.xpath(LocatorName)).clear();
				driver.findElement(By.xpath(LocatorName)).click();
				driver.findElement(By.xpath(LocatorName)).sendKeys(TestData);
				 
			}
			
			else if (LocatorType.equalsIgnoreCase("css"))
				
			{
				WebDriverWait wait = new WebDriverWait(driver,30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LocatorName)));

				driver.findElement(By.xpath(LocatorName)).clear();
				driver.findElement(By.xpath(LocatorName)).click();
				driver.findElement(By.xpath(LocatorName)).sendKeys(TestData);
				 
			}
			
			
			return "Pass";
			
			
		} 
		
		catch (Exception e) {
			 return e.getMessage();
			 
		}
	}
	
	
	public static String TypetextEnter (WebDriver driver,String LocatorType , String LocatorName , String TestData)
	{
	
	try 
		{
			if (LocatorType.equalsIgnoreCase("ID"))
				
			{
				 
				WebDriverWait wait = new WebDriverWait(driver,30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LocatorName)));
				
				driver.findElement(By.id(LocatorName)).clear();
				driver.findElement(By.id(LocatorName)).click();
				driver.findElement(By.id(LocatorName)).sendKeys(TestData);
				Thread.sleep(2000);
				
				driver.findElement(By.id(LocatorName)).sendKeys(Keys.ENTER);
				 
			}
			else if (LocatorType.equalsIgnoreCase("Xpath"))
			
			{
				WebDriverWait wait = new WebDriverWait(driver,30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LocatorName)));
	
				driver.findElement(By.xpath(LocatorName)).clear();
				driver.findElement(By.xpath(LocatorName)).click();
				driver.findElement(By.xpath(LocatorName)).sendKeys(TestData);
				Thread.sleep(2000);
				driver.findElement(By.xpath(LocatorName)).sendKeys(Keys.ENTER);
			}
			return "Pass";
			
			
		} 
		
		catch (Exception e) {
			 return e.getMessage();
			 
		}
	}
	
	public static String TypeTextAndWait (WebDriver driver,String LocatorType , String LocatorName , String TestData)
	{
	
	try 
		{
			if (LocatorType.equalsIgnoreCase("ID"))
				
			{
				 
				driver.findElement(By.id(LocatorName)).clear();
				driver.findElement(By.id(LocatorName)).click();
				driver.findElement(By.id(LocatorName)).sendKeys(TestData);
				Thread.sleep(4000);
				driver.findElement(By.id(LocatorName)).sendKeys(Keys.ENTER);
			}
			else if (LocatorType.equalsIgnoreCase("Xpath"))
				
			{
				
				driver.findElement(By.xpath(LocatorName)).clear();
				driver.findElement(By.xpath(LocatorName)).click();
				driver.findElement(By.xpath(LocatorName)).sendKeys(TestData);
				
				Thread.sleep(4000);
				driver.findElement(By.id(LocatorName)).sendKeys(Keys.ENTER);
			}
			else if (LocatorType.equalsIgnoreCase("name"))
				
			{
				
				driver.findElement(By.name(LocatorName)).clear();
				driver.findElement(By.name(LocatorName)).click();
				driver.findElement(By.name(LocatorName)).sendKeys(TestData);
				
				Thread.sleep(9000);
			}
			return "Pass";
			
			
		} 
		
		catch (Exception e) {
			 return e.getMessage();
			 
		}
	}
	
	public static String SendKey (WebDriver driver,String LocatorType , String LocatorName , String TestData)
	
	{
		try {
			if(LocatorType.equalsIgnoreCase("id"))
			{
				driver.findElement(By.xpath(LocatorName)).sendKeys(Keys.ENTER);		
				System.out.println("I am @ Sendkey ID  Function");
			 
			}
			else if (LocatorType.equalsIgnoreCase("xpath"))
			{
				
			 
				driver.findElement(By.xpath(LocatorName)).sendKeys(Keys.ENTER);		
			}
			else if (LocatorType.equalsIgnoreCase("name"))
			{
				driver.findElement(By.name(LocatorName)).sendKeys(TestData);
			}
			else if (LocatorType.equalsIgnoreCase("className"))
			{
				driver.findElement(By.className(LocatorName)).sendKeys(TestData);
			}
			return "Pass";
		} catch (Exception e) {
			return e.getMessage();
		}
   }
}