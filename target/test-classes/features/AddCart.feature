Feature: User must be able to add the selected product to the cart
Background:
 	Given User is On Amazon login page.
	When user enters a valid user email and pwd.
	Then click on login button.
	And  User is On Amazon home after succesful login.

Scenario: User must be able to add the selected product to the cart using Add Cart button.
	When User search for product "<category>".
	Then User selects the "<matchedCriteria>" appears from the dropdown list.
	Then User redirected to results screen.
	And User click on Add to cart button of the product titled "<ProductTitle>".
	Then examine the cart.
	And delete all added products.
	And capture the Screenshot
Examples:
	 
      | category | matchedCriteria              |ProductTitle|
      | babyboy  | babyboy dress 2-3 years      |Pyjamas Set|
      | babyboy  | babyboy dress 2-3 years      |Kuchipoo|
      | soap     | soap mould                   |Silicone Mould |
      | soap     | soap mould                   |Soap Base|
	
	

