A UI automation framework with Java Selenium and reporting with Allure reports 
to run with different browsers:
Chrome: mvn clean test -Dbrowser=ch -Denv=test
Firefox: mvn clean test -Dbrowser=ff -Denv=test

after the tests finish type "allure serve" to see the report with a screenshot 
