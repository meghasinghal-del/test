@SmokeTest
Feature: Login test

@tag1
Scenario: Successful Login with valid credentials
Given user is on home page
And Click on Login link
When When enters email and password and click login


| email | password   |
|pratiksha@test.com   |pratiksha |
|rick@test.com   |tester |
			
Then Users logged in successfully