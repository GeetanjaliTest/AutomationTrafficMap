Feature: This feature is related to Views Portal regression test cases with various scenarios 

Background: 
	Given user navigates to application URL : "${views.url}" application 


@SmokeSuite @BCR
Scenario: Run Business Rules Checker Before Creating a BCR Fail [C1118806] 
	Given I am on Views Login Page
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	When Click on "Administration" from left side menu panel
	When Click on "Operations" from left side menu panel
	Then Verify "Operations" page is opened for "Operations" option
	When Click "Enabled" button if it is "Disabled"
	And Verify "Enabled" button is displayed
	And Select "BCR PRE-CREATE" operation from list of operations
	And I click "Edit" button on operations list page
	And Select "Schedule Metrics" on Group Collection column of opened Edit operation
	And Select "Yes" for Enabled Column of opened Edit Operation
	And I click "Update" button on operations list page
	Then Verify "Schedule Metrics" for Group Collection and "Yes" for enabled column visible for "BCR PRE-CREATE" operation
	When Click on "Group" from left side menu panel under option 
	When Click on "IMS" group name 
	And Click on Edit button in Group Management page 
	When Input "9" in "Acceptable" field in Group Management 
	When Input "8" in "Tolerable" field in Group Management 
	And Click on "Save" button in Group Collection 
	When Click on "Log Out" option 
	Then  Verify "Business Rule Checker" window is closed 
	When I open a New Browser Tab for logging into Savvion Portal 
	And user navigates to application URL : "${savvion.url}" application
	And That I am on Savvion login page
	When I login using "${savvion.userName}" as username "${savvion.password}" as password and "${savvion.dataset}" as DataSet
	Then Verify Login is successful and "Manage BCR" Page is displayed in Savvion 
	When Click on "Create BCR" button in Views Process Management Page 
	Then Verify "Baseline Change Request" overlay is displayed 
	When Select "Schedule and Cost Change" option value in "BCR Type:" field 
	Then Verify "Schedule and Cost Change" is selected in "BCR Type" field 
	When Select "VIEWS5-DEMO 3" option value in "Project Name:" field 
	Then Verify "VIEWS5-DEMO 3" is selected in "Project Name" field 
	When Input "High" in "Priority:" field in BCR 
	Then Verify "High" is selected in "Priority" field 
	When Select first option from "Trace Id:" field in BCR 
	When Input "BCR" in "Category:" field in BCR 
	Then Verify "BCR" is selected in "Category" field 
	When Click on "Create" button in BCR overlay 
	Then Verify "Confirmation !" window overlay is displayed 
	When Click on "OK" button in BCR overlay 
	Then Verify "Business Rule Check Failed" window overlay is displayed 
	When Click on "Ok" button in BCR overlay confirm 
	Then Verify "Baseline Change Request" overlay is displayed 
	When I click on "Cancel" button on Create BCR page
	Then Verify "BaselineChangeRequest Tasks" overlay page is displayed 
	When Click on "Logout" option of the savvion portal 
	Then Verify Logout is successful 
	
