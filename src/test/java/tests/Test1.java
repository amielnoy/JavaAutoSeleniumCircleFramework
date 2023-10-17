package tests;

import Config.ConfigurationManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {

    @Test
    public void GetEnv() {
        String url = ConfigurationManager.GetInstance("test").GetProperty("url");
        Assert.assertEquals(url, "google.fr", "wrong url");
    }
}

