Feature: About Page and Perspective 

Background: 
	Given user navigates to URL : "${views.url}" application 
	
	#TC-C1263505 
	@SmokeSuite @AboutPagePerspective @Views
Scenario: Open and check About Page [C1263505] 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	Then Verify Login is successful and "Views Portal" Page is displayed 
	When Click on "About" option 
	Then Verify "About Views Portal" window is displayed 
	When Click on OK button in About View Portal Window 
	Then Verify About Views Portal is closed 
	When Click on "Log Out" option 
	Then Verify Artemis Views Login page is displayed 
	
	#TC-C1263512
	@SmokeSuite @AboutPagePerspective @Views
Scenario: Open and check Profile Page as VUSER1 [C1263512] 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	When Click on "Profile" option 
	Then Verify "User Profile" window is displayed in the dialog 
	When Click on "Ok" button in the dialog 
	Then Verify "User Profile" dialog is closed 
	When Click on "Log Out" option 
	Then Verify Artemis Views Login page is displayed 
	
	#TC-C1263507
	@SmokeSuite @AboutPagePerspective @Views
Scenario: Open and check Profile Page as CARRJ [C1263507] 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	When Click on "Profile" option 
	Then Verify "User Profile" window is displayed in the dialog 
	When Click on "Ok" button in the dialog 
	Then Verify "User Profile" dialog is closed 
	When Click on "Log Out" option 
	Then Verify Artemis Views Login page is displayed 
	
	#TC-C1263515
	@SmokeSuite @AboutPagePerspective @Views
Scenario: Change Perspective to User Audit and Dashboard [C1263515] 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	When I click on Business Rule Checker drop down and select "Dashboards" option listed with url "${views.dashboard.url}" 
	Then Verify Login is successful and "Dashboards" Page is displayed 
	When Click on "User Audit" dropdown option 
	Then Verify Login is successful and "User Audit" Page is displayed 
	When Click on "Log Out" option 
	Then Verify Artemis Views Login page is displayed 
	
	#TC-C1255481
	@RegressionSuite @AboutPagePerspective @Views
Scenario: Verify About page in the Views Portal Business rule checker [C1255481] 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views1.userName}" as username "${views1.password}" as password and "${views.dataset}" as DataSet for views portal
	Then Verify Login is successful and "Views Portal" Page is displayed 
	When Click on "About" option 
	Then Verify "About Views Portal" window is displayed 
	And Verify "About" tab is selected by default
	And  Verify the "Product Version" is "Enterprise 2017.4.0.0" 
	And  Verify the "Copyright" is "Copyright © 2017" 
	When  Click on OK button in About View Portal Window 
	Then  Verify About Views Portal is closed 
	When  Click on "Log Out" option 
	Then  Verify "Business Rule Checker" window is closed 
	
	#TC-C1255533
	@RegressionSuite @AboutPagePerspective @Views
	Scenario: Verify the content alignment and font of About page in the Views Portal Business rule checker [C1255533] 
	Then  Verify Artemis Views Login page is displayed 
	When I login using "${views1.userName}" as username "${views1.password}" as password and "${views.dataset}" as DataSet for views portal
	Then  Verify Login is successful and "Views Portal" Page is displayed 
	When  Click on "About" option 
	Then  Verify "About Views Portal" window is displayed 
	And  Verify the "Product Version" is "Enterprise 2017.4.0.0" 
	And  Verify the "Copyright" is "Copyright © 2017" 
	And  Verify "Company" label is in bold font 
	And  Verify "Product Name" label is in bold font 
	And  Verify "Product Version" label is in bold font 
	And  Verify "Copyright" label is in bold font 
	When  Click on OK button in About View Portal Window 
	Then  Verify About Views Portal is closed 
	When  Click on "Log Out" option 
	Then  Verify "Business Rule Checker" window is closed 
	And  Verify Artemis Views Login page is displayed 
	
	#TC-C1255509
	@RegressionSuite @AboutPagePerspective  @Views
	Scenario: Verify export button in the About page in the Views Portal Business rule checker [C1255509] 
	Then  Verify Artemis Views Login page is displayed 
	When I login using "${views1.userName}" as username "${views1.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then  Verify Login is successful and "Views Portal" Page is displayed 
	When  Click on "About" option 
	Then  Verify "About Views Portal" window is displayed 
	And  Verify the "Product Version" is "Enterprise 2017.4.0.0" 
	And  Verify the "Copyright" is "Copyright © 2017" 
	And Verify "About" tab is selected by default
	When  Click on "Export" button in About View Portal Window 
	And  Click on OK button in About View Portal Window 
	Then  Verify About Views Portal is closed 
	When  Click on "Log Out" option 
	Then  Verify "Business Rule Checker" window is closed 
	And  Verify Artemis Views Login page is displayed 
	
	#TC-C1255510
	@RegressionSuite @AboutPagePerspective  @Views
	Scenario: Verify Server page in the Views Portal Business rule checker [C1255510] 
	Then  Verify Artemis Views Login page is displayed 
	When I login using "${views1.userName}" as username "${views1.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then  Verify Login is successful and "Views Portal" Page is displayed 
	When  Click on "About" option 
	Then Verify "About" tab is selected by default
	And  Verify "About Views Portal" window is displayed 
	When  Click on "Server" tab 
	Then  Verify the "App Server Name" is "Tomcat" 
	And  Verify the "App Server Version" is "8.5" 
	And  Verify the "Java Vendor" is "Oracle Corporation" 
	And  Verify the "Java Version" is "1.8.0_92" 
	And  Verify the "Operating System" is "Windows Server 2012 R2" 
	And  Verify the "Operating Version" is "6.3" 
	And  Verify the "OS Architecture" is "amd64" 
	And  Verify the "Database Vendor" is "Oracle" 
	And  Verify the "Locale" is "en" 
	When  Click on OK button in About View Portal Window 
	Then  Verify About Views Portal is closed 
	When  Click on "Log Out" option 
	Then  Verify "Business Rule Checker" window is closed 
	And  Verify Artemis Views Login page is displayed 
	
		#TC-C1255512
		@RegressionSuite @AboutPagePerspective @Views
