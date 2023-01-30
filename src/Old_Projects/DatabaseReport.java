/*
 * package Old_Projects;
 * 
 * 
 * import java.io.File; import java.io.FileInputStream; import
 * java.io.FileOutputStream; import java.io.IOException; import
 * java.sql.Connection; import java.sql.DriverManager; import
 * java.sql.ResultSet; import java.sql.Statement; import
 * java.text.SimpleDateFormat; import java.util.Date;
 * 
 * import org.apache.log4j.Level; import org.apache.log4j.Logger; import
 * org.apache.log4j.PropertyConfigurator; import
 * org.apache.poi.xssf.usermodel.XSSFSheet; import
 * org.apache.poi.xssf.usermodel.XSSFWorkbook; import
 * org.testng.annotations.Test;
 * 
 * import com.relevantcodes.extentreports.ExtentReports; import
 * com.relevantcodes.extentreports.ExtentTest;
 * 
 * 
 * public class DatabaseReport {
 * 
 * private static final String TestData = null;
 * 
 * @Test public void TestVerifyDB() throws Exception{
 * 
 * String fileName = new SimpleDateFormat("yy-MM-dd-HH-mm").format(new Date());
 * String Application = "Database Serivce Now Daily Report"; String
 * HtmlReportPath = "IO/Reports/Html/Report -"+fileName+".html";
 * 
 * ExcelDataProvider excel = new ExcelDataProvider(); ExtentReports report;
 * ExtentTest logger; Logger.getRootLogger().setLevel(Level.OFF); String
 * mainSheet = "Main"; int mainSheetRowCnt = excel.rowCount(mainSheet);
 * 
 * 
 * for (int m = 1; m <= mainSheetRowCnt; m++) { String testCaseSheet =
 * excel.getData(mainSheet, m, 0); String operation = excel.getData(mainSheet,
 * m, 2); if (operation.equalsIgnoreCase("YES")) { // PERFORMING OPERAITON START
 * String sheetname = testCaseSheet; int rowcount = excel.rowCount(sheetname);
 * for (int i = 1; i <= rowcount; i++) {
 * 
 * String LCase = excel.getData(sheetname, i, 0); try{ //step1 load the driver
 * class Logger logger2=Logger.getLogger("Database Testing");
 * PropertyConfigurator.configure(".\\Log4j.properties");
 * 
 * 
 * report=new ExtentReports(HtmlReportPath);
 * logger=report.startTest(Application);
 * 
 * report=new ExtentReports("./HTMLReport/Report-"+".html");
 * 
 * 
 * //step1 load the driver class
 * Class.forName("oracle.jdbc.driver.OracleDriver");
 * DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
 * DriverManager.getDrivers(); Connection con=DriverManager.getConnection(
 * "jdbc:oracle:thin:@//MISCP1.CNSG1FZBXDCU.US-EAST-1.RDS.AMAZONAWS.COM:1521/MISCP1"
 * ,"qcsiteadmin_129","qualitycenter");
 * 
 * Statement stmt=con.createStatement(); // Query
 * 
 * ResultSet rs=stmt.executeQuery(LCase); logger2.
 * info("Defect ID ; External Defect ID  ; Summary ; Description ; Comments ; Severity ; Status ; Assigned_To ; Project  "
 * );
 * 
 * while(rs.next()) logger2.info(rs.getString(1)+" ; "+rs.getString(2)+" ; "
 * +rs.getString(3)+" ; "+rs.getString(4)+" ; "+rs.getString(5)+" ; "+rs.
 * getString(6)+" ; "+
 * rs.getString(7)+" ; "+rs.getString(8)+" ; "+rs.getString(9)+" ; " );
 * //System.out.println(rs.getString(1)+" ; "+rs.getString(2)+" ; "
 * +rs.getString(3)+" ; "+rs.getString(4)+" ; "+rs.getString(5)+" ; "+rs.
 * getString(6)+" ; "+ rs.getString(7)+" ; "+rs.getString(8)+" ; " ); //excel();
 * // Connection Close con.close();
 * 
 * } catch (Exception e) { System.out.println(e.getMessage()); } } }}}
 * 
 * 
 * 
 * 
 * 
 * 
 * public static void excel ()throws IOException{
 * 
 * File src=new File("./log/Output.xlsx"); FileInputStream fis=new
 * FileInputStream(src); XSSFWorkbook wb=new XSSFWorkbook(fis); XSSFSheet sh1=
 * wb.getSheet(TestData);
 * 
 * System.out.println(""+sh1);
 * System.out.println(sh1.getRow(0).getCell(0).getStringCellValue());
 * 
 * sh1.getRow(0).createCell(2).setCellValue("2.41.0"); FileOutputStream fout=new
 * FileOutputStream(new File("./log/Output.xlsx")); wb.write(fout);
 * 
 * }
 * 
 * }
 * 
 * 
 */