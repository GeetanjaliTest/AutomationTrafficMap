Feature: This feature is related to managing BCR with various scenarios 

Background: 
	Given user navigates to application URL : "${savvion.url}" application 
	
@HealthCheck @BCR 
Scenario Outline: Create a schedule and Cost only BCR [C1262716] 
	Given That I am on Savvion login page 
	When I login using "${savvion.userName}" as username "${savvion.password}" as password and "${savvion.dataset}" as DataSet 
	Then I should see Manage BCR page displayed 
	When I click on "Create BCR" button on Manage BCR page 
	Then I should see "Baseline Change Request" window displayed 
	When Select "<bcrType>" option value in "BCR Type:" field 
	When Select "<projectName>" option value in "Project Name:" field 
	When Input "<Priority>" in "Priority:" field in BCR 
	When Select first option from "Trace Id:" field in BCR 
	And Store the selected dropdown option for "Trace Id:" field 
	And I put "Health Test Category" value in category text field 
	When I click on "Create" button on Manage BCR page 
	Then I should see confirmation window 
	When I click on "OK" button on Manage BCR page 
	Then I should see confirmation window 
	When I click on "Ok" button on Manage BCR page 
	Then I should see BCR tasks window displayed 
	When I click on "Logout" button on Manage BCR page 
	Then I should see log out happened successfully 
	
	Examples: 
		|bcrType|projectName|Priority|
		|Schedule and Cost Change|VIEWS5-DEMO 3|Critical|
		|Cost Only Change|VIEWS5-DEMO 3|High|

#DependOn:TC-C1262716
@HealthCheck @BCR 
Scenario: Initiate a BCR and send it for approval [C1262717] 
#Initiate first BCR
Given That I am on Savvion login page 
When I login using "${savvion.userName}" as username "${savvion.password}" as password and "${savvion.dataset}" as DataSet 
Then I should see Manage BCR page displayed 
When I click on "BCR Tasks" button on Manage BCR page 
Then Validate "Initiate BCR Request#" is visible under Trace ID "0" and project "VIEWS5-DEMO 3" 
When Click on "Initiate BCR Request#" under Trace ID "0" and project "VIEWS5-DEMO 3" 
Then Verify "Version" tab option is displayed 
Then Verify "Cost Type" tab option is displayed 
Then Verify "Schedule Adjustment" tab option is displayed 
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
#Initiate second BCR
When I click on "BCR Tasks" button on Manage BCR page 
Then Validate "Initiate BCR Request#" is visible under Trace ID "1" and project "VIEWS5-DEMO 3" 
When Click on "Initiate BCR Request#" under Trace ID "1" and project "VIEWS5-DEMO 3" 
Then Verify "Cost Type" tab option is displayed 
When Expand "Cost Type" section 
When Select first option from "Replan Cost Type" field in BCR 
When Input "C1" in "Actual Cost Type" field in BCR 
When Select first option from "New Plan Cost Type" field in BCR 
When Input "B3" in "Earned Cost Type" field in BCR 
Then Verify "C1" is selected in "Actual Cost Type" field value 
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
			
			
#DependOn:TC-C1262717
@HealthCheck @BCR 
Scenario: Reject and Terminate a BCR [C1262718] 
#Reject first BCR (Schedule and Cost Change)
	Given That I am on Savvion login page 
	When I login using "${savvion.pmuser}" as username "${savvion.password}" as password and "${savvion.dataset}" as DataSet 
	Then I should see Manage BCR page displayed 
	When I click on "BCR Tasks" button on Manage BCR page 
	Then Validate "Approve BCR Request#" is visible under Trace ID "0" and project "VIEWS5-DEMO 3" 
	When Click on "Approve BCR Request#" under Trace ID "0" and project "VIEWS5-DEMO 3" 
	Then I should see "Cost Type" section displayed on My Tasks page 
	When I click on "Reject" button on My Tasks page 
	Then I should see confirmation window 
	When I enter "Health Reject Test" as comment in given dialog box 
	And I click on "OK" button on Manage BCR page 
	Then I should see confirmation window 
	When I click on "OK" button on Manage BCR page again 
	Then Verify "Baseline Change Request" overlay page is displayed 
#Terminate second BCR	(Cost Only Change)
	When I click on "BCR Tasks" button on Manage BCR page 
	Then Validate "Approve BCR Request#" is visible under Trace ID "1" and project "VIEWS5-DEMO 3" 
	When Click on "Approve BCR Request#" under Trace ID "1" and project "VIEWS5-DEMO 3" 
	Then I should see "Cost Type" section displayed on My Tasks page 
	When Click on "Terminate" button in BCR Tasks 
	Then I should see confirmation window 
	When I enter "Health Terminate Test" as comment in given dialog box 
	And I click on "OK" button on Manage BCR page 
	Then I should see confirmation window 
	When I click on "OK" button on Manage BCR page again 
	Then Verify "Baseline Change Request" overlay page is displayed
	When I click on "Logout" button on Manage BCR page 
	Then I should see log out happened successfully 