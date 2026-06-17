package stepDefinitions;



import Pages.HomePage;
import Pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.BaseClass;

public class HomePageSteps extends BaseClass {
		LoginPage loginPage;
		HomePage homePage;
		
@Given ("User is On Amazon home after succesful login.")
public void homePage() {
	
	homePage = new HomePage(driver);
}
@When ("User notice on the top left corner.")
public boolean LogoAtCorner() {
		return homePage.logoPresent();
}

@Then ("amazon logo is visible.")
public boolean LogoVisible() {
	if (LogoAtCorner() == true) {
		System.out.println("Logo is Present");
	}
	return false;
}

@When ("User notice the User profile.")
public boolean UserProAtCorner() {
	return homePage.userInfoPresent();
}
@Then ("User can see User Profile.")
public void userInfoVisible() {
	if (UserProAtCorner() == true) {
		System.out.println("User profile is Present");
		
	}
	
}
@Then ("User can see Hello UserName.")
public void  userInfoTxtVisible() {
	System.out.println(homePage.userInfoTxt());
}


}
