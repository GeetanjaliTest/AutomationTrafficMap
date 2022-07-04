Feature: Baseline Chnage Request 

Background: 
	Given user navigates to URL : "${savvion.url}" application 
	
	#TC-C1262719
@HealthCheck @BCR 
Scenario: Display the BCR Administration page [C1262719] 
	When I login using "${savvion.userName}" as username "${savvion.password}" as password and "${savvion.dataset}" as DataSet 
	Then Verify Login is successful and "Manage BCR" Page is displayed in Savvion 
	When Click on "Administration" tab from header menu 
	Then Verify "Administration" page is opened 
	When Click on "Logout" option of the savvion portal 
	Then Verify Logout is successful 
	
	#TC-C954276
@SmokeSuite @BCR 
Scenario: Create a BCR [C954276] 
	When I login using "${savvion.userName}" as username "${savvion.password}" as password and "${savvion.dataset}" as DataSet 
	Then Verify Login is successful and "Manage BCR" Page is displayed in Savvion 
	When Click on "Create BCR" button in Views Process Management Page 
	Then Verify "Baseline Change Request" overlay is displayed 
	When Select "Schedule and Cost Change" option value in "BCR Type:" field 
	Then Verify "Schedule and Cost Change" is selected in "BCR Type" field 
	When Select "VIEWS5-DEMO 3" option value in "Project Name:" field 
	Then Verify "VIEWS5-DEMO 3" is selected in "Project Name" field 
	When Input "Critical" in "Priority:" field in BCR 
	Then Verify "Critical" is selected in "Priority" field 
	When Select first option from "Trace Id:" field in BCR 
	And Store the selected option for "Trace Id:" field 
	When Input "BCR Test Category" in "Category:" field in BCR 
	Then Verify "BCR Test Category" is selected in "Category" field 
	When Click on "Create" button in BCR overlay 
	Then Verify "Confirmation !" window overlay is displayed 
	When Click on "OK" button in BCR overlay 
	Then Verify "Confirmation !" window overlay is displayed 
	When Click on "Ok" button in BCR overlay confirm 
	Then Verify "BaselineChangeRequest Tasks" overlay page is displayed 
	When Click on "Logout" option of the savvion portal 
	Then Verify Logout is successful 
	
	#TC-C954277
	#DependOn:TC-C954276
@SmokeSuite @BCR 
Scenario: Initialize a BCR [C954277] 
	When I login using "${savvion.userName}" as username "${savvion.password}" as password and "${savvion.dataset}" as DataSet 
	Then Verify Login is successful and "Manage BCR" Page is displayed in Savvion 
	When Click on "BCR Tasks" button in Views Process Management Page 
	Then Validate the "Initiate BCR Request#" is visible under Trace ID "0" and project "VIEWS5-DEMO 3" 
	When Click on the "Initiate BCR Request#" under Trace ID "0" and project "VIEWS5-DEMO 3" 
	Then Verify "Version" tab option is displayed 
	Then Verify "Cost Type" tab option is displayed 
	Then Verify "Control Account Estimates" panel overlay is displayed 
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
	When Click on "Save" button in BCR Tasks 
	Then Verify "BCR data has been saved successfully" message is shown 
	When Click on "Send For Approval" button in BCR Tasks 
	Then Verify "Confirmation !" window bcr overlay is displayed 
	When Click on "OK" button in BCR Tasks 
	Then Verify "Confirmation !" window bcr overlay is displayed 
	When Click on "Ok" button in BCR Tasks 
	Then Verify "Baseline Change Request" overlay page is displayed 
	When Click on "Logout" option of the savvion portal 
	Then Verify Logout is successful 
	
	#TC-C954278
	#DependOn:TC-C954277
@SmokeSuite @BCR 
Scenario: Approve a BCR [C954278] 
	When I login using "${savvion.pmuser}" as username "${savvion.password}" as password and "${savvion.dataset}" as DataSet 
	Then Verify Login is successful and "Manage BCR" Page is displayed in Savvion 
	When Click on "BCR Tasks" button in Views Process Management Page 
	Then Validate the "Approve BCR Request#" is visible under Trace ID "0" and project "VIEWS5-DEMO 3" 
	When Click on the "Approve BCR Request#" under Trace ID "0" and project "VIEWS5-DEMO 3" 
	Then Verify "Version" tab option is displayed 
	Then Verify "Cost Type" tab option is displayed 
	Then Verify "Control Account Estimates" panel overlay is displayed 
	When Click on "Approve" button in BCR Tasks 
	Then Verify "Confirmation !" window bcr overlay is displayed 
	And I click on "OK" button on Manage BCR page 
	Then Verify "Confirmation !" window bcr overlay is displayed 
	When I click on "OK" button on Manage BCR page again 
	Then Verify "Baseline Change Request" overlay page is displayed 
	When Click on "Manage BCR" button in Views Process Management Page 
	Then Verify the status "Modeling" is showing for "0" trace id 
	When Click on "Logout" option of the savvion portal 
	Then Verify Logout is successful