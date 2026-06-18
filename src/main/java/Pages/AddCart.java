package Pages;

import java.io.File;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCart{

	//Locators
	private By search = By.id("twotabsearchtextbox");
	private By searchcatlist = By.xpath("//div[@class ='s-suggestion-container']/div[@role='button']");
	
	private By addCartbtn = By.id("add-to-cart-button");
	private By cartinfo =By.xpath("//span[@id='nav-cart-count']");
	private By cartCount = By.id("nav-cart-count");
	private By deleTe	= By.xpath("//ul[@data-name=\"Active Items\"]//input[@value='Delete']");
	private WebDriver driver;
	private WebDriverWait wait;
	
	//Constructor
	public AddCart(WebDriver driver){
		this.driver= driver;
		this.wait= new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	//Actions
	
	//Search
	public void Search(String category) {
		WebElement Search = wait.until(ExpectedConditions.visibilityOfElementLocated(search));
		Search.click();        // ensure focus
		Search.clear();
		Search.sendKeys(category);
			}
	
	//SearchCatList
	public void SearchCatList(String matchedCriteria) {
		
		/*try { Thread.sleep(2000); } catch (InterruptedException ignored) {}*/

	    // DEBUG: take screenshot of current page state
	    try {
	        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        Files.copy(screenshot.toPath(),
	                   Paths.get("debug_screenshot.png"),
	                   StandardCopyOption.REPLACE_EXISTING);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    // DEBUG: print search box value to console
	    WebElement Search = driver.findElement(search); 
	    System.out.println("Search box value =" + Search.getAttribute("value"));

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(searchcatlist));
		 List<WebElement> suggestedlist = driver.findElements(searchcatlist);
		 
		 for(WebElement Selectitem:suggestedlist) {
			
				boolean Finalitem= Selectitem.getText().equals(matchedCriteria);
				if (Finalitem==true) {
					Selectitem.click();
					return;
				}
		 }
		
	    throw new RuntimeException("Dropdown kept refreshing - could not select: " + matchedCriteria);
	        }
	
// After selecting the search item category for dropdown it will navigate result screen
	//validating result screen
	public void resultScreen() {
		
		String title = driver.getTitle();
		if(title.equals("Amazon.in : soap mould")||title.equals("Amazon.in : babyboy dress 2-3 years")) {
		wait.until(ExpectedConditions.titleContains(title));
		} else
			throw new RuntimeException("title did not matched");
	}
	
//Adding product to cart	

	public void clickAddCart(String ProductTitle) {
		String xpath = String.format(
		        "//div[@data-component-type='s-search-result']" +
		        "[.//h2//span[contains(text(),'%s')]]",
		        ProductTitle);
	    
		List <WebElement> items = driver.findElements(By.xpath(xpath));
		System.out.println(items);
		wait.until(ExpectedConditions.visibilityOfAllElements(items));
		
		/*for(WebElement item: items) {
			WebElement productLink = wait.until(ExpectedConditions.elementToBeClickable(item));
		    
		    */
		    System.out.println("Products size:" + items.size());
		    
		    for(int i=1; i< 3; i++) {
		    	items = driver.findElements(By.xpath(xpath));
		    	WebElement productLink = wait.until(
		                ExpectedConditions.elementToBeClickable(items.get(i)));
		    	
		    	System.out.println("Product details" + productLink.getText());
		    	String ParentID = driver.getWindowHandle(); //Getting parent window ID
		    	System.out.println("Parent window ID" +ParentID);
		    	productLink.click();
		    	
		    	//wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		    
		    Set<String> WindowIDs= driver.getWindowHandles(); // Get list of open window IDs
		    
		    for(String WindowID: WindowIDs) {
		 
		    	
		    	if(!WindowID.equals(ParentID)) {
		    		String childwindowID = WindowID; //Getting child window ID
		   
		    		driver.switchTo().window(childwindowID);
		    
		    		JavascriptExecutor js = (JavascriptExecutor) driver;
		    		js.executeScript("window.scrollBy(0, +600);"); 
		    		
		    WebElement addButton = wait.until(ExpectedConditions.presenceOfElementLocated(addCartbtn));
		    addButton.click();
		    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartCount));
		    driver.close();
		    			}
		    	 
		    }
		    driver.switchTo().window(ParentID);	
		    wait.until(ExpectedConditions.numberOfWindowsToBe(1));
		    	}
		    }
		

	
	// cart count
	public String cartCount() {
	    return driver.findElement(cartCount).getText();
	}
	
	
	//cart info
	public void   cartInfo() {
		driver.findElement(cartinfo).click();
		System.out.println("Cart count: " + cartCount());
		
			}

	// delete added cart items
	
	public void deleteItem() {
		List<WebElement> deletecount = driver.findElements(deleTe);
		System.out.println(deletecount.size());
		int count = deletecount.size();
		for(int i = 0; i < count; i++) {
			try {
			deletecount.get(i).click(); 
			System.out.println("After delete, cart count: " +
			        wait.until(ExpectedConditions.visibilityOfElementLocated(
			            cartCount)).getText());}
			catch(IndexOutOfBoundsException e) {
				System.out.println("IndexOutOfBoundsException" + e);
			}
			}
	}

	}


