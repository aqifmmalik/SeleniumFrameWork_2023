package Old_Projects;

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	 
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.WebDriver;
	 
	public class WriteExcel {
	 
		  
		public static String WriteExcel(String TestData) throws Exception
		{
			FileInputStream fis = new FileInputStream("C:\\Users\\31286\\eclipse-workspace\\WorkDay\\log\\Output.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet("Output");
			//XSSFSheet sheet = workbook.getSheetAt(0);
			Row row = sheet.createRow(1);
			Cell cell = row.createCell(1);
			//cell.setCellType(cell.CELL_TYPE_STRING);
			cell.setCellValue(TestData);
			FileOutputStream fos = new FileOutputStream("C:\\Users\\31286\\eclipse-workspace\\WorkDay\\log\\Output.xlsx");
			workbook.write(fos);
			fos.close();
			return "Pass";
			 
		}
		
		public static String Excel()
		{

	  try {

	  // Specify the file path which you want to create or write

	  File src=new File("./TestCases/R2.xlsx");
	  FileInputStream fis=new FileInputStream(src);
	  XSSFWorkbook wb=new XSSFWorkbook(fis);
	   XSSFSheet sh1= wb.getSheetAt(2);
	 // XSSFSheet sh1 = wb.getSheet("Output");
	   
	  sh1.getRow(0).createCell(2).setCellValue("HCHB - R2 ");

	  sh1.getRow(1).createCell(2).setCellValue("Creating Care");

	  FileOutputStream fout=new FileOutputStream(new File("./TestCases/R2.xlsx"));

	  wb.write(fout);
	  
	  fout.close();

	  } catch (Exception e) {

	   System.out.println(e.getMessage());

	  }
	return null;

	 }

		
		
	}
