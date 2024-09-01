package tests.DataProviders;

import org.testng.annotations.DataProvider;

public class ArrayDataProvider {
    @DataProvider(name = "loginData")
    public Object[][] provideLoginData() {
        return new Object[][] {
                {"user1", "pass1"},
                {"user2", "pass2"},
                {"user3", "pass3"}
        };
    }


}
