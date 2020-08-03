Meta:

Scenario: As a Customer when I search for Alexa, I want to see if the third option on the second page is available for purchase and can be added to the cart.
Given The user navigates to 'www.amazon.com'
And Searches for 'Alexa'
And Navigates to the page number '2'
And Selects the item number '3'
Then The item is available for purchase