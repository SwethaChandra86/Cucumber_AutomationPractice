Feature: Account page feature

Background:
Given user is already logged into application
|username|password|
|swethac.hn86@gmail.com|Ahanaarna2!|

Scenario: Accounts page title
Given: user is on accounts page
When user gets the title of the page
And the title of page should be "My account - My Store"

Scenario: Accounts section count
Given user is on accounts page
Then user get accounts section count
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|MY WISHLISTS|
|Home|
And accounts section count should be 6