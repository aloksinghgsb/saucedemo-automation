package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadDataFromExcel {

	@Test
	public void readExcel() throws IOException {
//		FileInputStream fis=new FileInputStream(".\\data\\student.xlsx");
//		XSSFWorkbook wb=new XSSFWorkbook(fis);
//		
//		XSSFSheet sheet=wb.getSheetAt(0);
//		
//		
//		int rows=sheet.getLastRowNum();
////		int cols=sheet.getRow(1).getLastCellNum();
//		int cols=sheet.getRow(1).getLastCellNum();
//		
//		for(int r=0;r<rows;r++) {
//			XSSFRow row=sheet.getRow(r);
//			for(int c=0;c<cols;c++) {
//				XSSFCell cell=row.getCell(c);
//				
//				switch(cell.getCellType()) {
//				case STRING:
//					System.out.println(cell.getStringCellValue()); break;
//				case NUMERIC: 
//					System.out.println(cell.getNumericCellValue()); break;
//				case BOOLEAN: 
//					System.out.println(cell.getBooleanCellValue()); break;
//				}
//				
//			}
//			System.out.println();	
//		}
//				
//	}

		// Write data into excel
		Object student[][] = { { "Id", "Name", "Value" }, { 1001, "John", false }, { 1002, "Sonu", true },
				{ 1003, "Yuvi", false }, };

		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet();
		int rows = student.length;
		int cols = student[0].length;
		System.out.println("Rows= " + rows + " Column=" + cols);

		// using for loop
		for (int r = 0; r < rows; r++) {
			XSSFRow row = sheet.createRow(r);
			for (int c = 0; c < cols; c++) {
				XSSFCell cell = row.createCell(c);
				Object value = student[r][c];
				if (value instanceof String)
					cell.setCellValue((String) value);
				if (value instanceof Integer)
					cell.setCellValue((Integer) value);
				if (value instanceof Boolean)
					cell.setCellValue((Boolean) value);
			}
		}

		String EmpExcelFile=".//data//EmpExcelFile.xlsx";
		FileOutputStream fos=new FileOutputStream(EmpExcelFile);
		wb.write(fos);
		System.out.println("Test data writeen successfully into excel sheet");
	}
}
