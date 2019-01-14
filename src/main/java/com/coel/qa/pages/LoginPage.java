package com.coel.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.coel.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//PageFactory - OR
	@FindBy (name = "username")
	WebElement username;
	
	@FindBy (name = "password")
	WebElement password;
	
	@FindBy (css = "body > app-root > div > app-login > div > mat-card > mat-card-content > form > div > button")
	WebElement loginButton;
	
	//Initializing the page Objects:
	public LoginPage(){			/// login page constructor
		PageFactory.initElements(driver, this);
		
	}
	
	//methods
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public HomePage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginButton.click();
//		Thread.sleep(3000);
				
		return new HomePage();
	}
	
	
	
	
	 
	

}