@SmokeSuite @BCR
Scenario: Run Business Rules Checker Before Creating a BCR (Pass) [C1118830] 
	Given I am on Views Login Page
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	When Click on "Administration" from left side menu panel
	When Click on "Operations" from left side menu panel
	Then Verify "Operations" page is opened for "Operations" option
	When Click "Enabled" button if it is "Disabled"
	And Verify "Enabled" button is displayed
	Then Verify "Schedule Metrics" for Group Collection and "Yes" for enabled column visible for "BCR PRE-CREATE" operation
	When Click on "Group" from left side menu panel under option 
	When Click on "IMS" group name 
	And Click on Edit button in Group Management page 
	When Input "7" in "Acceptable" field in Group Management 
	When Input "5" in "Tolerable" field in Group Management 
	And Click on "Save" button in Group Collection 
	Then Verify "IMS" is visible in group list 	
	When Click on "Log Out" option 
	Then  Verify "Business Rule Checker" window is closed 
	When I open a New Browser Tab for logging into Savvion Portal 
	And user navigates to application URL : "${savvion.url}" application
	And That I am on Savvion login page
	When I login using "${savvion.userName}" as username "${savvion.password}" as password and "${savvion.dataset}" as DataSet
	Then Verify Login is successful and "Manage BCR" Page is displayed in Savvion 
	When Click on "Create BCR" button in Views Process Management Page 
	Then Verify "Baseline Change Request" overlay is displayed 
	When Select "Schedule and Cost Change" option value in "BCR Type:" field 
	Then Verify "Schedule and Cost Change" is selected in "BCR Type" field 
	When Select "VIEWS5-DEMO 3" option value in "Project Name:" field 
	Then Verify "VIEWS5-DEMO 3" is selected in "Project Name" field 
	When Input "High" in "Priority:" field in BCR 
	Then Verify "High" is selected in "Priority" field 
	When Select first option from "Trace Id:" field in BCR 
	And Store the selected option from dropdown for "Trace Id:" field
	When Input "BCR" in "Category:" field in BCR 
	Then Verify "BCR" is selected in "Category" field 
	When Click on "Create" button in BCR overlay 
	Then Verify "Confirmation !" window overlay is displayed 
	When Click on "OK" button in BCR overlay 
	Then Verify "Confirmation !" window overlay is displayed 
	When Click on "Goto Initiate BCR" button in BCR overlay confirm 
	Then Verify Login is successful and "BCR Tasks" Page is displayed in Savvion 
	When Expand "Version" section 
	When Select first option from "Model Version:" field in BCR 
	When Select first option from "Model Backup Version:" field in BCR 
	When Select "99" in "Baseline Version:" field 
	When Select first option from "Proposed Baseline Version:" field in BCR 
	Then Verify "99" is selected in "Baseline Version:" field value 
	When Expand "Cost Type" section 
	When Select first option from "Replan Cost Type" field in BCR 
	When Input "A1" in "Actual Cost Type" field in BCR 
	When Select first option from "New Plan Cost Type" field in BCR 
	When Input "B3" in "Earned Cost Type" field in BCR 
	Then Verify "A1" is selected in "Actual Cost Type" field value 
	Then Verify "B3" is selected in "Earned Cost Type" field value 
	When Expand "Schedule Adjustment" section 
	When Select "SPA" option value in "Type:" field 
	When Click on "Save" button in BCR Tasks 
	Then Verify "BCR data has been saved successfully" message is shown 
	When Click on "Send For Approval" button in BCR Tasks 
	Then Verify "Confirmation !" window bcr overlay is displayed 
	When Click on "OK" button in BCR Tasks 
	Then Verify "Confirmation !" window bcr overlay is displayed 
	When Click on "Ok" button in BCR Tasks 
	Then Verify "Baseline Change Request" overlay page is displayed 
	When Click on "Manage BCR" button in Views Process Management Page 
	Then Verify the status "Initiated" is showing for "0" trace id for PM
	When Click on "Logout" option of the savvion portal 
	Then Verify Logout is successful 
	

