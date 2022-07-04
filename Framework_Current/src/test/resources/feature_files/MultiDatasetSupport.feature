Feature: Multi Dataset Support

Background: 
	Given user navigates to URL : "${views.url}" application 
	
	#TC-C1263287
	@SmokeSuite @MultiDatasetSupport  @Views
Scenario: Open and Validate Dataset [C1263287] 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Views Portal" Page is displayed 
	When Select "Dataset" dropdown option 
	Then Verify "Dataset Management" window is displayed in the dialog 
	Then Verify "VIEWS" Dataset are listed 
	Then Verify "DEFENSE" Dataset are listed 
	When Click on OK button in About View Portal Window 
	Then Verify "Dataset Management" Portal is closed 
	When Click on "Log Out" option 
	Then Verify Artemis Views Login page is displayed 
	
	#TC-C1255893
	@RegressionSuite @MultiDatasetSupport @Views
Scenario: Verify that VUSER1 can log into the Views Portal Business rule checker application using VIEWS dataset [C1255893] 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views1.userName}" as username "${views1.password}" as password and "${views.dataset}" as DataSet for views portal
	Then Verify Login is successful and "Views Portal" Page is displayed 
	When Click on "Administration" from left side menu panel 
	Then Verify "Group Collections" option is visible in left side panel 
	Then Verify "Group" option is visible in left side panel 
	Then Verify "Group" option is visible in left side panel 
	When Click on "Operations" from left side menu panel under option 
	Then Verify "Operations" page is opened for "Operations" option 
	Then Verify Views data set is displayed 
	When Click on "Log Out" option 
	Then  Verify "Business Rule Checker" window is closed 
	
	#TC-C1255537
	@RegressionSuite @MultiDatasetSupport @Views
Scenario: Verify Dataset managemnet page in the Views Portal Business rule checker [C1255537] 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views1.userName}" as username "${views1.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Views Portal" Page is displayed 
	When Select "Dataset" dropdown option 
	Then Verify "Dataset Management" window is displayed in the dialog 
	Then Verify "VIEWS" Dataset are listed 
	Then Verify "DEFENSE" Dataset are listed 
	When Click on OK button in About View Portal Window 
	Then Verify "Dataset Management" Portal is closed 
	When Click on "Log Out" option 
	Then Verify Artemis Views Login page is displayed 
	Then  Verify "Business Rule Checker" window is closed  
	
	#TC-C1255894
	@RegressionSuite @MultiDatasetSupport @Views
Scenario: 	Verify that ART1DFNS can log into the Views Portal Business rule checker application using DEFENSE  dataset [C1255894] 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${viewsdefense.userName}" as username "${viewsdefense.password}" as password and "${viewsdefense.dataset}" as DataSet for views portal
	Then Verify Login is successful and "Views Portal" Page is displayed 
	When Click on "Administration" from left side menu panel 
	Then Verify "Group Collections" option is visible in left side panel 
	Then Verify "Group" option is visible in left side panel 
	Then Verify "Rule" option is visible in left side panel 
	Then Verify "Operations" option is visible in left side panel 
	When Click on "Operations" from left side menu panel under option 
	Then Verify "Operations" page is opened for "Operations" option 
	Then Verify Defense data set is displayed 
	When Click on "Log Out" option 
	Then  Verify "Business Rule Checker" window is closed 
	
	#TC-C1255645
	@RegressionSuite @MultiDatasetSupport @Views
Scenario: Verify Add functionality in the Data set management page in the Views Portal Business rule checker [C1255645] 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views1.userName}" as username "${views1.password}" as password and "${views.dataset}" as DataSet for views portal
	Then Verify Login is successful and "Views Portal" Page is displayed 
	When Select "Dataset" dropdown option 
	Then Verify "Dataset Management" window is displayed in the dialog 
	When Click on Add button in Group Collection Management 
	Then Verify "Add Dataset" tab is displayed 
	When Input "Testdataset" in "Dataset" field in Group Management 
	When Input "Test" in "Database" field in Group Management 
	When Input "Super" in "User" field in Group Management 
	When Input "password1" in "Password" field in Group Management 
	When Input "Test" in "Host" field in Group Management 
	When Input "1010" in "Port" field in Group Management 
	When Input "1212" in "Driver" field in Group Management 
	When Input "test@a.cm" in "URL" field in Group Management 
	And Click on "Save" button in Group Collection 
	Then Verify "Info" page is displayed 
	When Click on "OK" button in info popup 
	Then Verify "Testdataset" Dataset are listed 
	When Click on OK button in About View Portal Window 
	Then Verify "Dataset Management" Portal is closed 
	When Click on "Log Out" option 
	
	#TC-C1255646
	@RegressionSuite @MultiDatasetSupport @Views
Scenario: Verify Edit functionality in the Data set management page in the Views Portal Business rule checker [C1255646] 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views1.userName}" as username "${views1.password}" as password and "${views.dataset}" as DataSet for views portal
	Then Verify Login is successful and "Views Portal" Page is displayed 
	When Select "Dataset" dropdown option 
	Then Verify "Dataset Management" window is displayed in the dialog 
	Then Verify "VIEWS" Dataset are listed 
	Then Verify "DEFENSE" Dataset are listed 
	Then Verify "Testdataset" Dataset are listed 
	When Click on "Testdataset" group name 
	When Click on Edit button in the header 
	Then Verify "Edit Dataset" tab is displayed 
	When Input "Test1" in "Database" field in Group Management 
	And Click on "Save" button in Group Collection 
	Then Verify "Info" page is displayed 
	When Click on "OK" button in info popup 
	Then Verify "Test1" Database are listed 
	When Click on OK button in About View Portal Window 
	Then Verify "Dataset Management" Portal is closed 
	When Click on "Log Out" option 
	
	#TC-C1255648
	@RegressionSuite @MultiDatasetSupport @Views
