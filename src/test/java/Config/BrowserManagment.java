package Config;

import org.openqa.selenium.WebDriver;

public class BrowserManagment {
    private WebDriver driver;

    private static BrowserManagment browserManagment=null;

    private BrowserManagment()
    {
        String name=System.getProperty("browser");


    }

    public static BrowserManagment GetInstance(){
        if (browserManagment==null){
            return new BrowserManagment();
        }
    }


}