Scenario: Verify Export button in the Server tab in the About Views Portal page in the Views Portal Business rule checker [C1255512] 
	Then  Verify Artemis Views Login page is displayed 
	When I login using "${views1.userName}" as username "${views1.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then  Verify Login is successful and "Views Portal" Page is displayed 
	When  Click on "About" option 
	Then  Verify "About Views Portal" window is displayed 
	And  Verify the "Product Version" is "Enterprise 2017.4.0.0" 
	And  Verify the "Copyright" is "Copyright © 2017" 
	And Verify "About" tab is selected by default 
	When  Click on "Server" tab 
	Then  Verify the "App Server Name" is "Tomcat" 
	And  Verify the "App Server Version" is "8.5" 
	And  Verify the "Java Vendor" is "Oracle Corporation" 
	And  Verify the "Java Version" is "1.8.0_92" 
	And  Verify the "Operating System" is "Windows Server 2012 R2" 
	And  Verify the "Operating Version" is "6.3" 
	And  Verify the "OS Architecture" is "amd64" 
	And  Verify the "Database Vendor" is "Oracle" 
	And  Verify the "Locale" is "en" 
	When  Click on "Export" button in About View Portal Window 
	And  Click on OK button in About View Portal Window 
	Then  Verify About Views Portal is closed 
	When  Click on "Log Out" option 
	Then  Verify "Business Rule Checker" window is closed 
	
	#TC-C1255534
	@RegressionSuite @AboutPagePerspective @Views
Scenario: Verify content alignment and Font weight of the labels in the Server page in the Views Portal Business rule checker [C1255534] 
	Then  Verify Artemis Views Login page is displayed 
	When I login using "${views1.userName}" as username "${views1.password}" as password and "${views.dataset}" as DataSet for views portal
	Then  Verify Login is successful and "Views Portal" Page is displayed 
	When  Click on "About" option 
	Then Verify "About" tab is selected by default 
	And  Verify "About Views Portal" window is displayed 
	When  Click on "Server" tab 
	Then  Verify the "App Server Name" is "Tomcat" 
	And  Verify the "App Server Version" is "8.5" 
	And  Verify the "Java Vendor" is "Oracle Corporation" 
	And  Verify the "Java Version" is "1.8.0_92" 
	And  Verify the "Operating System" is "Windows Server 2012 R2" 
	And  Verify the "Operating Version" is "6.3" 
	And  Verify the "OS Architecture" is "amd64" 
	And  Verify the "Database Vendor" is "Oracle" 
	And  Verify the "Locale" is "en" 
	And  Verify "App Server Name" label is in bold font 
	And  Verify "App Server Version" label is in bold font 
	And  Verify "Java Vendor" label is in bold font 
	And  Verify "Java Version" label is in bold font 
	And  Verify "Operating System" label is in bold font 
	And  Verify "Operating Version" label is in bold font 
	And  Verify "OS Architecture" label is in bold font 
	And  Verify "Database Vendor" label is in bold font 
	And  Verify "Locale" label is in bold font 
	When  Click on OK button in About View Portal Window 
	Then  Verify About Views Portal is closed 
	When  Click on "Log Out" option 
	Then  Verify "Business Rule Checker" window is closed 
	And  Verify Artemis Views Login page is displayed 
	
	#TC-C1255515
	@RegressionSuite @AboutPagePerspective @Views
Scenario: Verify the additional information in the Views product info text file in the Views Portal Business rule checker [C1255515] 
	Then  Verify Artemis Views Login page is displayed 
	When I login using "${views1.userName}" as username "${views1.password}" as password and "${views.dataset}" as DataSet for views portal
	Then  Verify Login is successful and "Views Portal" Page is displayed 
	When  Click on "About" option 
	Then  Verify "About Views Portal" window is displayed 
	And  Verify the "Product Version" is "Enterprise 2017.4.0.0" 
	And  Verify the "Copyright" is "Copyright © 2017" 
	And Verify "About" tab is selected by default 
	When  Click on "Server" tab 
	Then  Verify the "App Server Name" is "Tomcat" 
	And  Verify the "App Server Version" is "8.5" 
	And  Verify the "Java Vendor" is "Oracle Corporation" 
	And  Verify the "Java Version" is "1.8.0_92" 
	And  Verify the "Operating System" is "Windows Server 2012 R2" 
	And  Verify the "Operating Version" is "6.3" 
	And  Verify the "OS Architecture" is "amd64" 
	And  Verify the "Database Vendor" is "Oracle" 
	And  Verify the "Locale" is "en" 
	When  Click on "Export" button in About View Portal Window 
	And  Click on OK button in About View Portal Window 
	Then  Verify About Views Portal is closed 
	When  Click on "Log Out" option 
	Then  Verify "Business Rule Checker" window is closed 