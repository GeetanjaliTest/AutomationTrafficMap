Feature: Display the User Audit and Dashboard pages

Background: 
	Given user navigates to URL : "${views.url}" application 
	
@HealthCheck @EvDashBoard @Views
Scenario: Display the User Audit and Dashboard pages [C1262394] 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	Then Verify Login is successful and "Views Portal" Page is displayed 
	When I click on Business Rule Checker drop down and select "Dashboards" option listed with url "${views.dashboard.url}"
	Then I should see "Dashboards" window open	
	When I click on Dashboards drop down
	And I click on "User Audit" menu listed under Business Rule Checker drop down
	Then I should see "User Audit" window open
	When  Click on "Log Out" option 
	Then Verify Artemis Views Login page is displayed 