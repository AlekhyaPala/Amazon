Feature: Amazon Home page
 Background:                      # ✅ Runs before every scenario
    Given User is On Amazon login page.
	When user enters a valid user email and pwd.
	Then click on login button.
    
	Scenario: Home page verification.
	Given User is On Amazon home after succesful login.
	When User notice on the top left corner.
	Then amazon logo is visible.
	When User notice the User profile.
	Then User can see User Profile. 
	Then User can see Hello UserName.
	And capture the Screenshot
	
