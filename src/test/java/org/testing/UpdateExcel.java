package org.testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UpdateExcel {
	
	static int cells;

	public static void main(String[] args) throws IOException {
		
		File f = new File("D:\\GREENS\\mor30.xlsx");
		
		FileInputStream stream = new FileInputStream(f);
		
		Workbook w = new XSSFWorkbook(stream);
		
		Sheet sheet = w.getSheet("abcd");
		List<String>li = new ArrayList();
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				cells = row.getPhysicalNumberOfCells();
				Cell cell = row.getCell(j);
				String stringCellValue = cell.getStringCellValue();
				li.add(stringCellValue);
			}
		}
		Sheet createSheet = w.createSheet("efg7");
		int count =0;
		for (int i = 0; i <sheet.getPhysicalNumberOfRows(); i++) {
			Row createRow = createSheet.createRow(i);
			int k=0;
			for (int j = count; j < cells; j++) {
				
				Cell createCell = createRow.createCell(k);
				createCell.setCellValue(li.get(j));
				k++;
			}
			count=count+cells;
			cells=cells+cells;
		}
		
		FileOutputStream str = new FileOutputStream(f);
		w.write(str);
		
		
		
		
	}
	
	
}
