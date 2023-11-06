package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class utils {

    public static String CaptureErrorPage(String testName, WebDriver driver) throws IOException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime now = LocalDateTime.now();
        String datetime = dtf.format(now);
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String fileName = testName + "_" + datetime + ".png";
        File ScreenShotPath=new File("src/test/screenshots/" + fileName);
        FileUtils.copyFile(screenshot,ScreenShotPath );
        return ScreenShotPath.getAbsolutePath();

    }
}
