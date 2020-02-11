Feature: Login into Application

Scenario Outline: Positive test validating login
Given Initialize chrome browser 
And Navigate to "http://www.qaclickacademy.com/" site
And Click on Login link to access login page
When User enter <username> and <password> and logs in
Then Verify the user is successfully logged in
And close browsers


Examples:
|username 	      | password|
|emmilia@gmail.com| 82RabbiT!|
|abc@test.com     | abcd1234|