Scenario: Verify validate Dataset functionality in the Data set management page  in the Views Portal Business rule checker [C1255648] 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views1.userName}" as username "${views1.password}" as password and "${views.dataset}" as DataSet for views portal
	Then Verify Login is successful and "Views Portal" Page is displayed 
	When Select "Dataset" dropdown option 
	Then Verify "Dataset Management" window is displayed in the dialog 
	When Click on "Testdataset" group name 
	When Click on Validate Dataset button in the header 
	Then Verify "Info" page is displayed 
	Then Verify "Validation failed" text shown in the popup 
	When Click on "OK" button in info popup 
	When Click on "VIEWS" group name 
	When Click on Validate Dataset button in the header 
	Then Verify "Info" page is displayed 
	Then Verify "validated successfully" text shown in the popup 
	When Click on "OK" button in info popup 
	When Click on OK button in About View Portal Window 
	Then Verify "Dataset Management" Portal is closed 
	When Click on "Log Out" option 
	Then  Verify "Business Rule Checker" window is closed 
	
	#TC-C1255650
	@RegressionSuite @MultiDatasetSupport  @Views
Scenario: 	Verify Delete functionality in the Data set management page in the Views Portal Business rule checker [C1255650] 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views1.userName}" as username "${views1.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Views Portal" Page is displayed 
	When Select "Dataset" dropdown option 
	Then Verify "Dataset Management" window is displayed in the dialog 
	When Click on "Testdataset" group name 
	When Click on Delete Dataset button in the header 
	Then Verify "Info" page is displayed 
	Then Verify "Do you want to delete this dataset" text shown in the popup 
	When Click on "No" button in info popup 
	Then Verify "Testdataset" Dataset are listed 
	When Click on "Testdataset" group name 
	When Click on Delete Dataset button in the header 
	When Click on "Yes" button in info popup 
	Then Verify "The dataset is deleted successfully" text shown in the popup 
	When Click on "OK" button in info popup 
	Then Verify "Testdataset" is not displayed in result list 
	When Click on OK button in About View Portal Window 
	Then Verify "Dataset Management" Portal is closed 
	When Click on "Log Out" option 
	Then  Verify "Business Rule Checker" window is closed 
	
	#TC-C1255652
	@RegressionSuite @MultiDatasetSupport @Views
Scenario: User try to create DISABLED dataset in the Views Portal Business rule checker [C1255652] 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views1.userName}" as username "${views1.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Views Portal" Page is displayed 
	When Select "Dataset" dropdown option 
	Then Verify "Dataset Management" window is displayed in the dialog 
	When Click on Add button in Group Collection Management 
	Then Verify "Add Dataset" tab is displayed 
	When Input "DISABLED" in "Dataset" field in Group Management 
	When Input "Test" in "Database" field in Group Management 
	When Input "Super" in "User" field in Group Management 
	When Input "password1" in "Password" field in Group Management 
	When Input "Test" in "Host" field in Group Management 
	When Input "1010" in "Port" field in Group Management 
	When Input "1212" in "Driver" field in Group Management 
	When Input "test@a.cm" in "URL" field in Group Management 
	And Click on "Save" button in Group Collection 
	Then Verify "Dataset" input box highlighted with red color 
	And Click on "Cancel" button in Group Collection 
	When Click on OK button in About View Portal Window 
	Then Verify "Dataset Management" Portal is closed 
	When Click on "Log Out" option 
	Then  Verify "Business Rule Checker" window is closed 
	
	#TC-C1255657
	@RegressionSuite @MultiDatasetSupport @Views
Scenario: Newly added dataset shows successful in validation functionality [C1255657] 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views1.userName}" as username "${views1.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Views Portal" Page is displayed 
	When Select "Dataset" dropdown option 
	Then Verify "Dataset Management" window is displayed in the dialog 
	When Click on Add button in Group Collection Management 
	Then Verify "Add Dataset" tab is displayed 
	When Input "Testdataset" in "Dataset" field in Group Management 
	When Input "VIEWS" in "Database" field in Group Management 
	When Input "VUSER1" in "User" field in Group Management 
	When Input "VUSER1" in "Password" field in Group Management 
	When Input "jdbc:oracle:thin:@localhost:1521:VIEWS" in "URL" field in Group Management 
	And Click on "Save" button in Group Collection 
	Then Verify "Info" page is displayed 
	Then Verify "The dataset is created successfully" text shown in the popup 
	When Click on "OK" button in info popup 
	Then Verify "Testdataset" Dataset are listed 
	When Click on "Testdataset" group name 
	When Click on Validate Dataset button in the header 
	Then Verify "Info" page is displayed 
	Then Verify "validated successfully" text shown in the popup 
	When Click on "OK" button in info popup 
	When Click on OK button in About View Portal Window 
	Then Verify "Dataset Management" Portal is closed 
	When Click on "Log Out" option 
	Then  Verify "Business Rule Checker" window is closed 