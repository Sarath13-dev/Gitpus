package org.testing;

import java.io.IOException;

import org.openqa.selenium.WebElement;

public class Implementation extends BaseClassForAdactin{

	public static void main(String[] args) throws IOException {
		browserLaunch("https://adactinhotelapp.com/");
		AdactinPOM a = new AdactinPOM();
		WebElement txtUsername = a.getUsername();
		enterText(txtUsername, excelRead("D:\\GREENS\\TRAINNING\\Practice2.xlsx", "abcd", 0, 0));
		enterText(a.getPassword(), excelRead("D:\\GREENS\\TRAINNING\\Practice2.xlsx", "abcd", 0, 1));
		buttonClick(a.getLogin());
		
	}
	
	
}
