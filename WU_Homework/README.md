Homework Testing Project with Cucumber and Page Object Model
Overview
This project is a Java-based testing framework that utilizes Cucumber for test scenarios and follows the Page Object Model (POM) design pattern for better test maintenance and reusability. It includes UI tests with separate step definitions.

Installation and Setup
Download zip file.
Make sure you have Java JDK installed.
Install necessary dependencies using Maven or your preferred build tool.
Running Tests
API Tests
To run the API tests, execute the Runner.java file. This generates only a simple cucumber html/xml/json reports under Target file.

UI Tests
To run the UI tests, execute the Runner.java file. This generates only a simple cucumber html/xml/json reports under Target file.

Detailed Extent Report
To generate a detailed extent report for any tests, use the TestRunnerExtentReport.java file. You should provide the tag name of test scenarios in TestRunnerExtentReport.java. The detailed extent report will be generated automatically under the project directory with exact date and time of running tests.


Hooks Class
The Hooks class in this Cucumber test automation project contains hooks that facilitate test setup and teardown tasks for both API and UI scenarios. It utilizes annotations from Cucumber (@Before and @After) to execute specific methods before and after scenario execution.

Key Features and Functions
Scenario Printing:
The before method with the @Before annotation is executed before each UI scenario. It prints the name of the scenario to the console to indicate the start of the scenario.

Request Specification Initialization (API):
The setUp method with the @Before annotation is executed before each API scenario. It initializes the RequestSpecification named spec using the base URL from the ConfigReader. This spec can be used in API test steps to build and execute HTTP requests.

Screenshot Capture and Failure Handling (UI):
The tearDown method with the @After annotation is executed after each UI scenario. If the scenario fails, it captures a screenshot of the browser and attaches it to the report. Additionally, the scenario status is printed to the console.

Scenario Execution Logging:
The after method with the @After annotation is executed after each API scenario. It logs the scenario status to the console.

Writing Scenario Results to Excel:
Both the tearDown and after methods write the scenario details, including the scenario name and status, to an Excel file using the ExcelUtil.writeScenarioToExcel(scenario) method.

Usage
To use the hooks defined in the Hooks class, you need to specify the relevant Cucumber tags (@UI or @Api) for each scenario in your feature files. For UI scenarios, the tests with @UI will be executed, and for API scenarios, the tests with @Api tag will be executed.

Note
The @Before and @After annotations are used from io.cucumber.java package. The Driver class is used to manage the WebDriver instance, and ReusableMethods class provides utility methods for taking screenshots. The ExcelUtil class is utilized to write scenario details to an Excel file.