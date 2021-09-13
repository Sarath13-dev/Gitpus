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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseClassForAdactin {

	static WebDriver driver;
	
	public static void browserLaunch(String url) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\RAM SARATH KUMAR\\eclipse-workspace\\MorningBatch30\\driver\\chromedriver.exe");
		 driver = new ChromeDriver();
		driver.get(url);
	}
	
	public static WebElement locators(String locators, String value) {
		if(locators.equals("id")) {
		WebElement element = driver.findElement(By.id(value));
		return element;
	}
		else if(locators.equals("name")) {
			WebElement element = driver.findElement(By.name(value));
			return element;
		}
		else {
			WebElement element = driver.findElement(By.xpath(value));
			return element;
		
		}
}
	
	public static void enterText(WebElement element,String text) {
		element.sendKeys(text);	
	}

	public static void buttonClick(WebElement element) {
		
		element.click();
	}
	
	public static void selectionByIndex(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
		
	}
	
	public static String excelRead(String path, String sheetname, int rownum, int cellnum) throws IOException {
		File f = new File(path);
		FileInputStream str = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(str);
		Sheet sheet = w.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		int cellType = cell.getCellType();
		if(cellType==1) {
			String data = cell.getStringCellValue();
			return data;
		}
		else if(DateUtil.isCellDateFormatted(cell)) {
			Date dateCellValue = cell.getDateCellValue();
			SimpleDateFormat sim = new SimpleDateFormat("dd/MM/yyyy");
			String format = sim.format(dateCellValue);
			return format;
		}
		else {
			double numericCellValue = cell.getNumericCellValue();
			long l = (long)numericCellValue;
			String valueOf = String.valueOf(l);
			return valueOf;
		}
	}
	
	
	
	
}
	
	






























	
	
	
	
	
	
	
	
	
	