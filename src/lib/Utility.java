package lib;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Utility {

	public static String GetText(WebDriver driver, String Testcases, String Description,String TestData,String LocatorType, String LocatorName)
 
	{
		try {
			if (LocatorType.equalsIgnoreCase("id")) {
				String CapID = driver.findElement(By.id(LocatorName)).getText();
				System.out.println(""+Testcases +":  "   +Description +":  " +CapID +":  Passed");
			}

			else if (LocatorType.equalsIgnoreCase("xpath")) {
				String CapID = driver.findElement(By.xpath(LocatorName)).getText();
				System.out.println(""+Testcases +":  "   +Description +":  " +CapID +":  Passed");

			} else if (LocatorType.equalsIgnoreCase("name")) {

				String CapID = driver.findElement(By.name(LocatorName)).getText();
				System.out.println(""+Testcases +":  "   +Description +":  " +CapID +":  Passed");

			} else if (LocatorType.equalsIgnoreCase("className")) {
				String CapID = driver.findElement(By.className(LocatorName)).getText();
				System.out.println(""+Testcases +":  "   +Description +":  " +CapID +":  Passed");
			}
  
		}

		catch (Exception e) {
			System.out.println("Exception while Capture Text " + e.getMessage());

		}
		return ("pass");

	}

	public static String CompareText(WebDriver driver, String locatorType, String locatorValue, String data)

	{
		try {

			if (locatorType.equalsIgnoreCase("id")) {
				String text = driver.findElement(By.id(locatorValue)).getText();
				System.out.println("Excel Value is =" + data);
				System.out.println("WebText is = " + text);
				if (text.equalsIgnoreCase(data)) {
					System.out.println("Text Match");
				} else {
					System.out.println("Text not Match");
				}
			}

			else if (locatorType.equalsIgnoreCase("xpath")) {
				Thread.sleep(6000);
				String text = driver.findElement(By.xpath(locatorValue)).getText();
				System.out.println("Excel Value is =" + data);
				System.out.println("WebText is = " + text);
				if (text.equalsIgnoreCase(data)) {
					System.out.println("Text Match");
				} else {
					System.out.println("Text not Match");
				}
			}

			else if (locatorType.equalsIgnoreCase("name")) {
				String text = driver.findElement(By.name(locatorValue)).getText();
				System.out.println("Excel Value is =" + data);
				System.out.println("WebText is = " + text);
				if (text.equalsIgnoreCase(data)) {
					System.out.println("Text Match");
				} else {
					System.out.println("Text not Match");
				}
			}

			else if (locatorType.equalsIgnoreCase("className")) {
				String text = driver.findElement(By.className(locatorValue)).getText();
				System.out.println("Excel Value is =" + data);
				System.out.println("WebText is = " + text);
				if (text.equalsIgnoreCase(data)) {
					System.out.println("Text Match");
				} else {
					System.out.println("Text not Match");
				}
			}

			return "Pass";
		} catch (Exception e) {
			return e.getMessage();
		}

	}

	public static String GetTitle(WebDriver driver, String locatorType, String locatorValue, String data)

	{
		String text = driver.getTitle();

		System.out.println("WebPage Title is = " + text);
		if (text.equalsIgnoreCase(data)) {
			System.out.println("Text Match");
		} else {
			System.out.println("Title not Match");
		}
		return ("pass");

	}

	public static String SelectdropdownValue(WebDriver driver, String locatorType, String LocatorName, String TestData)

	{
		// Function need to update and fixed
		if (locatorType.equalsIgnoreCase("id")) {

			WebElement source = driver.findElement(By.id(LocatorName));
			Select list = new Select(source);
			list.selectByVisibleText(TestData);
		}

		else if (locatorType.equalsIgnoreCase("xpath")) {

			WebElement source = driver.findElement(By.xpath(LocatorName));
			Select list = new Select(source);

			list.selectByVisibleText(TestData);
			// list.selectByIndex(TestData);
		}
		return "pass";

	}

	public static String RadioButton(WebDriver driver, String LocatorType, String LocatorName, String data)
	// Need to test
	{
		try {
			if (LocatorType.equalsIgnoreCase("id")) {
				Thread.sleep(1000);
				driver.findElement(By.id(LocatorName)).sendKeys(data);
			}

			else if (LocatorType.equalsIgnoreCase("xpath")) {
				Thread.sleep(1000);
				driver.findElement(By.xpath(LocatorName)).sendKeys(data);
			} else if (LocatorType.equalsIgnoreCase("name")) {
				Thread.sleep(1000);
				driver.findElement(By.name(LocatorName)).sendKeys(data);
			} else if (LocatorType.equalsIgnoreCase("className")) {
				Thread.sleep(1000);
				driver.findElement(By.className(LocatorName)).sendKeys(data);
			}
			return "Pass";
		} catch (Exception e) {
			return e.getMessage();
		}

	}

	public static String DropDown(WebDriver driver, String locatorType, String locatorValue, String data)

	{
		try {
			if (locatorType.equalsIgnoreCase("id")) {
				Thread.sleep(1000);
				WebElement month_dropdown = driver.findElement(By.id(locatorValue));
				Select month = new Select(month_dropdown);

				month.selectByVisibleText(data);

			}

			else if (locatorType.equalsIgnoreCase("xpath")) {
				Thread.sleep(1000);

				WebElement month_dropdown = driver.findElement(By.xpath(locatorValue));
				Select month = new Select(month_dropdown);

				month.selectByVisibleText(data);

				// System.out.println(""+LocatorValue);

			} else if (locatorType.equalsIgnoreCase("name")) {

				Thread.sleep(1000);
				driver.findElement(By.name(locatorValue)).click();

			} else if (locatorType.equalsIgnoreCase("className")) {
				Thread.sleep(1000);
				driver.findElement(By.className(locatorValue)).click();
			}

			else if (locatorType.equalsIgnoreCase("linkText")) {
				Thread.sleep(1000);
				driver.findElement(By.linkText(locatorValue)).click();
			}

			return "Pass";
		} catch (Exception e) {
			return e.getMessage();
		}

	}

	public static String Scroll(WebDriver driver, String LocatorName)

	{

		try {
			System.out.println("I am Here One");
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			// robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
			System.out.println("I am Here");

		} catch (Exception e) {
			System.out.println("Exception while Capture Text " + e.getMessage());

		}
		return ("pass");

	}

	public static String WaitforObject(WebDriver driver, String LocatorType, String LocatorName)

	{
		try {
			if (LocatorType.equalsIgnoreCase("id"))

			{
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				Thread.sleep(6000);
			}

			else if (LocatorType.equalsIgnoreCase("xpath")) {
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				Thread.sleep(6000);
			} else if (LocatorType.equalsIgnoreCase("name")) {
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				Thread.sleep(6000);
			} else if (LocatorType.equalsIgnoreCase("className")) {
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			}

			return "Pass";
		} catch (Exception e) {
			return e.getMessage();
		}

	}

	 
	  public static String WindowsScreenShot() throws Exception
	  
	  { WebDriver driver = null; Robot rb =new Robot(); Thread.sleep(2000);
	  rb.keyPress(KeyEvent.VK_ENTER); rb.keyRelease(KeyEvent.VK_ENTER); String
	  screenshotName = ".\\IO\\HTMLReport\\Screenshots\\UploadDocuments.png";
	  String Snappath ="";
	  captureScreenshot(driver, Snappath, screenshotName); 
	  
	  return ("Pass");
	  
	  }
	 

	public static String SwitchWindow(WebDriver driver, String LocatorType, String LocatorName, String TestData)

	{
		try {
			if (LocatorType.equalsIgnoreCase("PopupWindows")) {
				Thread.sleep(1000);
				driver.switchTo().frame(TestData);

			}
			if (LocatorType.equalsIgnoreCase("MainWindows")) {
				Thread.sleep(1000);
				driver.switchTo().defaultContent();
			}

			return "Pass";
		} catch (Exception e) {
			return e.getMessage();
		}

	}

	public static String Switchframe(WebDriver driver, String LocatorType, String TestData)

	{
		try {
			if (LocatorType.equalsIgnoreCase("PopupWindows")) {
				
			//	System.out.println("Try to Select Frame  " +TestData);
				Thread.sleep(1000);
				driver.switchTo().frame(0);
				

			//	System.out.println("Frame Selected :- " +TestData);

			}
			if (LocatorType.equalsIgnoreCase("MainWindows")) {
				Thread.sleep(1000);
				driver.switchTo().defaultContent();
				System.out.println("i am @ main window" );
			}

			return "Pass";
		} catch (Exception e) {
			return e.getMessage();
		}

	}

	
	
	
	
	// ------------------------------------ WithOut Excel Call Functions
	// --------------------

	public static String DateTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		System.out.println(formatter.format(date));
		return "pass";

	}

	public static void captureScreenshot(WebDriver driver, String Snappath ,String screenshotName)

	{

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(""+Snappath + screenshotName + ".png"));
			//System.out.println("Screenshot taken :- "+Snappath+screenshotName+ ".png");

		} catch (Exception e) {
			System.out.println("Exception while taking screenshot " + e.getMessage());

		}

	}

	public static void WindowCaptureScreenshot(WebDriver driver, String screenshotName) throws Exception, Exception {

		BufferedImage image = new Robot()
				.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

		try {
			// This will store screenshot on Specific location
			ImageIO.write(image, "png", new File(screenshotName));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
