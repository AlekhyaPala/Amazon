Feature: Amazon login
	Scenario: Valid login.
	Given User is On Amazon login page.
	When user enters a valid user email and pwd.
	Then click on login button.
	And capture the Screenshot
