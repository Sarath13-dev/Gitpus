package org.testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	public static void main(String[] args) throws IOException{
		
		//create object for File
		File f = new File("D:\\GREENS\\Sample.xlsx");
		
		//read file
		FileInputStream stream = new FileInputStream(f);
		
		//create object for workbook
		Workbook w = new XSSFWorkbook(stream);
		
		//to get Sheet from workbook
		Sheet sheet = w.getSheet("abcd");
		
	//to get all data, read all the rows
		//to find number of Rows
			int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
			
			for (int i = 0; i < physicalNumberOfRows; i++) {
				//to seperate each row
				Row row = sheet.getRow(i);
				//to find number of cell in each row filled with data
				int physicalNumberOfCells = row.getPhysicalNumberOfCells();
				
				for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
					//to seperate each cell
					Cell cell = row.getCell(j);
					//to find cell type
					int cellType = cell.getCellType();
					if(cellType==1) {
						
						String stringCellValue = cell.getStringCellValue();
						System.out.println(stringCellValue);
					}
					else if(DateUtil.isCellDateFormatted(cell)) {
						
						Date dateCellValue = cell.getDateCellValue();
						System.out.println(dateCellValue);
						SimpleDateFormat s = new SimpleDateFormat("yyyy/MM/dd");
						String format = s.format(dateCellValue); 
						System.out.println(format);
					}
					
					
					
					else {
						
						double numericCellValue = cell.getNumericCellValue();
						System.out.println(numericCellValue);
						//type casting
						long l = (long)numericCellValue;
						System.out.println(l);
					}
					
				}
				
				
			}
		
		
		
	}
	
	
}
