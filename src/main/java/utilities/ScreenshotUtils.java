package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtils {

	private WebDriver driver;

	public ScreenshotUtils(WebDriver driver) {
        this.driver = driver;
    }

    public String takeScreenshot(String fileNamePrefix) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String dirPath = System.getProperty("user.dir") + "/screenshots";
        String filePath = dirPath + "/" + fileNamePrefix + "_" + timestamp + ".png";

        try {
            // ✅ Ensure directory exists
            File dir = new File(dirPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(srcFile, new File(filePath));
            System.out.println("Screenshot saved at: " + filePath);
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }

        return filePath;
    }
}