Feature: This feature is related to Views Portal regression test cases with various scenarios 

Background: 
	Given user navigates to application URL : "${views.url}" application 

#Pre-Condition - User Must be new in order to get Registration Screen	
@RegressionSuite @RegisterUserPassword @Views
Scenario: Login to Business Rule Checker [C1133654] 
	Given I am on Views Login Page
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	When Click on "Log Out" option 
	Then  Verify "Business Rule Checker" window is closed 
	When I login using "${views1.userName}" as username "${views1.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	When Click on "Log Out" option 
	Then  Verify "Business Rule Checker" window is closed 
	
@RegressionSuite @LoginViews @Views
Scenario: Verify Login to Business Rule Checker with a New User [C1133660] 
	Given I am on Views Login Page
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	Then I should see Verify Business Rule Checker Window displayed
	When I logout of Views Portal
	Then I should see default login page displayed
	
@RegressionSuite @ErrorMessages @Views
Scenario: Verify Error Message is displayed when entering invalid Username or Password [C1133656] 
	Given I am on Views Login Page
	When I login using "${views.userName}" as username "WrongPassword" as password and "${views.dataset}" as DataSet for views portal
	Then I should see "Invalid Username/Password" as warning or error message on Login Screen
	When I login using "WrongUserName" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	Then I should see "Invalid Username/Password" as warning or error message on Login Screen
	When I login using "${views.userName}" as username "${views.password}" as password and "WrongDataSet" as DataSet for views portal
	Then I should see "Invalid Dataset" as warning or error message on Login Screen
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	Then I should see Verify Business Rule Checker Window displayed
	When Click on "Log Out" option 
	Then I should see default login page displayed

@RegressionSuite @PasswordChangeScreen @Views
Scenario: Verify Change password screen in the Views Portal Application [C1255267]
	Given I am on Views Login Page
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	When I click on "Profile" menu item from User Menu
	Then I should see User Profile window displayed
	When I click on change password link in User Profile Window
	Then I should see change password screen open
	And I should verify all three text fields available with Ok and Cancel buttons
	When I click on "Cancel" button on change password screen
	Then I should see User Profile window displayed
	When I click OK button on User Profile window
	And I logout of Views Portal
	Then I should see default login page displayed

@RegressionSuite @PasswordChangeScreen @Views
Scenario: Verify mandatory field validation in the Change password screen in the Views Portal Application [C1255326]
	Given I am on Views Login Page
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	When I click on "Profile" menu item from User Menu
	Then I should see User Profile window displayed
	When I click on change password link in User Profile Window
	Then I should see change password screen open
	And I should verify all three text fields available with Ok and Cancel buttons
	When I click on "OK" button on change password screen
	Then I should see "Mandatory" warning displayed on change Password Screen fields
	When I click on "Cancel" button on change password screen
	Then I should see User Profile window displayed
	When I click OK button on User Profile window
	And I logout of Views Portal
	Then I should see default login page displayed

@RegressionSuite @PasswordChangeScreen @Views
Scenario: Verify validation when user enter current password is New password in the Change Password screen [C1255274]
	Given I am on Views Login Page
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	When I click on "Profile" menu item from User Menu
	Then I should see User Profile window displayed
	When I click on change password link in User Profile Window
	Then I should see change password screen open
	And I should verify all three text fields available with Ok and Cancel buttons
	When I input "${views.password}" as current password, "${views.password}" as new password and "${views.password}" as confirm new password
	And I click on "OK" button on change password screen
	Then I should see "SamePassword" warning displayed on change Password Screen fields
	When I click on "Cancel" button on change password screen
	Then I should see User Profile window displayed
	When I click OK button on User Profile window
	And I logout of Views Portal
	Then I should see default login page displayed

@RegressionSuite @PasswordChangeScreen @Views
Scenario: Verify validation when user enter current password as invalid in the Change Password screen [C1255275]
	Given I am on Views Login Page
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	When I click on "Profile" menu item from User Menu
	Then I should see User Profile window displayed
	When I click on change password link in User Profile Window
	Then I should see change password screen open
	And I should verify all three text fields available with Ok and Cancel buttons
	When I input "VUSER12" as current password, "${views.password}" as new password and "${views.password}" as confirm new password
	And I click on "OK" button on change password screen
	Then I should see "InvalidPassword" warning displayed on change Password Screen fields
	When I click on "Cancel" button on change password screen
	Then I should see User Profile window displayed
	When I click OK button on User Profile window
	And I logout of Views Portal
	Then I should see default login page displayed

@RegressionSuite @PasswordChangeScreen	@Views
Scenario: Verify validation when user enter New password not equal to Confirm Password in the Change Password screen [C1255284]
	Given I am on Views Login Page
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	When I click on "Profile" menu item from User Menu
	Then I should see User Profile window displayed
	When I click on change password link in User Profile Window
	Then I should see change password screen open
	And I should verify all three text fields available with Ok and Cancel buttons
	When I input "${views.password}" as current password, "${views.password}+11" as new password and "${views.password}+1" as confirm new password
	And I click on "OK" button on change password screen
	Then I should see "Password didn't match" warning displayed on change Password Screen for "Confirm Password" field
	When I click on "Cancel" button on change password screen
	Then I should see User Profile window displayed
	When I click OK button on User Profile window
	And I logout of Views Portal
	Then I should see default login page displayed

@RegressionSuite @PasswordChangeScreen @Views
Scenario: Verify password Policycheck in the Change Password screen [C1255286]
	Given I am on Views Login Page
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	When I click on "Profile" menu item from User Menu
	Then I should see User Profile window displayed
	When I click on change password link in User Profile Window
	Then I should see change password screen open
	And I should verify all three text fields available with Ok and Cancel buttons
	When I input "${views.password}" as current password, "TEST" as new password and "TEST" as confirm new password
	And I click on "OK" button on change password screen
	Then I should see "PasswordPolicy" warning displayed on change Password Screen fields
	When I click on "Cancel" button on change password screen
	Then I should see User Profile window displayed
	When I click OK button on User Profile window
	And I logout of Views Portal
	Then I should see default login page displayed

@RegressionSuite @PasswordChange  @Views
Scenario: Display User Profile window and Change Password [C1133662]
	Given I am on Views Login Page
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	When I click on "Profile" menu item from User Menu
	Then I should see User Profile window displayed
	When I click on change password link in User Profile Window
	Then I should see change password screen open
	And I should verify all three text fields available with Ok and Cancel buttons
	When I input "${views.password}" as current password, "CCARRJ" as new password and "CCARRJ" as confirm new password
	When I click on "OK" button on change password screen
	Then I should see password changed status on User Profile Page
	When I click OK button on User Profile window
	When I logout of Views Portal
	Then I should see default login page displayed 
	# Post-Condition - Password change should be restored or same case can be run again using previous password to make it current.	
	When user navigates to URL : "${views.url}" application 
	When Enter Username "${views.userName}" and Password "CCARRJ" and Dataset "${views.dataset}" in login panel 
	And Click on Login Button 
	When Click on "Profile" option 
	Then Verify "User Profile" window is displayed in the dialog 
	When Click on "Change Password" link in User Profile overlay 
	And Put "CCARRJ" in "Current Password" under User Profile overlay 
	And Put "CARRJ" in "New Password" under User Profile overlay 
	And Put "CARRJ" in "Confirm Password" under User Profile overlay 
	And Click on OK Button inside the dialog change password 
	Then Verify "Password changed successfully" text is visible in the dialog 
	And Click on OK Button inside the dialog basic info 
	Then Verify "User Profile" dialog is closed 
	When Click on "Log Out" option 	