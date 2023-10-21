package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GoogleTest1;

public class Login1Test extends BaseTest {
    WebDriver driver=GetDriver();
    @Test
    public void GoodLogin()
    {
        GoogleTest1 login = new GoogleTest1(driver);
        //valid email and valid password
        String user = login.doLogin("test_viva@test.com", "123456");
        Assert.assertEquals(user, "viva test");

    }

}
