package com.coel.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.coel.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase(){
		try{
			prop = new Properties();
			String path =  System.getProperty("user.dir") + File.separator + "src" +
			File.separator + "main" + File.separator + "java" + File.separator + "com" +
			File.separator + "coel" + File.separator + "qa" + File.separator + "config" +
			File.separator + "config.properties";
			
//			String path = System.getProperty("C:\\Users\\Sajib\\workspace\\coelautomation\\src\\main\\java\\com\\coelqa\\config\\config.properties");
			Thread.sleep(500);
			System.out.println("Path :" +  path);
			
			FileInputStream ip = new FileInputStream(path) ;
					//new FileInputStream(System.getProperty("/src/main/java/com/coel/qa/config/config.properties"));
			prop.load(ip);
						
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		 
	}
	
	//Initialization method
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		//if(browserName.equals("FireFox")){
		//	System.setProperty("webdriver.gecko.driver", "/Users/Sajib/workspace/browser");
			driver = new FirefoxDriver();
		
//		else if(browserName.equals("chrome")){
//			System.setProperty("webdriver.chrome.driver", "/Users/Sajib/workspace/browser");
//			driver = new ChromeDriver();
//		} 
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		
		
		
		
	}
	
	
	
}
