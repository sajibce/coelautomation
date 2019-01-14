package com.coel.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.coel.qa.base.TestBase;
import com.coel.qa.pages.HomePage;
import com.coel.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
		
	
	public LoginPageTest(){			///constructor of this class (LoginPageTest)
		super();					/// calling super class constructor
	}
	
	
	@BeforeMethod
	public void setUp(){
		
		initialization();
		loginpage = new LoginPage();				///creating object of 'LoginPage' class
			
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginpage.validateLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "COEL" );		
	}
	
	
	@Test(priority=2)
	public void loginTest(){
		try{
//		Thread.sleep(3000);
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
//		System.out.println(prop.getProperty("password"));
				
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
	@Test(priority=3)
	public void loginTestInvalidCredentials(){
		try{
		homepage = loginpage.login("abcd","1234");				
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	@Test(priority=4)
	public void loginTestInvalidPwd(){
		try{
		homepage = loginpage.login(prop.getProperty("username"),"1234");
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	@Test(priority=5)
	public void loginTestEmptyCred(){
		try{
		homepage = loginpage.login("","");	
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
