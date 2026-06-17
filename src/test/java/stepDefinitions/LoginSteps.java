package stepDefinitions;



import java.time.Duration;

import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.BaseClass;

public class LoginSteps extends BaseClass {
	
	LoginPage loginPage;

	
	@Given ("User is On Amazon login page.")
	public void UseronLoginpage() {
	 
	 
	 loginPage = new LoginPage(driver);
	 driver.get("https://www.amazon.in");
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 loginPage.clickSignIn();
	}
	
	@When ("user enters a valid user email and pwd.")
	public void validemail() {
		loginPage.enterUseremail("9515761817");
		loginPage.clickContinue();

		loginPage.enterPWD("9515761817");
	}
	
		
	@Then ("click on login button.")
	public void clkLogin(){
	
		loginPage.clickLogin();
		
		
	}
	
	
	}
