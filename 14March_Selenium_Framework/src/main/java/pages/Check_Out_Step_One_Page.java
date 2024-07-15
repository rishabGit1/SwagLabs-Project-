package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Check_Out_Step_One_Page extends TestBase
{
	@FindBy(xpath="//input[@id='first-name']") private WebElement firstnameTxtBox;
	@FindBy(xpath="//input[@id='last-name']") private WebElement lastnameTxtBox;
	@FindBy(xpath="//input[@id='postal-code']") private WebElement postalCodeTxtBox;
	@FindBy(xpath="//input[@id='continue']") private WebElement continueBtn;
	@FindBy(xpath = "//button[@id=\"cancel\"]")private WebElement cancleBBtn;
	@FindBy(xpath = "//span[text()='Checkout: Your Information']") private WebElement yourInfoText;
	public Check_Out_Step_One_Page()
	{
		PageFactory.initElements(driver,this);
	} 
	public String inputInformation()
	{
		firstnameTxtBox.sendKeys("Harry");
		lastnameTxtBox.sendKeys("Potter");
		postalCodeTxtBox.sendKeys("411032");
		continueBtn.click();
		return driver.getCurrentUrl();
	}
	public String verifyCanclebtn()
	{
		 cancleBBtn.click();
		 return driver.getCurrentUrl();
		
	}
	public String verifyYourInfoTxt()
	{
		return yourInfoText.getText();
	}
	
}
