package runner;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageClass.TableForm;
import utilities.ConfigReader;
import utilities.ScreenshotUtils;


public class TestClass {

	WebDriver driver;
	ScreenshotUtils screenshotUtils;
	
	@BeforeTest
	public void setUp()
	{
		ConfigReader config=new ConfigReader();
		
		String browser=config.getProperty("browser");
		String url=config.getProperty("url");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
		driver=new ChromeDriver();
		
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
			
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		screenshotUtils = new ScreenshotUtils(driver);
	}
	
	@Test
	public void testRunner()
	{
		TableForm tf=new TableForm(driver);
		tf.inputText();
		screenshotUtils.takeScreenshot("FormFilled");
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
	}
	}
	 
	
	

