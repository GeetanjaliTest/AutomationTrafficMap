Feature: Check login screen fields validation of the Lyris LM administration UI 

Background: 
	Given user navigates to URL : "${views.url}" application 
	
  @HealthCheck @ViewsPortal @Views
Scenario: Login using different datasets and valid credentials [C1262391] 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Views Portal" Page is displayed 
	When Click on "Log Out" option 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${viewsdefense.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Views Portal" Page is displayed 
	When Click on "Log Out" option 
	Then Verify Artemis Views Login page is displayed
	
@HealthCheck @ViewsPortal @Views
Scenario: Verify that menu pages are displayed [C1262396] 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	When Click on "Rule Execution" from left side menu panel
	When Click on "Basic" from left side menu panel under option
	Then Verify "Rule Execution" page is opened for "Basic" option
	When Click on "Advanced" from left side menu panel under option
	Then Verify "Rule Execution" page is opened for "Advanced" option
	When Click on "Execution History" from left side menu panel
	Then Verify "Execution History" page is opened for "Execution History" option
	When Click on "Administration" from left side menu panel
	When Click on "Group Collections" from left side menu panel under option
	Then Verify "Group Collection Management" page is opened for "Group Collections" option
	When Click on "Group" from left side menu panel under option
	Then Verify "Group Management" page is opened for "Group" option
	When Click on "Rule" from left side menu panel under option
	Then Verify "Rule" page is opened for "Rule" option
	When Click on "Operations" from left side menu panel
	Then Verify "Operations" page is opened for "Operations" option
	When Click on "Log Out" option 
	Then Verify Artemis Views Login page is displayed 
	
@HealthCheck @ViewsPortal @Views
Scenario: Login using different datasets and invalid credentials [C1262405] 
	Then Verify Artemis Views Login page is displayed 
	When Enter Username "CARRJW" and Password "CARRJW" and Dataset "VIEWS" in login panel 
	Then Verify Invalid Username/Password option is displayed 
	When Enter Username "CARRJW" and Password "CARRJW" and Dataset "DEFENSE" in login panel 
	Then Verify Invalid Username/Password option is displayed	
	
@HealthCheck @ViewsPortal @Views
Scenario: Validate the About Page [C1262393] 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Views Portal" Page is displayed 
	When Click on "About" option 
	Then Verify "About Views Portal" window is displayed 
	When Click on OK button in About View Portal Window 
	Then Verify About Views Portal is closed 
	When Click on "Log Out" option 
	Then Verify Artemis Views Login page is displayed 