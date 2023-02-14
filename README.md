- Final Selenium Project -
SOFTWARE TESTING USING THE SELENIUM FRAMEWORK
  Niš, feb 2023

Assignment

On the example of the application https://vue-demo.daniel-avellaneda.com/ 
demonstrate the software testing process using the Selenium and TestNG libraries, 
with the complete implementation available on the github account.


Pages
Login Page
Email input field
Password input field
Login button.



Nav Page
Home link
About link
My profile link
Admin button
Cities link from the Admin drop-down menu
Users link from the Admin drop-down menu
Sign up button
Login button
Logout button
Language selection button
EN button from the language drop-down menu
ES button from the language drop-down menu
FR button from the language drop-down menu
CN button from the language drop-down menu


Signup Page
Name field
Email input field
Password input field
Confirm password field
Sign me up button


Cities Page
the New Item button
search input
method that waits for the edit and create dialog to appear
method that waits for the delete dialog to appear
save button from the edit and create dialogs
delete button from the delete dialog
a method that waits for a certain number of rows to appear in the table. 
The method receives the number of rows as a parameter. If the method is called with parameter 5, 
it means that the method waits for 5 rows to appear in the table.
method that returns a cell from a specified row. The method receives row and column 
as parameters and returns td from the table. Eg: if the method is called row=2, cell=3, 
then the method returns the third cell from 2 rows.
method that returns the edit button of the requested row. The method receives 
a row as a parameter and returns a button. For example, if the method is called row=3, 
the method returns the edit button from the third row of the table
method that returns the delete button of the requested row. The method receives 
a row as a parameter and returns a button. For example, if the method is called row=3, 
the method returns the delete button from the third row of the table

Message Pop Up Page
method that waits for the pop up to be visible
Elements that contain message texts
Close button

method that waits for the verify your account dialog to appear
method that returns a header from the verify your account dialog containing the text 
IMPORTANT: Verify your account

Close button from the verify account dialog


Tests
Basic Test

The base class that each test inherits from. This class should have:
baseUrl - url of the page https://vue-demo.daniel-avellaneda.com
beforeClass - where the driver with implicit wait and wait for page load is set and all the pages needed
for testing are created
afterClass - where the driver shuts down
beforeMethod - where the baseUrl page is loaded before each test
afterMethod - where a screenshot of the page is created in case the test fails.
Login Tests

Test #1: Visits the login page
Steps:
Set EN page language
Click on the login button from the navigation
Verify that the route /login appears in the url of the page


Test #2: Checks input types
Steps:
Click on the login button from the navigation
Verify that the email input field for the type attribute has the value email
Verify that the password input field for the type attribute has the value password


Test #3: Displays errors when user does not exist
The data:
email: non-existing-user@gmal.com
password: password123
Steps:
Click on the login button from the navigation
Fill in the login form with login data
Click on the login button
Wait until the error display pop-up is visible
Verify that the error contains the message User does not exist
Verify that the /login route appears in the url of the page


Test #4: Displays errors when password is wrong
The data:
email: admin@admin.com
password: password123
Steps:
Click on the login button from the navigation
Fill in the login form with login data
Click on the login button
Wait until the message display pop-up is visible
Verify that the error contains the message Wrong password
Verify that the /login route appears in the url of the page

Test #5: Login
The data:
email: admin@admin.com
password: 12345
Steps:
Click on the login button from the navigation
Fill in the login form with login data
Verify that the /home route appears in the url of the page


Test #6: Logout
Steps:
Verify that the logout button is visible on the page
Click on the logout button


Signup Tests

Test #1: Visits the signup page
Steps:
Click on the sign up button from the navigation
Verify that the /signup route appears in the url of the page


Test #2: Checks input types
Steps:
Click on the sign up button from the navigation
Verify that the email input field for the type attribute has the value email
Verify that the password input field for the type attribute has the value password
Verify that the confirmation password input field for the type attribute has the value password



Test #3: Displays errors when user already exists
The data:
name: Another User
email: admin@admin.com
password: 12345
confirm password: 12345
Steps:
Click on the sign up button from the navigation
Verify that the /signup route appears in the url of the page
Fill out the registration form with data
Click on the sign up button
Wait until the message display pop-up is visible
Verify that the error contains the message E-mail already exists
Verify that the /signup route appears in the url of the page

Test #4: Signup
The data:
name: Name and surname of the participant
email template: name.surname@itbootcamp.rs
password: 12345
confirm password: 12345
Steps:
Click on the sign up button from the navigation
Fill out the form with registration data
Click on the sign up button
Load the page