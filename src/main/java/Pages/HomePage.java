package Pages;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;


public class HomePage {
	
	
	//Locators
	public By amazonLogo = By.id("nav-logo-sprites");
	private By userProfile = By.id("nav-link-accountList");
	private WebDriver driver;
	
	//Constructor
	public HomePage(WebDriver driver) {
		this.driver =driver;
	}
	
	//Actions
	public boolean logoPresent() {
		return driver.findElement(amazonLogo).isDisplayed();
	}
	
	public boolean userInfoPresent() {
		return driver.findElement(userProfile).isDisplayed();
		
	}
	public  String userInfoTxt() {
		return driver.findElement(userProfile).getText();
		
				
	}
	
	
	
	
}
