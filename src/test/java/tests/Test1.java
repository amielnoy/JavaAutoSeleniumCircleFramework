package tests;

import Config.ConfigurationManager;
import org.testng.annotations.Test;

public class Test1 {

    @Test
    public void GetEnv()
    {
        System.out.println(ConfigurationManager.GetInstance("test").GetProperty("url"));
    }
}
