package org.testing;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Testing extends BaseClass{

	@BeforeClass
	public static void tc1() {
		browserLaunch("https://www.facebook.com/");	
	}
	
	@Before
	public void verify() {
		Date d1 = new Date();
		System.out.println(d1);
	}
	
	@Test
	public void tc2() {
		WebElement txtUsername = driver.findElement(By.id("email"));
		txtUsername.sendKeys("ramsss");
		WebElement txtPassword = driver.findElement(By.id("pass"));
		txtPassword.sendKeys("1234");
		WebElement button = driver.findElement(By.name("login"));
		button.click();
	}
	
	@After
	public void tc3() {
		Date d  = new Date();
		System.out.println(d);
	}
	
	@AfterClass
	public static void tc4() {
		driver.quit();
	}
	
	
}

















