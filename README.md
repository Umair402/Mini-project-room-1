# Project Goal
Select and automate user stories for the automation exercise website using the Serenity framework and the Page
Object Model pattern.

### Setup
The following is required
- Java 22
- Apache Maven

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
Register User (Happy) - successfully logged in
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
