Feature: This feature is related to Views Portal regression test cases with various scenarios 

Background: 
	Given user navigates to application URL : "${views.url}" application 
	
@RegressionSuite @LoginViews @Views
Scenario: Validate Login, Logout and Show Profile [C1133672] 
	Given I am on Views Login Page
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	Then I should see Verify Business Rule Checker Window displayed
	When I click on "Profile" menu item from User Menu
	Then I should see User Profile window displayed
	When I click OK button on User Profile window
	And I logout of Views Portal
	Then I should see default login page displayed
	
@RegressionSuite @LoginViews1 @Views
Scenario: Verify the Views Portal Application when user logout the application in one tab and working on application in another tab for same browser [C1256077] 
	Given I am on Views Login Page
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	Then I should see Verify Business Rule Checker Window displayed
	When I open a new tab and hit "${views.url}" url
	And I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	Then I should see Verify Business Rule Checker Window displayed
	When I switch back to first tab
	And I logout of Views Portal
	Then I should see default login page displayed
	When I switch back to second tab
	And I click on "Group Collections" under Administration Menu
	Then I should see default login page displayed as redirection
	
@RegressionSuite @LoginViews1 @Views
Scenario: Verify the Views Portal Application when user close the application in one tab and working on application in another Tab in same Browser [C1255895] 
	Given I am on Views Login Page
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	Then I should see Verify Business Rule Checker Window displayed
	When I open a new tab and hit "${views.url}" url
	And I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	Then I should see Verify Business Rule Checker Window displayed
	When I close first tab opened earlier
	And I switch back to second tab
	And I click on "Group Collections" under Administration Menu
	Then I should see "Group Collection Management" panel displayed
	And I logout of Views Portal
	Then I should see default login page displayed
	
	@RegressionSuite @LoginViews1 @Views
Scenario: Verify the Views Portal Application when user logout the application in one browser and working on application in another browser [C1256076] 
	Given I am on Views Login Page
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	Then Verify Login is successful and "Views Portal" Page is displayed 
	When I open a new browser and hit "${views.url}" url
	And I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal in new browser
	Then Verify Login is successful and "Views Portal" Page is displayed in new browser
	When Click on "Log Out" option 
	Then Verify Artemis Views Login page is displayed 
	When Click on "Administration" from left side menu panel in new browser
	And Click on "Group Collections" from left side menu panel under option in new browser
	Then Verify "Group Collection Management" page is opened for "Group Collections" option in new browser
	When Click on "Log Out" option in new browser
	Then  Verify "Business Rule Checker" window is closed in new browser
	When Close the new broswer