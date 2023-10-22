package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GoogleMainPage;

public class Login1Test extends BaseTest {

    @Test
    public void GoodLogin()
    {
        GoogleMainPage login = new GoogleMainPage(driver);
        //valid email and valid password
        String user = login.doLogin("test_viva@test.com", "123456");
        Assert.assertEquals(user, "viva test");

    }

}