@RegressionSuite @BCR
Scenario: Run Business Rules Checker Before Creating a BCR (Fail) [C1199848] 
	Given I am on Views Login Page
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	When Click on "Administration" from left side menu panel
	When Click on "Operations" from left side menu panel
	Then Verify "Operations" page is opened for "Operations" option
	When Click "Enabled" button if it is "Disabled"
	And Verify "Enabled" button is displayed
	And Select "BCR PRE-CREATE" operation from list of operations
	And I click "Edit" button on operations list page
	And Select "Schedule Metrics_Fail" on Group Collection column of opened Edit operation
	And Select "Yes" for Enabled Column of opened Edit Operation
	And I click "Update" button on operations list page
	Then Verify "Schedule Metrics_Fail" for Group Collection and "Yes" for enabled column visible for "BCR PRE-CREATE" operation
	When Click on "Log Out" option 
	Then  Verify "Business Rule Checker" window is closed 
	When I open a New Browser Tab for logging into Savvion Portal 
	And user navigates to application URL : "${savvion.url}" application
	And That I am on Savvion login page
	When I login using "${savvion.userName}" as username "${savvion.password}" as password and "${savvion.dataset}" as DataSet
	Then Verify Login is successful and "Manage BCR" Page is displayed in Savvion 
	When Click on "Create BCR" button in Views Process Management Page 
	Then Verify "Baseline Change Request" overlay is displayed 
	When Select "Schedule and Cost Change" option value in "BCR Type:" field 
	Then Verify "Schedule and Cost Change" is selected in "BCR Type" field 
	When Select "VIEWS5-DEMO 3" option value in "Project Name:" field 
	Then Verify "VIEWS5-DEMO 3" is selected in "Project Name" field 
	When Input "High" in "Priority:" field in BCR 
	Then Verify "High" is selected in "Priority" field 
	When Select first option from "Trace Id:" field in BCR 
	When Input "BCR" in "Category:" field in BCR 
	Then Verify "BCR" is selected in "Category" field 
	When Click on "Create" button in BCR overlay 
	Then Verify "Confirmation !" window overlay is displayed 
	When Click on "OK" button in BCR overlay 
	Then Verify "Business Rule Check Failed" window overlay is displayed 
	When Click on "Ok" button in BCR overlay confirm 
	Then Verify "Baseline Change Request" overlay is displayed 
	When I click on "Cancel" button on Create BCR page 
	Then Verify "BaselineChangeRequest Tasks" overlay page is displayed 
	When Click on "Logout" option of the savvion portal 
	Then Verify Logout is successful 
	
	
@RegressionSuite @BCR
Scenario: Run Business Rules Checker Before Creating a BCR Pass [C1199849] 
	Given I am on Views Login Page
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	When Click on "Administration" from left side menu panel 
	When Click on "Operations" from left side menu panel 
	Then Verify "Operations" page is opened for "Operations" option 
	When Click "Enabled" button if it is "Disabled"
	And Verify "Enabled" button is displayed 
	And Select "BCR PRE-CREATE" operation from list of operations 
	And I click "Edit" button on operations list page 
	And Select "Schedule Metrics" on Group Collection column of opened Edit operation 
	And Select "Yes" for Enabled Column of opened Edit Operation 
	And I click "Update" button on operations list page 
	Then Verify "Schedule Metrics" for Group Collection and "Yes" for enabled column visible for "BCR PRE-CREATE" operation 
	When I open a New Browser Tab for logging into Savvion Portal 
	And user navigates to application URL : "${savvion.url}" application
	And That I am on Savvion login page
	When I login using "${savvion.userName}" as username "${savvion.password}" as password and "${savvion.dataset}" as DataSet
	Then Verify Login is successful and "Manage BCR" Page is displayed in Savvion 
	When Click on "Create BCR" button in Views Process Management Page 
	Then Verify "Baseline Change Request" overlay is displayed 
	When Select "Schedule and Cost Change" option value in "BCR Type:" field 
	Then Verify "Schedule and Cost Change" is selected in "BCR Type" field 
	When Select "VIEWS5-DEMO 3" option value in "Project Name:" field 
	Then Verify "VIEWS5-DEMO 3" is selected in "Project Name" field 
	When Input "High" in "Priority:" field in BCR 
	Then Verify "High" is selected in "Priority" field 
	When Select first option from "Trace Id:" field in BCR 
	And Store the selected option from dropdown for "Trace Id:" field value
	When Input "BCR" in "Category:" field in BCR 
	Then Verify "BCR" is selected in "Category" field 
	When Click on "Create" button in BCR overlay 
	Then Verify "Confirmation !" window overlay is displayed 
	When Click on "OK" button in BCR overlay 
	Then Verify "Confirmation !" window overlay is displayed 
	When Click on "Goto Initiate BCR" button in BCR overlay confirm 
	Then Verify Login is successful and "BCR Tasks" Page is displayed in Savvion
	When Expand "Version" section 
	When Select first option from "Model Version:" field in BCR 
	When Select first option from "Model Backup Version:" field in BCR 
	When Select "99" in "Baseline Version:" field 
	When Select first option from "Proposed Baseline Version:" field in BCR 
	Then Verify "99" is selected in "Baseline Version:" field value 
	When Expand "Cost Type" section 
	When Select first option from "Replan Cost Type" field in BCR 
	When Input "A1" in "Actual Cost Type" field in BCR 
	When Select first option from "New Plan Cost Type" field in BCR 
	When Input "B3" in "Earned Cost Type" field in BCR 
	Then Verify "A1" is selected in "Actual Cost Type" field value 
	Then Verify "B3" is selected in "Earned Cost Type" field value 
	When Expand "Schedule Adjustment" section 
	When Select "SPA" option value in "Type:" field 
	When Click on "Save" button in BCR Tasks 
	Then Verify "BCR data has been saved successfully" message is shown 
	When Click on "Send For Approval" button in BCR Tasks 
	Then Verify "Confirmation !" window bcr overlay is displayed 
	When Click on "OK" button in BCR Tasks 
	Then Verify "Confirmation !" window bcr overlay is displayed 
	When Click on "Ok" button in BCR Tasks 
	Then Verify "Baseline Change Request" overlay page is displayed 
	When Click on "Manage BCR" button in Views Process Management Page 
	Then Validate the status "Initiated" is showing for "0" trace id for PM
	When Click on "Logout" option of the savvion portal 
	Then Verify Logout is successful 
	
	#DependOn: TC:C1199849
