# About aurea-cxmonitor-testautomation Test Automation Framework

This framework is basically developed and designed to automate application product suite (formerly called Actional)test cases. 

# Work Flow
At a high level, the [Git Development Workflow](http://wiki.aurea.local/x/VYCCD) being followed is:

1. Create a branch
2. Do your work
3. Prepare feature / bug fix branch
 * Make sure commit history is clean 
4. Raise pull request to merge your branch into the main repo branches


# Tools , Approaches and Technologies Used

* Gherkin
* Core Java
* Selenium WebDriver API 3.3.1
* geckodriver 15
* Cucumber
* Page Object Model Design pattern
* Junit
* Maven
* Firefox 52 or lesser 


# How to Setup & Configure

  1. Install Eclipse ( any latest version will do )
  2. Install Maven plugin in ecplise if it is not present
  3. Use git clone to download the automation framework to your local system , GIT URL 

	https://github.com/trilogy-group/versata-artemisviews-qa-automation-main/tree/develop
	Note : Develop branch is the stable automation code branch as of now.

  4. Locate pom.XML and right click and choose Run As -> Maven Build
  5. In the run configurations provide below values and click apply and run.

		Goals : generate-resources
		Profiles: <profile-to-be-used>

  6. Check whether the build is successful
  7. Now , locate the Test file you want to execute.
   Basically each test file has one or more tag such as @RegressionSuite. When we run one of these test file all the features/scenarios belonging to that tag/s runs. All the test files are located under path "com.artemis.views.tests". For example to run GroupManagementTest.java file use below syntax
  
  mvn -DTest=GroupManagementTest test
  
  This step would launch the browser and launch the application and runs the scenarios written in <modulename>.feature files under resources/feature_files/ path.

  8. You can also execute the same using any IDE such as eclipse by just right clicking on same test file as mentioned above and run as -> Junit Test.
  9 To launch all of the test cases together one can use below command.
  
  mvn -DTest=MasterTest test
  
  This is basically going to run all Feature Files available at path src/test/resources/feature_files irrespective of their actual tag used. 