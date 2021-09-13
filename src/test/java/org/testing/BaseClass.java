package org.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	public static WebDriver driver;
	
	public static void browserLaunch(String url) {
		
System.setProperty("webdriver.chrome.driver", "C:\\Users\\RAM SARATH KUMAR\\eclipse-workspace\\MorningBatch30\\driver\\chromedriver.exe");
		
		 driver = new ChromeDriver();
		
		driver.get(url);
		
		System.out.println("modified");
		
		System.out.println("generATED");
		
	}
	
	
}
