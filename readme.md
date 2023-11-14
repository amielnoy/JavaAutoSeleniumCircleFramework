A ui automation framework with Java selenium and reporting with Allure reports 
to run with different browsers:
Chrome: mvn clean test -Dbrowser=ch -Denv=test
Firefox: mvn clean test -Dbrowser=ff -Denv=test

after the tests will finish type allure serve to see the report wit screenshot (all the tests fail for demonstration)
