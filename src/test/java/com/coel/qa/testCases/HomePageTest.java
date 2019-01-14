package com.coel.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.coel.qa.base.TestBase;
import com.coel.qa.pages.HomePage;
import com.coel.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homePage;
	
	public HomePageTest(){				///constructor of HomePageTest (this class)
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		
		initialization();
		loginpage = new LoginPage();				///creating object of 'LoginPage' class
		homePage = loginpage.login(prop.getProperty("username"),  prop.getProperty("password"));
		
			
	}
	
	@Test
	public void validateHomePageTitleTest(){
		String home_Page = homePage.validateHomePageTitle();
		Assert.assertEquals(home_Page, "COEL", "Home page title not mathched");
	}
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
		

}
