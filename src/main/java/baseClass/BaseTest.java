package baseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseTest {

	WebDriver driver;
	
	public void clickOnElement(WebElement element)
	{
		element.click();
	}
	
	public void passValue(WebElement element,String text)
	{
	element.sendKeys(text);	
	}
	
	public void selectRadioButton(WebElement element)
	{
		if(element.isEnabled())
		{
			element.click();
		}
	}
}
