package runner;

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


public class TestClass {

	WebDriver driver;
	
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
	}
	
	@Test
	public void testRunner()
	{
		TableForm tf=new TableForm(driver);
		tf.inputText();
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
	}
	}
	 
	
	

