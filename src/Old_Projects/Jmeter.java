 
package Old_Projects;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.Screen;
import org.sikuli.script.FindFailed;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Jmeter {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  String DriverPathChrome = "IO/Drivers/chromedriver2.exe";
  
  
  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	  
		
         DesiredCapabilities capability = DesiredCapabilities.chrome();
		 capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		 System.setProperty("webdriver.chrome.driver", DriverPathChrome); driver = new
		 ChromeDriver(capability);
      
      driver.manage().window().maximize();
      
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCs() throws Exception {
    // Label: Test
    // ERROR: Caught exception [ERROR: Unsupported command [resizeWindow | 1280,564 | ]]
    driver.get("https://google.com/");
    
      
    
    driver.get("https://client.verity.cloud/38951/appweb/asp/userlogin.aspx");
    driver.findElement(By.id("PasswordTxt")).clear();
    driver.findElement(By.id("PasswordTxt")).sendKeys("Testlink");
    driver.findElement(By.id("LoginButton")).click();
    
    
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
