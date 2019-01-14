package com.coel.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.coel.qa.base.TestBase;

public class HomePage extends TestBase {
	
	
	
	//PageFactory - OR
		@FindBy (css = "body > app-root > div > app-template > div > main > app-organization-list > header > mat-toolbar > div > div:nth-child(2) > mat-label)")
		WebElement logedinusername ;
		
		@FindBy (css = "body > app-root > div > app-template > div > main > app-organization-list > header > mat-toolbar > div > div:nth-child(2) > button > span > mat-icon")
		WebElement logouticon ;
		
		@FindBy (css = "body > app-root > div > app-template > div > main > app-organization-list > header > mat-toolbar > div > div:nth-child(1) > button:nth-child(2)")
		WebElement loglink ;
		
		@FindBy (css = "body > app-root > div > app-template > div > main > app-organization-list > header > mat-toolbar > div > div:nth-child(1) > button:nth-child(3) > span > mat-label")
		WebElement appErrorLogLink ;
		
		@FindBy (css = "body > app-root > div > app-template > div > main > app-organization-list > div.app-container.mat-elevation-z8 > mat-table > mat-header-row > mat-header-cell.mat-header-cell.cdk-column-action.mat-column-action.ng-star-inserted > button > span")
		WebElement addOrgButton ;		

		@FindBy (css = "body > app-root > div > app-template > div > main > app-organization-list > div.app-container.mat-elevation-z8 > mat-table > mat-row:nth-child(2) > mat-cell.mat-cell.cdk-column-name.mat-column-name.ng-star-inserted > a")
		WebElement dhakatestorgLink ;

		//Initializing the page Objects:
		public HomePage(){			/// login page constructor
			PageFactory.initElements(driver, this);
			
		}
		
		//Methods
		public String validateHomePageTitle(){
			return driver.getTitle();
		}
		
		//validate logedin user name
		public void validateusername(){
			String user_name = logedinusername.getText();
			System.out.println(user_name);			
		}
		
		//validate logout icon 
		public boolean validateLogoutIcon(){
			logouticon.isDisplayed();
			
		}
		
		// App Log Page
		public AppLogPage clickOnLogLink(){
			loglink.click();			
			return new AppLogPage();
		}
		
		// App Error Log page
		public AppErrorLogPage clickOnErrorLogLink(){
			appErrorLogLink.click();			
			return new AppErrorLogPage();
		}
		
		public AddOrgPage clickOnAddButton(){
			addOrgButton.click();			
			return new AddOrgPage();
		}
		
		public ViewOrgPage clickOnDhakaTestorg(){
			dhakatestorgLink.click();			
			return new ViewOrgPage();
		}
		
		
		
		
}
