package Old_Projects;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataExcel 
	{
	XSSFWorkbook wb;
	public WriteDataExcel()
	
	{
	 try {
		wb = new XSSFWorkbook(new FileInputStream(new File("./TestCases/Test.xlsx")));
	} catch (Exception e) {
		 
		System.out.println("Unable to Load Excel Sheet");
		System.out.println(e.getMessage());
	} 
	}
		
	public String getData(String sheetname,int row , int column) {
		String data = wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
		return data;

}
	public int rowCount (String sheetname) {
		
		
		return wb.getSheet(sheetname).getLastRowNum();
		
	}
	
	
	public String writeExcel(String sheetname,int rownum , int columnnum, String TestData) throws Exception 
	{
		String data = wb.getSheet(sheetname).getRow(rownum).getCell(columnnum).getStringCellValue();
		
		System.out.println("I am here");
		FileInputStream fis = new FileInputStream("./TestCases/Test.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Output");
		//XSSFSheet sheet = workbook.getSheetAt(0);
		Row row = sheet.createRow(1);
		Cell cell = row.createCell(1);
		//cell.setCellType(cell.CELL_TYPE_STRING);
		cell.setCellValue(TestData);
		FileOutputStream fos = new FileOutputStream("./TestCases/Test.xlsx");
		//workbook.write(fos);
		//fos.close();
		return "Pass";
		 

}
}