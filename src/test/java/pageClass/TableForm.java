package pageClass;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.BaseTest;
import runner.TestClass;


public class TableForm  extends BaseTest{
	
	WebDriver driver;
	
	public TableForm(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@placeholder='Enter Name']")
	WebElement name;
	
	@FindBy(xpath="//input[@placeholder=\"Enter EMail\"]")
	WebElement mail;
	
	@FindBy(xpath="//input[@placeholder=\"Enter Phone\"]")
	WebElement phone;
	
	@FindBy(id="textarea")
	WebElement address;
	
	@FindBy(id="female")
	WebElement gender;
	
	@FindBy(id="monday")
	WebElement day;
	
	@FindBy(id="country")
	WebElement country;
	
	@FindBy(id="colors")
	WebElement colors;
	
	
	public void inputText()
	{
		passValue(name,"Vijayalakshmi");
		passValue(mail,"viji@gmail.com");
		passValue(phone,"1234456");
		passValue(address,"New Street");
		selectRadioButton(gender);
		clickOnElement(day);
		selectDropdown(country,"value","canada");
		
		selectMultipleDropdown(colors,Arrays.asList("Red", "Green"));
	}
	
}
