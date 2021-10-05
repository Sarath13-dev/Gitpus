package org.testing;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Testing extends BaseClass{

	public static void main(String[] args) {
		browserLaunch("https://www.facebook.com/");
		FacebookHomePage a = new FacebookHomePage();
		WebElement txtUsername = a.getUsername();
		txtUsername.sendKeys("ramsss");
		driver.navigate().refresh();
		String attribute = txtUsername.getAttribute("id");
		System.out.println(attribute);
		System.out.println("network");
		System.out.println("java");
		
	}
	
	
}

















