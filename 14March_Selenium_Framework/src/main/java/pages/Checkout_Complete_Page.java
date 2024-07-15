package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Checkout_Complete_Page extends TestBase
{

	@FindBy(xpath = "//span[text()='Checkout: Complete!']") private WebElement checkoutCompletePageTitle;
	@FindBy(xpath = "//img[@class=\"pony_express\"]") private WebElement image ;
	@FindBy(xpath = "//h2[text()='Thank you for your order!']") private WebElement thankyouTxt ;
	@FindBy(xpath = "//div[text()='Your order has been dispatched, and will arrive just as fast as the pony can get there!']") private WebElement paraText;
	@FindBy(xpath = "//button[text()='Back Home']") private WebElement backHomebtn ;
	@FindBy(xpath = "//button[text()='Open Menu']") private WebElement menuBtn ;

	public Checkout_Complete_Page()
	{
		PageFactory.initElements(driver,this);
	}
	public String verifyCompletepageURL()
	{
		return driver.getCurrentUrl();
		
	}
	public String verifyCompletePageTitle()
	{
		return checkoutCompletePageTitle.getText();
		
	}
	public boolean verifyImage()
	{
		return image.isDisplayed();
		
	}
	public String verifyThankYouTxt() 
	{
		return thankyouTxt.getText();
		
	}
	public String verifyParagraphTxt()
	{
		return paraText.getText();
		
	}
	public String verifyBackHomebtn()
	{
		backHomebtn.click();
		return driver.getCurrentUrl();
	}
	public String verifyMenubtn()
	{
		menuBtn.click();
		return driver.getCurrentUrl();
	}
	
	
	
	
	
	
	
	
}
