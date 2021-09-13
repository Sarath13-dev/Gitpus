package org.testing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {

	public static void main(String[] args) throws IOException {
		
		
		//create object for file
		File f = new File("D:\\GREENS\\mor30.xlsx");
		
		//create object for Workbbok interface
		Workbook w = new XSSFWorkbook();
		
		//create a sheet in the workbook
		Sheet createSheet = w.createSheet("abcd");
		
		//create a row
		Row createRow = createSheet.createRow(0);
		
		//create a cell
		Cell createCell = createRow.createCell(0);
		
		//set the value for cell
		createCell.setCellValue("Sarath");
		
		//create object for FileoutputStream
		FileOutputStream stream = new FileOutputStream(f);
		
		w.write(stream);
		
		
		
		
		
	}
	
	
}
