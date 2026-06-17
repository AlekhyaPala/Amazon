package stepDefinitions;


import java.time.Duration;


import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;

import io.cucumber.java.Before;

import utils.BaseClass;

public class Hooks extends BaseClass {
	@Before
	public void setup() throws Throwable {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
}

	
	
@After

public void teardown() {
    if (driver != null) {
        driver.quit();
    }
}
	
	
}
