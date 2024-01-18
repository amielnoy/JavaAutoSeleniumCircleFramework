I've developed a robust automation framework that leverages Java, Selenium WebDriver, TestNG, Maven, and Allure Reports, providing a seamless testing experience. The framework supports parallel execution, enhancing efficiency and reducing testing time.

Key Features
Selenium WebDriver Integration: Harness the power of Selenium WebDriver for robust and reliable web automation.

TestNG Parallel Execution: Achieve faster test execution by parallelizing test cases using TestNG's parallel execution capabilities 

Maven Build Automation: Utilize Maven for streamlined project management, dependency resolution, and build automation 

Allure Reports Integration: Generate visually appealing and insightful reports with Allure, making it easy to analyze test results 

Run Tests
After cloning the repository and navigating to the directory
You can execute tests using Maven:
For Chrome: mvn clean test -Dbrowser=ch -Denv=test
For Firefox: mvn clean test -Dbrowser=ff -Denv=test [4].

Generate Allure Report

After the tests finish, type allure serve in the terminal.
Enjoy comprehensive test reports with screenshots for a detailed analysis [2].
