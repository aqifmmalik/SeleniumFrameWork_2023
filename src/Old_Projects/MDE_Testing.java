/*
 * package Old_Projects;
 * 
 * import java.io.File; import java.io.FileInputStream; import
 * java.text.DateFormat; import java.text.SimpleDateFormat; import
 * java.util.Date; import java.util.Scanner;
 * 
 * import org.apache.log4j.Level; import org.apache.log4j.Logger; import
 * org.apache.log4j.PropertyConfigurator; import
 * org.apache.poi.xssf.usermodel.XSSFWorkbook; import org.openqa.selenium.By;
 * import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.chrome.ChromeDriver; import
 * org.openqa.selenium.firefox.FirefoxDriver; import
 * org.openqa.selenium.ie.InternetExplorerDriver; import
 * org.openqa.selenium.remote.CapabilityType; import
 * org.openqa.selenium.remote.DesiredCapabilities; import
 * org.openqa.selenium.support.ui.ExpectedConditions; import
 * org.openqa.selenium.support.ui.WebDriverWait; import org.testng.ITestResult;
 * import org.testng.annotations.AfterMethod; import
 * org.testng.annotations.BeforeMethod; import org.testng.annotations.Test;
 * 
 * import com.relevantcodes.extentreports.ExtentReports; import
 * com.relevantcodes.extentreports.ExtentTest; import
 * com.relevantcodes.extentreports.LogStatus;
 * 
 * import atu.testrecorder.ATUTestRecorder;
 * 
 * import lib.BrowserAction; import lib.Click; import lib.TypeText; import
 * lib.Utility;
 * 
 * 
 * 
 * public class MDE_Testing { String Application = "MDE Testing Automation"; //
 * For New Application Change here required String ExcelImportFile = "MDE.xlsx";
 * // For New Application Change here required String Env ="Prod Environment";
 * // For New Application Change here required String ProjectName
 * =("************************* "+Application+" ************************* ");
 * WebDriver driver; ExtentReports report; ExtentTest logger;
 * 
 * String FileName = new SimpleDateFormat("yy-MM-dd-HH-mm").format(new Date());
 * String DriverPathie32 = "IO/Drivers/IEDriverServer32new.exe"; String
 * DriverPathie64 = "IO/Drivers/IEDriver64.exe"; String DriverPathFirefox =
 * "IO/Drivers/geckodriver.exe"; String DriverPathChrome =
 * "IO/Drivers/chromedriver.exe"; String Snappath = "./Screenshots/"; String
 * HtmlReportPath = "IO/Reports/Html/Report -"+FileName+".html"; String
 * VideoPath ="./IO/Reports/Video/"; String BatchFile = "./IO/Close.bat"; String
 * Logfile = "./IO/Log4j.properties";
 * 
 * ATUTestRecorder recorder;
 * 
 * @BeforeMethod public void BM() throws Exception {
 * Logger.getRootLogger().setLevel(Level.OFF);
 * PropertyConfigurator.configure(Logfile);
 * 
 * Process process = Runtime.getRuntime().exec(BatchFile); process.waitFor();
 * 
 * DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss"); Date
 * date = new Date(); recorder = new ATUTestRecorder(VideoPath,Application +
 * dateFormat.format(date), false); }
 * 
 * 
 * @Test public void startTest() throws InterruptedException, Exception {
 * 
 * Logger logger2=Logger.getLogger(Application); logger2.info(ProjectName);
 * 
 * 
 * report=new ExtentReports(HtmlReportPath);
 * logger=report.startTest(Application); recorder.start();
 * 
 * //PERFORMING OPERAITON START ExcelDataProvider excel= new
 * ExcelDataProvider(); String mainSheet = "Main"; int mainSheetRowCnt =
 * excel.rowCount(mainSheet); for (int m=1; m<=mainSheetRowCnt; m++) { String
 * testCaseSheet = excel.getData(mainSheet, m, 0); String operation =
 * excel.getData(mainSheet, m, 2); if(operation.equalsIgnoreCase("YES")) {
 * //Excel 2nd Sheet Operation Start String sheetname = testCaseSheet; int
 * rowcount = excel.rowCount(sheetname); for (int i=1; i<=rowcount; i++) {
 * String Testcases = excel.getData(sheetname, i, 0); String Description =
 * excel.getData(sheetname, i, 1); String ObjectType = excel.getData(sheetname,
 * i, 2); String Action = excel.getData(sheetname, i, 3); String LocatorType =
 * excel.getData(sheetname, i, 4); String LocatorName = excel.getData(sheetname,
 * i, 5); String TestData = excel.getData(sheetname, i, 6); String
 * screenshotpath = ""+Snappath+Description +".png";
 * 
 * 
 * 
 * 
 * if(ObjectType.equalsIgnoreCase("Browser")) { if
 * (Action.equalsIgnoreCase("StartBrowser")) {
 * if(TestData.equalsIgnoreCase("Firefox"))
 * 
 * { DesiredCapabilities capabilities = DesiredCapabilities.firefox();
 * capabilities.setCapability("marionette", true);
 * System.setProperty("webdriver.gecko.driver", ""+DriverPathFirefox); driver
 * =new FirefoxDriver(); driver.manage().window().maximize(); }
 * 
 * else if(TestData.equalsIgnoreCase("IE"))
 * 
 * { DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
 * System.setProperty("webdriver.ie.driver", DriverPathie32);
 * caps.setCapability(
 * InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true)
 * ; caps.setCapability("nativeEvents", false); driver = new
 * InternetExplorerDriver(caps); driver.manage().window().maximize(); }
 * 
 * else if(TestData.equalsIgnoreCase("Chrome"))
 * 
 * { DesiredCapabilities capability = DesiredCapabilities.chrome();
 * capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
 * System.setProperty("webdriver.chrome.driver", DriverPathChrome); driver = new
 * ChromeDriver(capability); }
 * 
 * System.out.println("----------- "+Application+" ----------- ");
 * System.out.println("-----------     " +Env+ "    ----------- ");
 * System.out.println(""+Testcases +":  " +Description +":  Passed" );
 * 
 * 
 * }
 * 
 * // --------------------------- Browser Closed Function
 * ------------------------------ if (Action.equalsIgnoreCase("CloseBrowser")) {
 * System.out.println("Application is Closed "); driver.close(); driver.quit();
 * } } // --------------------------- Open Application Function
 * ------------------------------
 * if(ObjectType.equalsIgnoreCase("OpenApplication")) {
 * if(Action.equalsIgnoreCase("Navigate")) { String status =
 * BrowserAction.OpenApplication(driver, TestData);
 * 
 * Thread.sleep(9000);
 * 
 * if (status.equalsIgnoreCase("Pass")) { Utility.captureScreenshot(driver,
 * Description); logger.log(LogStatus.PASS, Description, TestData +
 * logger.addScreenCapture(screenshotpath)); System.out.println(""+Testcases
 * +":  " +Description +":  " +TestData +":  Passed"); }
 * 
 * 
 * 
 * 
 * //if (status.equalsIgnoreCase("Pass")) // {
 * System.out.println(""+Testcases+":  "+"URL: "+TestData +":  Passed"); } } }
 * 
 * // --------------------------- Text Function ------------------------------
 * if(ObjectType.equalsIgnoreCase("Type")) {
 * if(Action.equalsIgnoreCase("TypeText")) { String status =
 * TypeText.Type(driver, LocatorType, LocatorName, TestData); //
 * logger2.info("Text Type : "+Description +" : " +TestData);
 * 
 * if (status.equalsIgnoreCase("Pass")) { Utility.captureScreenshot(driver,
 * Description); logger.log(LogStatus.PASS, Testcases, Description +
 * logger.addScreenCapture(screenshotpath)); System.out.println(""+Testcases
 * +":  " +Description +":  " +TestData +":  Passed"); } } }
 * 
 * // --------------------------- Text Function With Enter Key Function
 * ------------------------------ if(ObjectType.equalsIgnoreCase("Type")) {
 * if(Action.equalsIgnoreCase("TypetextEnter")) { String status =
 * TypeText.TypetextEnter(driver, LocatorType, LocatorName, TestData); //
 * logger2.info("Text Type : "+Description +" : " +TestData);
 * 
 * if (status.equalsIgnoreCase("Pass")) { Utility.captureScreenshot(driver,
 * Description); logger.log(LogStatus.PASS, Testcases, Description +
 * logger.addScreenCapture(screenshotpath)); System.out.println(""+Testcases
 * +":  " +Description +":  " +TestData +":  Passed"); } else {
 * System.out.println(""+Testcases +":  " +Description +":  " +TestData
 * +":  Failed"); Utility.captureScreenshot(driver, Description);
 * logger.log(LogStatus.FAIL, Testcases, Description +
 * logger.addScreenCapture(screenshotpath)); } } }
 * 
 * // --------------------------- TypeTextAndWait Function
 * ------------------------------ if(ObjectType.equalsIgnoreCase("Type")) {
 * if(Action.equalsIgnoreCase("TypeTextAndWait")) { String status =
 * TypeText.TypeTextAndWait(driver, LocatorType, LocatorName, TestData); //
 * logger2.info("Text Type : "+Description +" : " +TestData);
 * 
 * if (status.equalsIgnoreCase("Pass")) { Utility.captureScreenshot(driver,
 * Description); logger.log(LogStatus.PASS, Testcases, Description +
 * logger.addScreenCapture(screenshotpath)); System.out.println(""+Testcases
 * +":  " +Description +":  " +TestData +":  Passed"); } else {
 * System.out.println(""+Testcases +":  " +Description +":  " +TestData
 * +":  Failed"); Utility.captureScreenshot(driver, Description);
 * logger.log(LogStatus.FAIL, Testcases, Description +
 * logger.addScreenCapture(screenshotpath)); } } }
 * 
 * // --------------------------- SendKey Function
 * ------------------------------ if(ObjectType.equalsIgnoreCase("Type")) {
 * if(Action.equalsIgnoreCase("SendKey")) { String status =
 * TypeText.SendKey(driver, LocatorType, LocatorName, TestData); //
 * logger2.info("Text Type : "+Description +" : " +TestData);
 * 
 * if (status.equalsIgnoreCase("Pass")) { Utility.captureScreenshot(driver,
 * Description); logger.log(LogStatus.PASS, Testcases, Description +
 * logger.addScreenCapture(screenshotpath)); System.out.println(""+Testcases
 * +":  " +Description +":  " +TestData +":  Passed"); } } }
 * 
 * // --------------------------- Single Click Function
 * ------------------------------ if(ObjectType.equalsIgnoreCase("Click")) {
 * if(Action.equalsIgnoreCase("SingleClick")) { String status =
 * Click.SingleClick(driver, LocatorType, LocatorName); //
 * logger2.info("Text Type : "+Description +" : " +TestData);
 * 
 * if (status.equalsIgnoreCase("Pass")) { Utility.captureScreenshot(driver,
 * Description); logger.log(LogStatus.PASS, Testcases, Description +
 * logger.addScreenCapture(screenshotpath)); System.out.println(""+Testcases
 * +":  " +Description +":  " +TestData +":  Passed"); } else {
 * System.out.println(""+Testcases +":  " +Description +":  " +TestData
 * +":  Failed"); Utility.captureScreenshot(driver, Description);
 * logger.log(LogStatus.FAIL, Testcases, Description +
 * logger.addScreenCapture(screenshotpath)); }
 * 
 * } }
 * 
 * // --------------------------- Double Click Function
 * ------------------------------ if(ObjectType.equalsIgnoreCase("Click")) {
 * if(Action.equalsIgnoreCase("DoubleClick")) { String status =
 * Click.DoubleAction(driver, LocatorType, LocatorName); //
 * logger2.info("Text Type : "+Description +" : " +TestData);
 * 
 * if (status.equalsIgnoreCase("Pass")) { Utility.captureScreenshot(driver,
 * Description); logger.log(LogStatus.PASS, Testcases, Description +
 * logger.addScreenCapture(screenshotpath)); System.out.println(""+Testcases
 * +":  " +Description +":  " +TestData +":  Passed"); }
 * 
 * } } // --------------------------- ClickAndWait Function
 * ------------------------------
 * 
 * if(ObjectType.equalsIgnoreCase("Click")) {
 * if(Action.equalsIgnoreCase("ClickAndWait")) { String status =
 * Click.ClickAndWait(driver, LocatorType, LocatorName); //
 * logger2.info("Text Type : "+Description +" : " +TestData);
 * 
 * if (status.equalsIgnoreCase("Pass")) { Utility.captureScreenshot(driver,
 * Description); logger.log(LogStatus.PASS, Testcases, Description +
 * logger.addScreenCapture(screenshotpath)); System.out.println(""+Testcases
 * +":  " +Description +":  " +TestData +":  Passed"); } } }
 * 
 * 
 * // --------------------------- Utility - GetText Function
 * ------------------------------
 * 
 * if(ObjectType.equalsIgnoreCase("Utility")) {
 * if(Action.equalsIgnoreCase("GetText")) { String status =
 * Utility.GetText(driver, LocatorType, LocatorName);
 * 
 * if (status.equalsIgnoreCase("Pass")) { Utility.captureScreenshot(driver,
 * Description); logger.log(LogStatus.PASS, Testcases, Description +
 * logger.addScreenCapture(screenshotpath)); System.out.println(""+Testcases
 * +":  " +Description +":  " +TestData +":  Passed"); } else {
 * System.out.println(""+Testcases +":  " +Description +":  " +TestData
 * +":  Failed"); Utility.captureScreenshot(driver, Description);
 * logger.log(LogStatus.FAIL, Testcases, Description +
 * logger.addScreenCapture(screenshotpath)); } } }
 * 
 * // --------------------------- Utility - Scroll Function
 * ------------------------------
 * 
 * if(ObjectType.equalsIgnoreCase("Utility")) {
 * if(Action.equalsIgnoreCase("Scroll")) { String status =
 * Utility.Scroll(driver, LocatorName);
 * 
 * if (status.equalsIgnoreCase("Pass")) { Utility.captureScreenshot(driver,
 * Description); logger.log(LogStatus.PASS, Testcases, Description +
 * logger.addScreenCapture(screenshotpath)); System.out.println(""+Testcases
 * +":  " +Description +":  " +TestData +":  Passed"); } else {
 * System.out.println(""+Testcases +":  " +Description +":  " +TestData
 * +":  Failed"); Utility.captureScreenshot(driver, Description);
 * logger.log(LogStatus.FAIL, Testcases, Description +
 * logger.addScreenCapture(screenshotpath)); } } }
 * 
 * 
 * // --------------------------- Utility - WaitforObject Function
 * ------------------------------
 * 
 * if(ObjectType.equalsIgnoreCase("Utility")) {
 * if(Action.equalsIgnoreCase("WaitforObject")) { String status =
 * Utility.WaitforObject(driver, LocatorType, LocatorName);
 * 
 * if (status.equalsIgnoreCase("Pass")) { Utility.captureScreenshot(driver,
 * Description); logger.log(LogStatus.PASS, Testcases, Description +
 * logger.addScreenCapture(screenshotpath)); System.out.println(""+Testcases
 * +":  " +Description +":  " +TestData +":  Passed"); } else {
 * System.out.println(""+Testcases +":  " +Description +":  " +TestData
 * +":  Failed"); Utility.captureScreenshot(driver, Description);
 * logger.log(LogStatus.FAIL, Testcases, Description +
 * logger.addScreenCapture(screenshotpath)); } } } //
 * --------------------------- Utility - Select Function
 * ------------------------------ // --------------------------- Need to Test
 * ------------------------------
 * 
 * if(ObjectType.equalsIgnoreCase("Utility")) {
 * if(Action.equalsIgnoreCase("Selectdropdown")) { String status =
 * Utility.SelectdropdownValue(driver, LocatorType, LocatorName, TestData);
 * 
 * if (status.equalsIgnoreCase("Pass")) { Utility.captureScreenshot(driver,
 * Description); logger.log(LogStatus.PASS, Testcases, Description +
 * logger.addScreenCapture(screenshotpath)); System.out.println(""+Testcases
 * +":  " +Description +":  " +TestData +":  Passed"); } else {
 * System.out.println(""+Testcases +":  " +Description +":  " +TestData
 * +":  Failed"); Utility.captureScreenshot(driver, Description);
 * logger.log(LogStatus.FAIL, Testcases, Description +
 * logger.addScreenCapture(screenshotpath)); } } }
 * 
 * // --------------------------- Utility - WindowsScreenShot Function
 * ------------------------------
 * 
 * if(ObjectType.equalsIgnoreCase("Utility")) {
 * if(Action.equalsIgnoreCase("WindowsScreenShot")) { String status =
 * Utility.WindowsScreenShot();
 * 
 * if (status.equalsIgnoreCase("Pass")) { Utility.captureScreenshot(driver,
 * Description); logger.log(LogStatus.PASS, Testcases, Description +
 * logger.addScreenCapture(screenshotpath)); System.out.println(""+Testcases
 * +":  " +Description +":  " +TestData +":  Passed"); } else {
 * System.out.println(""+Testcases +":  " +Description +":  " +TestData
 * +":  Failed"); Utility.captureScreenshot(driver, Description);
 * logger.log(LogStatus.FAIL, Testcases, Description +
 * logger.addScreenCapture(screenshotpath)); } } }
 * 
 * // --------------------------- Utility - SwitchWindow Function
 * ------------------------------
 * 
 * if(ObjectType.equalsIgnoreCase("Utility")) {
 * if(Action.equalsIgnoreCase("SwitchWindow")) { String status =
 * Utility.SwitchWindow(driver, LocatorType, LocatorName, TestData);
 * 
 * if (status.equalsIgnoreCase("Pass")) { Utility.captureScreenshot(driver,
 * Description); logger.log(LogStatus.PASS, Testcases, Description +
 * logger.addScreenCapture(screenshotpath)); System.out.println(""+Testcases
 * +":  " +Description +":  " +TestData +":  Passed"); } else {
 * System.out.println(""+Testcases +":  " +Description +":  " +TestData
 * +":  Failed"); Utility.captureScreenshot(driver, Description);
 * logger.log(LogStatus.FAIL, Testcases, Description +
 * logger.addScreenCapture(screenshotpath)); } } }
 * 
 * // --------------------------- Utility - RadioButton Function
 * ------------------------------
 * 
 * if(ObjectType.equalsIgnoreCase("Utility")) {
 * if(Action.equalsIgnoreCase("RadioButton")) { String status =
 * Utility.RadioButton(driver, LocatorType, LocatorName, TestData);
 * 
 * if (status.equalsIgnoreCase("Pass")) { Utility.captureScreenshot(driver,
 * Description); logger.log(LogStatus.PASS, Testcases, Description +
 * logger.addScreenCapture(screenshotpath)); System.out.println(""+Testcases
 * +":  " +Description +":  " +TestData +":  Passed"); } else {
 * System.out.println(""+Testcases +":  " +Description +":  " +TestData
 * +":  Failed"); Utility.captureScreenshot(driver, Description);
 * logger.log(LogStatus.FAIL, Testcases, Description +
 * logger.addScreenCapture(screenshotpath)); } } }
 * 
 * // --------------------------- Utility - CompareText Function
 * ------------------------------
 * 
 * if(ObjectType.equalsIgnoreCase("Utility")) {
 * if(Action.equalsIgnoreCase("CompareText")) { String status =
 * Utility.CompareText(driver, LocatorType, LocatorName, TestData);
 * 
 * if (status.equalsIgnoreCase("Pass")) { Utility.captureScreenshot(driver,
 * Description); logger.log(LogStatus.PASS, Testcases, Description +
 * logger.addScreenCapture(screenshotpath)); System.out.println(""+Testcases
 * +":  " +Description +":  " +TestData +":  Passed"); } else {
 * System.out.println(""+Testcases +":  " +Description +":  " +TestData
 * +":  Failed"); Utility.captureScreenshot(driver, Description);
 * logger.log(LogStatus.FAIL, Testcases, Description +
 * logger.addScreenCapture(screenshotpath)); } } }
 * 
 * 
 * // --------------------------- Utility - Get WebPage Title - Function
 * ------------------------------
 * 
 * if(ObjectType.equalsIgnoreCase("Utility")) {
 * if(Action.equalsIgnoreCase("GetTitle")) { String status =
 * Utility.GetTitle(driver, LocatorType, LocatorName, TestData);
 * 
 * if (status.equalsIgnoreCase("Pass")) { Utility.captureScreenshot(driver,
 * Description); logger.log(LogStatus.PASS, Testcases, Description +
 * logger.addScreenCapture(screenshotpath)); System.out.println(""+Testcases
 * +":  " +Description +":  " +TestData +":  Passed"); } else {
 * System.out.println(""+Testcases +":  " +Description +":  " +TestData
 * +":  Failed"); Utility.captureScreenshot(driver, Description);
 * logger.log(LogStatus.FAIL, Testcases, Description +
 * logger.addScreenCapture(screenshotpath)); } } }
 * 
 * 
 * 
 * 
 * //*************************** Enter Manual Input ***************************
 * 
 * if(ObjectType.equalsIgnoreCase("ManualInput")) {
 * 
 * 
 * 
 * Scanner readUserInput=new Scanner(System.in);
 * System.out.println("Please Enter Email Code :-   ?"); String
 * myName=readUserInput.nextLine();
 * 
 * //Print what it store in myName System.out.println(myName);
 * 
 * WebDriverWait wait = new WebDriverWait(driver,30);
 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LocatorName)))
 * ;
 * 
 * driver.findElement(By.id(LocatorName)).clear();
 * driver.findElement(By.id(LocatorName)).click();
 * driver.findElement(By.id(LocatorName)).sendKeys(TestData);
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 * 
 * //*************************** Scroll window ***************************
 * 
 * if(ObjectType.equalsIgnoreCase("Scroll")) {
 * 
 * 
 * String status = lib.Utility.Scroll(driver, LocatorName );
 * //System.out.print(""+TestData); if (status.equalsIgnoreCase("pass")) { //
 * Utility.captureScreenshot(driver, Description); logger.log(LogStatus.PASS,
 * Testcases, Description + logger.addScreenCapture(screenshotpath));
 * 
 * } // else {} }
 * 
 * 
 * //*************************************************************************
 * 
 * } } } recorder.stop(); report.endTest(logger); report.flush(); } //PERFORMING
 * OPERAITON END
 * 
 * @AfterMethod (alwaysRun = true, enabled=true) public void
 * FailureScreenShot(ITestResult result) throws Exception {
 * if(ITestResult.FAILURE==result.getStatus()) {
 * System.out.println("AfterMethod is Execute");
 * //lib.Utility.captureScreenshot(driver,
 * result.getName()+lib.Utility.DateTime());
 * 
 * }
 * 
 * }
 * 
 * 
 * 
 * // Excel Data Import Here - FileName define as Global Variable
 * 
 * public class ExcelDataProvider { XSSFWorkbook wb; public ExcelDataProvider()
 * 
 * { try { wb = new XSSFWorkbook(new FileInputStream(new
 * File("./IO/TestCases/"+ExcelImportFile))); } catch (Exception e) {
 * 
 * System.out.println("Unable to Load Excel Sheet");
 * System.out.println(e.getMessage()); } }
 * 
 * public String getData(String sheetname,int row , int column) {
 * 
 * String data =
 * wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
 * 
 * 
 * 
 * if(cell.getCellType()==CellType.STRING) data = cell.getStringCellValue();
 * else if(cell.getCellType()==CellType.NUMERIC) data =
 * String.valueOf(cell.getNumericCellValue()); else ...
 * 
 * 
 * 
 * return data;
 * 
 * } public int rowCount (String sheetname) {
 * 
 * 
 * return wb.getSheet(sheetname).getLastRowNum();
 * 
 * } } }
 * 
 * 
 * 
 */