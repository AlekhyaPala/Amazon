package Pages;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoginPage {
	private WebDriver driver;
	//Locators
	 
	private By signIn = By.xpath("//span[@class='nav-action-inner']");
	private By userEmail = By.id("ap_email_login");
	private By btContinue = By.id("continue");
	private By passwrd =By.id("ap_password");
	private By btsignIn=By.id("signInSubmit");
	
	
	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver= driver;
		
	}
	//Actions
	public void clickSignIn() {
		WebElement menu = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
		WebElement btn = driver.findElement(signIn);
		
		Actions act = new Actions(driver);
		act.moveToElement(menu).moveToElement(btn).click().build().perform();
	}
	
	public void enterUseremail(String email) {
		
		 driver.findElement(userEmail).sendKeys(email);
	}

public void clickContinue() {
	driver.findElement(btContinue).click();
	}
public void enterPWD(String pwd) {
	driver.findElement(passwrd).sendKeys(pwd);
}
public void clickLogin() {
	driver.findElement(btsignIn).click();
}

	
}


