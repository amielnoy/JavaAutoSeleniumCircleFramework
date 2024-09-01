This is a robust automation framework that leverages Java, Selenium WebDriver,
TestNG, Gradle, and Allure Reports, providing a seamless testing experience.
The framework supports parallel execution,
enhancing efficiency and reducing testing time.

Key Features
Selenium WebDriver Integration: Harness the power of Selenium WebDriver for robust and reliable web automation.

TestNG Parallel Execution: Achieve faster test execution by parallelizing test cases using TestNG's parallel execution capabilities 

Gradle Build Automation:
Utilize Gradle for streamlined project management,
dependency resolution, and build automation 

Allure Reports Integration:
Generate visually appealing and insightful reports with Allure, making it easy to analyze test results 

Run Tests
After cloning the repository and navigating to the directory
You can execute tests using Gradle:
For Chrome: ./gradlew test

Running locally using docker:
1. docker build -t  gradle-java-selenium .
2. docker run  -it  gradle-java-selenium


Generate Allure Report

After the tests finish, type allure serve in the terminal.
Enjoy comprehensive test reports with screenshots for a detailed analysis [2].
