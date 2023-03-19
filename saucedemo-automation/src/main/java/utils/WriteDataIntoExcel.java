package utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteDataIntoExcel {
	
	@Test
	public void writeData() throws IOException {
	
		XSSFWorkbook wb=new XSSFWorkbook();
		
		XSSFSheet sheet=wb.createSheet();
		
		Object empData[][]= {
				{"EmpID","EMPNAME","JOB","SALARY"},
				{"1001","Raju","Manager","56000"},
				{"1004","Sonu","Teacher","25000"},
					
				};
				
		
		int rows=empData.length;
		int cols=empData[0].length;
		
		for(int r=0;r<rows;r++) {
			XSSFRow row=sheet.createRow(r);
			for(int c=0;c<cols;c++) {
				XSSFCell cell=row.createCell(c);
				Object value=empData[r][c];
				if(value instanceof String)
					cell.setCellValue((String)value);
				if(value instanceof Integer)
					cell.setCellValue((Integer)value);
				if(value instanceof Boolean)
					cell.setCellValue((Boolean)value);
			}
		}
		
		String excelFilePath=".\\data\\EmpTestdata.xlsx";
		FileOutputStream fos=new FileOutputStream(excelFilePath);
		wb.write(fos);
		System.out.println("Test data written successfully into "+excelFilePath+" file");
		
	}

}
