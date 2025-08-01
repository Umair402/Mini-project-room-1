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

The following user story scenarios were tested. (A declarative style was adopted)

```gherkin
Register User (Happy) - successfully create a new user account
  
Given a user wants to create a new account
When they provide a valid username and email
And they enter valid personal information
Then their account should be successfully created
And they should see the account created message
```