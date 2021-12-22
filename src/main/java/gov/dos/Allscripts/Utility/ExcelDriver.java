package gov.dos.Allscripts.Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDriver {
	
	public static FileInputStream fis; 
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;  
	public static XSSFRow row;  
	public static XSSFCell cell;  
	
	
	public static String getCelldata(int rownum, int col, String Sheet, String FilePath) throws IOException
	{
		fis = new FileInputStream(FilePath);
		wb = new XSSFWorkbook(fis); 
		sheet = wb.getSheet(Sheet);
		DataFormatter formatter = new DataFormatter();
		return formatter.formatCellValue(sheet.getRow(rownum).getCell(col));
	}
	
	//@SuppressWarnings({ "deprecation", "static-access" })
	public static String setCelldata(String data, int rownum, int col, String NameSheet, String FilePath) throws IOException
	{
		fis = new FileInputStream(FilePath);
		wb = new XSSFWorkbook(fis); 
		sheet = wb.getSheet(NameSheet);
		row = sheet.getRow(rownum);
		cell=row.getCell(col);
		//cell.setCellType(cell.CELL_TYPE_STRING);
		cell.setCellValue(data);
		 FileOutputStream fos = new FileOutputStream(FilePath);
		 wb.write(fos);
		 fos.close();
		String celldata1 = cell.getStringCellValue();
		return celldata1; 
	}
}