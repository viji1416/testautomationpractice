package baseClass;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BaseTest {

	WebDriver driver;
	WebDriverWait wait;
	
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
		else if(element.isDisplayed())
		{
		element.click();	
		}
	}
	
	
		public void selectDropdown(WebElement element, String selectionType, String value) {
	        try {
	            // Explicit wait until dropdown is visible
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            wait.until(ExpectedConditions.visibilityOf(element));

	            Select select = new Select(element);

	            if (selectionType.equalsIgnoreCase("text")) {
	                select.selectByVisibleText(value);
	            } else if (selectionType.equalsIgnoreCase("value")) {
	                select.selectByValue(value);
	            } else if (selectionType.equalsIgnoreCase("index")) {
	                int index = Integer.parseInt(value);
	                select.selectByIndex(index);
	            } else {
	                Assert.fail("Unsupported selection type: " + selectionType);
	            }

	        } catch (Exception e) {
	            Assert.fail("Dropdown selection failed for type: " + selectionType 
	                        + " with value: " + value 
	                        + ". Error: " + e.getMessage());
	        }
		}
	
	
	public void selectMultipleDropdown(WebElement element,List<String> values)
	{
		Select multipleSelect=new Select(element);
		if(multipleSelect.isMultiple())
		{
		for(String value:values)
		{
			if(value.matches("\\d+"))
			{
				multipleSelect.selectByValue(value);
			}
			else
			{
				multipleSelect.selectByVisibleText(value);
			}
		}
		}
		else
		{
			throw new UnsupportedOperationException("Dropdown does not support multiple selection");
		}
		}
	
	public WebElement explicitWait(WebElement element, String conditionType, int timeout) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

	    if (conditionType.equalsIgnoreCase("visible")) {
	        return wait.until(ExpectedConditions.visibilityOf(element));
	    } 
	    else if (conditionType.equalsIgnoreCase("clickable")) {
	        return wait.until(ExpectedConditions.elementToBeClickable(element));
	    } 
	    else if (conditionType.equalsIgnoreCase("present")) {
	        // For presence, you need a locator instead of WebElement
	        throw new IllegalArgumentException("Use locator-based method for 'present' condition");
	    } 
	    else {
	        throw new UnsupportedOperationException("Condition type not supported: " + conditionType);
	    }
	}

	}

