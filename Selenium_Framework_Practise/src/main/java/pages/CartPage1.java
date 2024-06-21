package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.TestBase1;

public class CartPage1 extends TestBase1
{

	@FindBy(xpath = "//div[@class=\"app_logo\"]") private WebElement cartPageSwagLabsTxt;
	@FindBy(xpath = "//span[text()='Your Cart']") private WebElement cartPageYourCartTitle;
	@FindBy(xpath = "//div[text()='Description']")private WebElement cartPageDescriptiontxt;
	@FindBy(xpath = "//button[text()='Checkout']") private WebElement ClickOnCheckOut;
	
	
	public String verifyCartPageURL()
	{
		return driver.getCurrentUrl();
		
	}
	public String ClickOnCheckout()
	{
		 ClickOnCheckOut.click();
		return driver.getCurrentUrl();
		
	}
	
	
	
	
}
