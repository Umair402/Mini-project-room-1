# Project Goal
Select and automate user stories for the automation exercise website using the Serenity framework and the Page
Object Model pattern.

### Setup
The following is required
- Java 22
- Apache Maven
 
### Run Tests
To run the tests, from the project root directory run:
```shell
mvn clean test
```
 
### Generate Senerity Report
To generate the Serenity test report, from the project root directory run:
```shell
mvn clean verify
```
The generated report can be found in target/site/serenity/index.html

### Selected User Stories and tested Scenarios

The following user story scenarios were tested. 

### Test Case 1

```gherkin
Register User (Happy) - successfully create a new user account (declarative style)

Given a user wants to create a new account
When they provide a valid username and email
And they enter valid personal information
Then their account should be successfully created
And they should see the account created message
```

### Test Case 2
```gherkin
User login (Happy) - successfully logged in
Given I launch the browser
And I navigate to "http://automationexercise.com/"
Then I should see the home page
When I click on the "Login" button
Then I should see "Login to your account" visible
When I enter a correct  email address and password
And I click the "Login" button
Then I should be logged in
And be able to checkout
```

### Test Case 3
```gherkin
User login (Sad) - Incorrect email and password
Given I launch the browser
And I navigate to "http://automationexercise.com"
Then I should see the home page
When I click on the "Signup / Login" button
Then I should see "Login to your account" visible
When I enter an incorrect email address and password
And I click the "Login" button
Then I should see the error message "Your email or password is incorrect!" visible
```

### Test Case 4
```gherkin
Product Page (Happy) - Check product quantity
Given I am on the products page
When I click "View Product" for any product on the product page
And I set the product quantity to 4
And I click the "Add to cart" button
And I click the "View Cart" button
Then I should see the product in the cart with quantity 4
```

### Test Case 5
```gherkin
Product Page (Sad) - Check product quantity
Given I am on the Products page
When I click "View Product" for any product
And I set the product quantity to alphanumeric
And I click the "Add to cart" button
And I Click the cart Navigation cart button
Then I should see an Empty cart! message
```
