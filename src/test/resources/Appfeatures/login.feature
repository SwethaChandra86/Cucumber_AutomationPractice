Feature: login page 

Scenario: login page title
Given user is on login page
When user gets the title of the page
Then page title should be "Login - My Store"

Scenario: forgot password link
Given user is on login page
Then forgot password link should be displayed

Scenario: login with correct credentials
Given user is on login page
When enters username "swethac.hn86@gmail.com"
And enters password "Ahanaarna2!"
And clicks on login button
Then user gets the title of the page
And the title of page should be "My account - My Store"


