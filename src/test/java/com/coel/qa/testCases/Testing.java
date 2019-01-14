package com.coel.qa.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Testing {
	WebDriver driver = new FirefoxDriver();
	
	@Test
	public void url(){
	driver.get("http://192.168.100.202:8080/unifiedeagro/auth/login");
	}

}
