package stepDefinitions;


import org.testng.Assert;

import Pages.AddCart;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.BaseClass;

public class AddCartSteps extends BaseClass{
	
	
	
	AddCart addCart= new AddCart(driver);
	@When("User search for product {string}.")
	
	public void searchProduct(String category) {
		addCart.Search(category);
	}
	
	@Then("User selects the {string} appears from the dropdown list.")
	public void chooseProduct(String matchedCriteria) {
		addCart.SearchCatList(matchedCriteria);
	}
	
	@Then("User redirected to results screen.")
	public void ResultScreen() {
		addCart.resultScreen();
	}
	
	
	@And("User click on Add to cart button of the product titled {string}.")
	public void AddCart(String ProductTitle)  {
		addCart.clickAddCart(ProductTitle);
		
	}
	@Then("examine the cart.")
	public void CInfo() {
		addCart.cartInfo(); 
		Assert.assertTrue(addCart.cartCount() != null, "Cart should have items after adding product");	
	    
	}
	
	@And ("delete all added products.")
	public void cDelete() {
		addCart.deleteItem();
		Assert.assertEquals(addCart.cartCount(), "0", "Cart should have Noitems after deleting product");	
	}
	
	
	
}
