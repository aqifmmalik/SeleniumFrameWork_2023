package lib;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Click {

	public static String SingleClick (WebDriver driver,String LocatorType , String LocatorName)
	{
	
	try 
		{
			if (LocatorType.equalsIgnoreCase("ID"))
				
			{ 
				WebDriverWait wait = new WebDriverWait(driver,30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LocatorName)));
				driver.findElement(By.id(LocatorName)).click();
				 
			}
			else if (LocatorType.equalsIgnoreCase("Xpath"))
				
			{
				
				
				
				WebDriverWait wait = new WebDriverWait(driver,30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LocatorName)));
				driver.findElement(By.xpath(LocatorName)).click();
				 
			}
			else if (LocatorType.equalsIgnoreCase("name"))
				
			{
				WebDriverWait wait = new WebDriverWait(driver,30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(LocatorName)));
				driver.findElement(By.name(LocatorName)).click();
			
			}
			
			else if (LocatorType.equalsIgnoreCase("css"))
				
			{
				
				 
				driver.findElement(By.cssSelector(LocatorName)).click();
				
				System.out.println("I am @ CSS Click function");
				
			
				 
			}
				return "Pass";
		} 
		
		catch (Exception e) {
			 return e.getMessage();
		}
	}
	
	public static String DoubleAction (WebDriver driver,String LocatorType , String LocatorName)
	{
	
	try 
		{
			if (LocatorType.equalsIgnoreCase("ID"))
				
			{
				WebDriverWait wait = new WebDriverWait(driver,30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LocatorName)));
				
				Actions action =new Actions(driver);
				WebElement link =driver.findElement(By.id(LocatorName));
				action.doubleClick(link).perform();
				 
			}
			else if (LocatorType.equalsIgnoreCase("Xpath"))
			
			{
				WebDriverWait wait = new WebDriverWait(driver,30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LocatorName)));
				
				Actions action =new Actions(driver);
				WebElement link =driver.findElement(By.id(LocatorName));
				action.doubleClick(link).perform();
				 
			}
				return "Pass";
		} 
		
		catch (Exception e) {
			 return e.getMessage();
		}
	}
	
	public static String ClickAndWait (WebDriver driver,String locatorType,String locatorValue)


{
	try {
		if(locatorType.equalsIgnoreCase("id"))
		{
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
		
			driver.findElement(By.id(locatorValue)).click();
			Thread.sleep(5000);
			
		}
		
		else if (locatorType.equalsIgnoreCase("xpath"))
		{
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
		
			
			driver.findElement(By.xpath(locatorValue)).click();
			Thread.sleep(8000);
			//System.out.println(""+locatorValue);
			 
		}
		else if (locatorType.equalsIgnoreCase("name"))
		{
			
			driver.findElement(By.name(locatorValue)).click();
			Thread.sleep(9000);
			
			
		}
		else if (locatorType.equalsIgnoreCase("className"))
		{
			driver.findElement(By.className(locatorValue)).click();
			Thread.sleep(9000);
			
		}
		
		else if(locatorType.equalsIgnoreCase("linkText"))
		{
			driver.findElement(By.linkText(locatorValue)).click();
			Thread.sleep(9000);
			
		}
		
		 
		
		
		
		return "Pass";
	} catch (Exception e) {
		return e.getMessage();
	}
		
	
	

}

}