@RegressionSuite @BCR
Scenario: Run Business Rules Checker Before Approving a BCR Pass [C1212195] 
	Given I am on Views Login Page
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	When Click on "Administration" from left side menu panel 
	When Click on "Operations" from left side menu panel 
	Then Verify "Operations" page is opened for "Operations" option 
	When Click "Enabled" button if it is "Disabled"
	And Verify "Enabled" button is displayed 
	And Select "BCR PRE-APPROVAL" operation from list of operations 
	And I click "Edit" button on operations list page 
	And Select "Schedule Metrics" on Group Collection column of opened Edit operation 
	And Select "Yes" for Enabled Column of opened Edit Operation 
	And I click "Update" button on operations list page 
	Then Verify "Schedule Metrics" for Group Collection and "Yes" for enabled column visible for "BCR PRE-APPROVAL" operation 
	When Click on "Log Out" option 
	Then  Verify "Business Rule Checker" window is closed 
	When user navigates to application URL : "${savvion.url}" application
	And That I am on Savvion login page
	When I login using "${savvion.pmuser}" as username "${savvion.password}" as password and "${savvion.dataset}" as DataSet
	Then Verify Login is successful and "Manage BCR" Page is displayed in Savvion 
	When Click on "BCR Tasks" button in Views Process Management Page 
	Then Validate the "Approve BCR Request#" is displayed under Trace ID "0" and project "VIEWS5-DEMO 3" 
	When Click on the "Approve BCR Request#" under Trace ID "0" and project name "VIEWS5-DEMO 3" 
	Then Verify "Version" tab option is displayed 
	Then Verify "Cost Type" tab option is displayed 
	Then Verify "Schedule Adjustment" tab option is displayed
	When Click on "Approve" button in BCR Tasks 
	Then Verify "Confirmation !" window bcr overlay is displayed 
	And I click on "OK" button on Manage BCR page 
	Then Verify "Confirmation !" window bcr overlay is displayed 
	When I click on "OK" button on Manage BCR page again 
	Then Verify "Baseline Change Request" overlay page is displayed 
	When Click on "Logout" option of the savvion portal 
	Then Verify Logout is successful